package com.jeewms.www.wms.ui.acitivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.alibaba.fastjson.JSONObject;
import com.android.volley.VolleyError;
import com.jeewms.www.wms.R;
import com.jeewms.www.wms.base.BaseActivity;
import com.jeewms.www.wms.bean.bean.*;
import com.jeewms.www.wms.constance.Constance;
import com.jeewms.www.wms.ui.adapter.CKAdapter;
import com.jeewms.www.wms.ui.adapter.LlAdapter;
import com.jeewms.www.wms.ui.adapter.TLReceiptAdapter;
import com.jeewms.www.wms.ui.view.dialog.SyDialogHelper;
import com.jeewms.www.wms.ui.view.dialog.SyMessageDialog;
import com.jeewms.www.wms.util.*;
import com.jeewms.www.wms.volley.HTTPUtils;
import com.jeewms.www.wms.volley.VolleyListener;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.OnDismissCallback;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.text.SimpleDateFormat;
import java.util.*;

import static com.jeewms.www.wms.broadcast.SystemBroadCast.SCN_CUST_ACTION_SCODE;
import static com.jeewms.www.wms.broadcast.SystemBroadCast.SCN_CUST_EX_SCODE;

/**
 * Created by zhangzhr
 * Created Date 2020-05-20
 * 采购订单收货
 */

public class TLReceiptActivity extends BaseActivity implements OnDismissCallback, TLReceiptAdapter.DetailViewHolderListener, CKAdapter.DetailViewHolderListener, LlAdapter.DetailViewHolderListener {

    @BindView(R.id.sapreceipt_googlecards_listview)//收货单列表
            ListView mListView;
    @BindView(R.id.et_search)//扫描或者输入收货单编码
            AutoCompleteTextView etSearch;
    @BindView(R.id.btn_search)//搜索按钮
            Button btnSearch;
    @BindView(R.id.btn_OK)//确定按钮
            Button btnOK;
    @BindView(R.id.btn_Out)//取消按钮
            Button btnOut;
    @BindView(R.id.ll_scan)//搜索页面
            LinearLayout llscan;
    @BindView(R.id.rl_sap)//收货单页面
            RelativeLayout rlsap;
    @BindView(R.id.tv_shdbm)//收货单编码
            TextView tvshdbm;
    @BindView(R.id.cb_all)//全选按钮
            CheckBox cbAll;

    private TLReceiptAdapter mAdapter;//收货单列表适配器
    private List<RkWmsShdbEntity> dataList;//列表数据
    //出库
    private CKAdapter ckAdapter;
    private List<RkWmsCkdbEntity> ckList;
    //领料
    private LlAdapter llAdapter;
    private List<RkWmsScllEntity> llList;
    //判断选中子列的位置
    private int select_item;
    //进入的页面
    private int pageSize = 0;
    //分页按钮
    @BindView(R.id.btn_pre)//方式行
            Button mBtnPrePage;
    @BindView(R.id.btn_next)//方式行
            Button mBtnNextPage;
    //显示分页信息
    @BindView(R.id.tv_page)//方式行
            TextView mTvPageNo;
    //数据实现
    private PageHelper mPageDaoImpl;
    //被选着的索引
    private int selectIndex = 0;
    private static final int PREPAGE = 0;
    private static final int NEXTPAGE = 1;
    //是否为空
    private Boolean isNull = false;
    //条码
    private String scanBarcode;


    public static void show(Context context) {
        Intent intent = new Intent(context, TLReceiptActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initView() {
        super.initView();
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        mBtnLeft.setVisibility(View.VISIBLE);//左方向键
        //注册广播监听
        IntentFilter intentFilter = new IntentFilter(SCN_CUST_ACTION_SCODE);
        registerReceiver(scanDataReceiver, intentFilter);
        //设置表头名称
        setTitle("投料收货");

        //初始化
        select_item = -1;
        //获取所选子列位置
        mListView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                select_item = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                select_item = -1;
                mListView.setSelection(select_item);
            }
        });
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                select_item = position;
            }
        });
        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                select_item = firstVisibleItem - 1;
            }
        });
        //第一页
        pageSize = 1;
        //分页按钮
        mBtnPrePage = (Button) findViewById(R.id.btn_pre);
        mBtnPrePage.setTag(PREPAGE);
        mBtnNextPage = (Button) findViewById(R.id.btn_next);
        mBtnNextPage.setTag(NEXTPAGE);

    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(scanDataReceiver);
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    //广播监听
    private BroadcastReceiver scanDataReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(SCN_CUST_ACTION_SCODE)) {
                try {
                    String barCode = "";
                    scanBarcode = "";
                    barCode = intent.getStringExtra(SCN_CUST_EX_SCODE);
                    //判断条码是否为空
                    if (!StringUtil.isEmpty(barCode)) {
                        scanBarcode = barCode;
                        //判断单据类型
                        //送货单
                        if (barCode.substring(0, 1).equals("D") || barCode.substring(0, 1).equals("M")) {
                            getDate(barCode);
                            //出库单
                        } else if (barCode.substring(0, 1).equals("S")) {
                            getCKDate(barCode);
                            //领料单
                        } else if (barCode.substring(0, 1).equals("R")) {
                            getLLDate(barCode);
                        }
                    } else {
                        Toast.makeText(TLReceiptActivity.this, "请重新扫描", Toast.LENGTH_SHORT).show();
                        return;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("ScannerService", e.toString());
                }
            }
        }
    };

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void MessageEventBus(MessageEvent msg) {
        //查询收货单数据
        getDate(etSearch.getText().toString());
    }

    @Override
    protected int getContentResId() {
        return R.layout.activity_tlreceipt;
    }

    //获取收货单编码查询收货单数据添加列表内容
    private void getDate(String searchKey) {
        //加载动画开启
        LoadingUtil.showLoading(this);
        //SAP送货单接口
        Map<String, String> params = new HashMap<>();
        params.put("shdbh", searchKey);
        String url = SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.HTTPADDRESS) + Constance.getZrfcGetShw;
        HTTPUtils.post(this, url, params, new VolleyListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //加载动画关闭
                LoadingUtil.hideLoading();
                ToastUtil.show(TLReceiptActivity.this, "网络连接失败");
            }

            @Override
            public void onResponse(String response) {
                //加载动画关闭
                LoadingUtil.hideLoading();
                //将json对象转换为java对象
                SAPRkWmsListVm res = GsonUtils.parseJSON(response, SAPRkWmsListVm.class);
                //判断是否为空
                if (res.getOk()) {
                    if (res.getObj() != null && res.getObj().size() > 0) {
                        dataList = res.getObj();
                        //判断用户描述是否为空
                        if (StringUtil.isEmpty(dataList.get(0).getPtype())) {
                            SyDialogHelper.showErrorDlg(TLReceiptActivity.this, "", "该单据不能投料，请联系保管员处理", "确定");
                            return;
                        }
                        //全部选中
                        cbAll.setChecked(true);
                        //设置展示数据设置未选中
                        for (int i = 0; i < dataList.size(); i++) {
                            dataList.get(i).setChecked(true);
                            dataList.get(i).setJhsl(dataList.get(i).getMenge());
                        }

                        //每次读4条数据
                        mPageDaoImpl = new PageHelper<RkWmsShdbEntity>(dataList, 4);
                        //设置当前页码与总页码
                        mTvPageNo.setText(mPageDaoImpl.getCurrentPage() + " / " + mPageDaoImpl.getPageNum());

                        //添加数据到列表中
                        mAdapter = new TLReceiptAdapter(TLReceiptActivity.this, mPageDaoImpl.currentList(), TLReceiptActivity.this);
                        mAdapter.notifyDataSetChanged();
                        mListView.setAdapter(mAdapter);
                        //获取焦点
                        mListView.requestFocus();
                        mListView.setSelection(0);

                        //设置送货单编号
                        tvshdbm.setText(dataList.get(0).getPshwln());

                        //前往第二页
                        llscan.setVisibility(View.GONE);
                        rlsap.setVisibility(View.VISIBLE);
                        pageSize = 2;
                    } else {
                        Toast.makeText(TLReceiptActivity.this, "数据为空！", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(TLReceiptActivity.this, "未查询到送货单，请重新扫描！", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    //获取出库单编码查询出库单数据添加列表内容
    private void getCKDate(String searchKey) {
        //加载动画开启
        LoadingUtil.showLoading(this);
        //SAP送货单接口
        Map<String, String> params = new HashMap<>();
        params.put("djbh", searchKey);
        String url = SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.HTTPADDRESS) + Constance.getCKD;
        HTTPUtils.post(this, url, params, new VolleyListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //加载动画关闭
                LoadingUtil.hideLoading();
                ToastUtil.show(TLReceiptActivity.this, "网络连接失败");
            }

            @Override
            public void onResponse(String response) {
                //加载动画关闭
                LoadingUtil.hideLoading();
                //将json对象转换为java对象
                SAPRkCkListVm res = GsonUtils.parseJSON(response, SAPRkCkListVm.class);
                //判断是否为空
                if (res.getOk()) {
                    if (res.getObj() != null && res.getObj().size() > 0) {
                        ckList = res.getObj();
                        //判断用户描述是否为空
                        if (StringUtil.isEmpty(ckList.get(0).getStype1())) {
                            SyDialogHelper.showErrorDlg(TLReceiptActivity.this, "", "该单据不能投料，请联系保管员处理", "确定");
                            return;
                        }
                        //全部选中
                        cbAll.setChecked(true);
                        //设置展示数据设置未选中
                        for (int i = 0; i < ckList.size(); i++) {
                            ckList.get(i).setChecked(true);
                            ckList.get(i).setJhsl(ckList.get(i).getPpmen());
                        }

                        //每次读4条数据
                        mPageDaoImpl = new PageHelper<RkWmsCkdbEntity>(ckList, 4);
                        //设置当前页码与总页码
                        mTvPageNo.setText(mPageDaoImpl.getCurrentPage() + " / " + mPageDaoImpl.getPageNum());

                        //添加数据到列表中
                        ckAdapter = new CKAdapter(TLReceiptActivity.this, mPageDaoImpl.currentList(), TLReceiptActivity.this);
                        ckAdapter.notifyDataSetChanged();
                        mListView.setAdapter(ckAdapter);
                        //获取焦点
                        mListView.requestFocus();
                        mListView.setSelection(0);

                        //设置出库单编号
                        tvshdbm.setText(ckList.get(0).getNtnum());

                        //前往第二页
                        llscan.setVisibility(View.GONE);
                        rlsap.setVisibility(View.VISIBLE);
                        pageSize = 2;
                    } else {
                        Toast.makeText(TLReceiptActivity.this, "数据为空！", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(TLReceiptActivity.this, "未查询到出库单，请重新扫描！", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void getLLDate(String searchKey) {
        //加载动画开启
        LoadingUtil.showLoading(this);
        //SAP送货单接口
        Map<String, String> params = new HashMap<>();
        params.put("djbh", searchKey);
        String url = SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.HTTPADDRESS) + Constance.getLLD;
        HTTPUtils.post(this, url, params, new VolleyListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //加载动画关闭
                LoadingUtil.hideLoading();
                ToastUtil.show(TLReceiptActivity.this, "网络连接失败");
            }

            @Override
            public void onResponse(String response) {
                //加载动画关闭
                LoadingUtil.hideLoading();
                //将json对象转换为java对象
                SAPRkLlListVm res = GsonUtils.parseJSON(response, SAPRkLlListVm.class);
                //判断是否为空
                if (res.getOk()) {
                    if (res.getObj() != null && res.getObj().size() > 0) {
                        llList = res.getObj();
                        //全部选中
                        cbAll.setChecked(true);
                        //设置展示数据设置未选中
                        for (int i = 0; i < llList.size(); i++) {
                            llList.get(i).setChecked(true);
                            llList.get(i).setJhsl(llList.get(i).getRkSl());
                        }

                        //每次读4条数据
                        mPageDaoImpl = new PageHelper<RkWmsScllEntity>(llList, 4);
                        //设置当前页码与总页码
                        mTvPageNo.setText(mPageDaoImpl.getCurrentPage() + " / " + mPageDaoImpl.getPageNum());

                        //添加数据到列表中
                        llAdapter = new LlAdapter(TLReceiptActivity.this, mPageDaoImpl.currentList(), TLReceiptActivity.this);
                        llAdapter.notifyDataSetChanged();
                        mListView.setAdapter(llAdapter);
                        //获取焦点
                        mListView.requestFocus();
                        mListView.setSelection(0);

                        //设置送货单编号
                        tvshdbm.setText(llList.get(0).getRkLldbh());

                        //前往第二页
                        llscan.setVisibility(View.GONE);
                        rlsap.setVisibility(View.VISIBLE);
                        pageSize = 2;
                    } else {
                        Toast.makeText(TLReceiptActivity.this, "数据为空！", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(TLReceiptActivity.this, "未查询到送货单，请重新扫描！", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    @Override
    public void onDismiss(@NonNull ViewGroup listView, @NonNull int[] reverseSortedPositions) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    //搜索按钮
    @OnClick(R.id.btn_search)
    public void onViewClicked() {
        getDate(etSearch.getText().toString());
    }

    //全选按钮
    @OnClick(R.id.cb_all)
    public void onAllClicked() {
        if (cbAll.isChecked()) {
            checkAllItem();
        } else {
            uncheckAllItem();
        }
    }

    //分页按钮
    @OnClick({R.id.btn_pre, R.id.btn_next})
    public void onPageClicked(View view) {
        final int flag = (Integer) view.getTag();
        switch (flag) {
            case PREPAGE:// 上一页
                prePage();
                break;
            case NEXTPAGE:// 下一页
                nextPage();
                break;
        }

    }

    private void prePage() {
        if (selectIndex == 0) {
            if (mPageDaoImpl.getCurrentPage() >= 1) {
                mPageDaoImpl.prePage();
            }
            if (scanBarcode.substring(0, 1).equals("D") || scanBarcode.substring(0, 1).equals("M")) {
                mAdapter.setList(mPageDaoImpl.currentList());
            } else if (scanBarcode.substring(0, 1).equals("S")) {
                ckAdapter.setList(mPageDaoImpl.currentList());
            } else if (scanBarcode.substring(0, 1).equals("L")) {
                llAdapter.setList(mPageDaoImpl.currentList());
            }
            mListView.setSelection(0);
            mTvPageNo.setText(mPageDaoImpl.getCurrentPage() + " / " + mPageDaoImpl.getPageNum());
        } else {
            return;
        }
    }

    private void nextPage() {
        if (mPageDaoImpl.getCurrentPage() <= mPageDaoImpl.getPageNum()) {
            mPageDaoImpl.nextPage();
        }
        if (scanBarcode.substring(0, 1).equals("D") || scanBarcode.substring(0, 1).equals("M")) {
            mAdapter.setList(mPageDaoImpl.currentList());
        } else if (scanBarcode.substring(0, 1).equals("S")) {
            ckAdapter.setList(mPageDaoImpl.currentList());
        } else if (scanBarcode.substring(0, 1).equals("L")) {
            llAdapter.setList(mPageDaoImpl.currentList());
        }
        mListView.setSelection(0);
        mTvPageNo.setText(mPageDaoImpl.getCurrentPage() + " / " + mPageDaoImpl.getPageNum());
    }


    //取消按钮
    @OnClick(R.id.btn_Out)
    public void onOutClicked() {
        //返回第一页
        rlsap.setVisibility(View.GONE);
        llscan.setVisibility(View.VISIBLE);
        cbAll.setChecked(false);
        pageSize = 1;
    }

    //确定按钮 展示勾选的数据
    @OnClick(R.id.btn_OK)
    public void onOKClicked() {
        //判断单据类型
        //送货单
        if (scanBarcode.substring(0, 1).equals("D") || scanBarcode.substring(0, 1).equals("M")) {
            final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            final List<RkWmsShdbEntity> list = new ArrayList<>();
            //获取选中的数据
            for (int i = 0; i < dataList.size(); i++) {
                //判断是否勾选
                if (dataList.get(i).getChecked()) {
                    if (dataList.get(i).getMenge() == null || dataList.get(i).getMenge() <= 0.0 || StringUtil.isEmpty(dataList.get(i).getMenge().toString()) || dataList.get(i).getMenge() > dataList.get(i).getJhsl()) {
                        SyDialogHelper.showWarningDlg(this, "", "行项目为" + dataList.get(i).getInd() + ",收货数量不能为空或小于等于零,且收货数量不能大于交货数量！", "确定", null);
                        isNull = true;
                        break;
                    }
                    //添加数据操作人和时间
                    dataList.get(i).setSysOrgCode(SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.DEPT));
                    dataList.get(i).setSysCompanyCode(SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.DEPT));
                    dataList.get(i).setMname(SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.USERNAME));
                    dataList.get(i).setMdate((new Date()).getTime());
                    dataList.get(i).setPname(SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.USERNAME));
                    dataList.get(i).setUpdateBy(sdf.format(new Date()));
                    dataList.get(i).setUpdateName(SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.USERNAME));
                    list.add(dataList.get(i));
                }
            }

            if (!isNull) {
                //判断有没有选择行项目
                if (list.size() > 0 && list != null) {

                    //类型转换
                    String jsonString = com.alibaba.fastjson.JSONObject.toJSONString(list);
                    Map<String, String> params = new HashMap<>();
                    params.put("str", jsonString);//上传实体json
                    String url = SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.HTTPADDRESS) + Constance.getZrfcShwMgtl;

                    HTTPUtils.post(this, url, params, new VolleyListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            ToastUtil.show(TLReceiptActivity.this, "网络连接失败");
                        }

                        @Override
                        public void onResponse(String response) {
                            ResultDO res = GsonUtils.parseJSON(response, ResultDO.class);
                            if (res.isOk()) {
                                SyDialogHelper.showSuccessDlg(TLReceiptActivity.this, "", "收货成功", "确定", new SyMessageDialog.OnClickListener() {
                                    @Override
                                    public void onClick(SyMessageDialog dialog) {
                                        finish();
                                    }
                                });
                            } else {
                                SyDialogHelper.showErrorDlg(TLReceiptActivity.this, "", "收货失败", "确定");
                            }
                        }
                    });

                } else {
                    SyDialogHelper.showWarningDlg(this, "", "请选择数据", "确定", null);
                }
            } else {
                isNull = false;
            }
            //出库单
        } else if (scanBarcode.substring(0, 1).equals("S")) {
            final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            final List<RkWmsCkdbEntity> list = new ArrayList<>();
            //获取选中的数据
            for (int i = 0; i < ckList.size(); i++) {
                //判断是否勾选
                if (ckList.get(i).getChecked()) {
                    if (ckList.get(i).getPpmen() == null || ckList.get(i).getPpmen() <= 0.0 || StringUtil.isEmpty(ckList.get(i).getPpmen().toString()) || ckList.get(i).getPpmen() > ckList.get(i).getJhsl()) {
                        SyDialogHelper.showWarningDlg(this, "", "行项目为" + ckList.get(i).getInd() + ",收货数量不能为空或小于等于零,且收货数量不能大于交货数量！", "确定", null);
                        isNull = true;
                        break;
                    }
                    //添加数据操作人和时间
                    ckList.get(i).setSysOrgCode(SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.DEPT));
                    ckList.get(i).setSysCompanyCode(SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.DEPT));
                    ckList.get(i).setUpdateDate(new Date());
                    ckList.get(i).setUpdateBy(SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.LOGINNAME));
                    ckList.get(i).setUpdateName(SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.USERNAME));
                    list.add(ckList.get(i));
                }
            }

            if (!isNull) {
                //判断有没有选择行项目
                if (list.size() > 0 && list != null) {

                    //类型转换
                    String jsonString = com.alibaba.fastjson.JSONObject.toJSONString(list);
                    Map<String, String> params = new HashMap<>();
                    params.put("str", jsonString);//上传实体json
                    String url = SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.HTTPADDRESS) + Constance.saveCKDshtl;

                    HTTPUtils.post(this, url, params, new VolleyListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            ToastUtil.show(TLReceiptActivity.this, "网络连接失败");
                        }

                        @Override
                        public void onResponse(String response) {
                            ResultDO res = GsonUtils.parseJSON(response, ResultDO.class);
                            if (res.isOk()) {
                                SyDialogHelper.showSuccessDlg(TLReceiptActivity.this, "", "收货成功", "确定", new SyMessageDialog.OnClickListener() {
                                    @Override
                                    public void onClick(SyMessageDialog dialog) {
                                        finish();
                                    }
                                });
                            } else {
                                SyDialogHelper.showErrorDlg(TLReceiptActivity.this, "", "收货失败", "确定");
                            }
                        }
                    });

                } else {
                    SyDialogHelper.showWarningDlg(this, "", "请选择数据", "确定", null);
                }
            } else {
                isNull = false;
            }
            //领料单
        } else if (scanBarcode.substring(0, 1).equals("L")) {
            final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            final List<RkWmsScllEntity> list = new ArrayList<>();
            //获取选中的数据
            for (int i = 0; i < llList.size(); i++) {
                //判断是否勾选
                if (llList.get(i).getChecked()) {
                    if (llList.get(i).getRkSl() == null || llList.get(i).getRkSl() <= 0.0 || StringUtil.isEmpty(llList.get(i).getRkSl().toString()) || llList.get(i).getRkSl() > llList.get(i).getJhsl()) {
                        SyDialogHelper.showWarningDlg(this, "", "行项目为" + llList.get(i).getRkLldhxm() + ",收货数量不能为空或小于等于零,且收货数量不能大于交货数量！", "确定", null);
                        isNull = true;
                        break;
                    }
                    //添加数据操作人和时间
                    llList.get(i).setSysOrgCode(SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.DEPT));
                    llList.get(i).setSysCompanyCode(SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.DEPT));
                    llList.get(i).setCreateDate(null);
                    llList.get(i).setUpdateDate(null);
                    llList.get(i).setUpdateBy(SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.LOGINNAME));
                    llList.get(i).setUpdateName(SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.USERNAME));
                    list.add(llList.get(i));
                }
            }

            if (!isNull) {
                //判断有没有选择行项目
                if (list.size() > 0 && list != null) {

                    //类型转换
                    String jsonString = com.alibaba.fastjson.JSONObject.toJSONString(list);
                    Map<String, String> params = new HashMap<>();
                    params.put("str", jsonString);//上传实体json
                    String url = SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.HTTPADDRESS) + Constance.saveLLDTL;

                    HTTPUtils.post(this, url, params, new VolleyListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            ToastUtil.show(TLReceiptActivity.this, "网络连接失败");
                        }

                        @Override
                        public void onResponse(String response) {
                            ResultDO res = GsonUtils.parseJSON(response, ResultDO.class);
                            if (res.isOk()) {
                                SyDialogHelper.showSuccessDlg(TLReceiptActivity.this, "", "收货成功", "确定", new SyMessageDialog.OnClickListener() {
                                    @Override
                                    public void onClick(SyMessageDialog dialog) {
                                        finish();
                                    }
                                });
                            } else {
                                SyDialogHelper.showErrorDlg(TLReceiptActivity.this, "", "收货失败", "确定");
                            }
                        }
                    });

                } else {
                    SyDialogHelper.showWarningDlg(this, "", "请选择数据", "确定", null);
                }
            } else {
                isNull = false;
            }
        } else {
            SyDialogHelper.showWarningDlg(TLReceiptActivity.this, "", "单据不正确", "确定", null);
            return;
        }
    }

    //修改数据
    @Override
    public void setData(final TLReceiptAdapter.ViewHolder viewHolder, final int position) {
        //获取修改的子列对象
        final RkWmsShdbEntity bean = dataList.get(position);
        //勾选按钮 设置数据
        viewHolder.checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewHolder.checkbox.isChecked()) {
                    bean.setChecked(true);
                } else {
                    bean.setChecked(false);
                }
            }
        });
        //减号
        viewHolder.btn_jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double number = 0.0;
                if (StringUtil.isEmpty(viewHolder.number.getText().toString().trim())) {
                    SyDialogHelper.showWarningDlg(TLReceiptActivity.this, "", "数量不能为空", "确定", null);
                    return;
                } else {
                    if (Double.valueOf(viewHolder.number.getText().toString().trim()) <= 0.0) {
                        SyDialogHelper.showWarningDlg(TLReceiptActivity.this, "", "数量不能为负", "确定", null);
                        viewHolder.number.setText(0.0 + "");
                        return;
                    } else {
                        number = Double.valueOf(viewHolder.number.getText().toString().trim());
                    }
                }
                Double old = bean.getJhsl();
                if (Double.doubleToLongBits(DoubleUtil.sub(number, 1)) > Double.doubleToLongBits(old)) {
                    SyDialogHelper.showWarningDlg(TLReceiptActivity.this, "", "收货数量不能大于交货数量", "确定", null);
                } else {
                    viewHolder.number.setText("");
                    viewHolder.number.setText(DoubleUtil.sub(number, 1) + "");
                    dataList.get(position).setMenge(DoubleUtil.sub(number, 1));
                }
            }
        });
        //加号
        viewHolder.btn_jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double number = 0.0;
                if (StringUtil.isEmpty(viewHolder.number.getText().toString().trim())) {
                    number = 0.0;
                } else {
                    number = Double.valueOf(viewHolder.number.getText().toString().trim());
                }
                Double old = bean.getJhsl();
                if (Double.doubleToLongBits(DoubleUtil.sum(number, 1)) > Double.doubleToLongBits(old)) {
                    SyDialogHelper.showWarningDlg(TLReceiptActivity.this, "", "收货数量不能大于交货数量", "确定", null);
                } else {
                    viewHolder.number.setText("");
                    viewHolder.number.setText(DoubleUtil.sum(number, 1) + "");
                    dataList.get(position).setMenge(DoubleUtil.sum(number, 1));
                }
            }
        });

    }

    /*
     * 设置列表取消全选，并刷新列表
     */
    private void uncheckAllItem() {
        if (scanBarcode.substring(0, 1).equals("D") || scanBarcode.substring(0, 1).equals("M")) {
            for (int i = 0; i < dataList.size(); i++) {
                dataList.get(i).setChecked(false);
            }
            mAdapter.notifyDataSetChanged();
        } else if (scanBarcode.substring(0, 1).equals("s")) {
            for (int i = 0; i < ckList.size(); i++) {
                ckList.get(i).setChecked(false);
            }
            ckAdapter.notifyDataSetChanged();
        } else if (scanBarcode.substring(0, 1).equals("L")) {
            for (int i = 0; i < llList.size(); i++) {
                llList.get(i).setChecked(false);
            }
            llAdapter.notifyDataSetChanged();
        } else {
            return;
        }
    }

    /*
     * 设置列表全选，并刷新列表
     */
    public void checkAllItem() {
        if (scanBarcode.substring(0, 1).equals("D") || scanBarcode.substring(0, 1).equals("M")) {
            for (int i = 0; i < dataList.size(); i++) {
                dataList.get(i).setChecked(true);
            }
            mAdapter.notifyDataSetChanged();
        } else if (scanBarcode.substring(0, 1).equals("s")) {
            for (int i = 0; i < ckList.size(); i++) {
                ckList.get(i).setChecked(true);
            }
            ckAdapter.notifyDataSetChanged();
        } else if (scanBarcode.substring(0, 1).equals("L")) {
            for (int i = 0; i < llList.size(); i++) {
                llList.get(i).setChecked(true);
            }
            llAdapter.notifyDataSetChanged();
        } else {
            return;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        final int action = event.getAction();
        switch (keyCode) {
            case 19://上方向键
                // 移到上一项
                if (select_item > 0 && action == 0) {
                    mListView.setSelection(select_item - 1);
                }
                break;
            case 20://下方向键
                if (!StringUtil.isEmpty(scanBarcode)) {
                    if (scanBarcode.substring(0, 1).equals("D") || scanBarcode.substring(0, 1).equals("M")) {
                        if (select_item < dataList.size() - 1 && action == 0) {
                            mListView.setSelection(select_item + 1);
                        }
                    } else if (scanBarcode.substring(0, 1).equals("S")) {
                        if (select_item < ckList.size() - 1 && action == 0) {
                            mListView.setSelection(select_item + 1);
                        }
                    } else if (scanBarcode.substring(0, 1).equals("L")) {
                        if (select_item < llList.size() - 1 && action == 0) {
                            mListView.setSelection(select_item + 1);
                        }
                    } else {
                        break;
                    }
                }
                break;
            case 21://左方向键
                break;
            case 22://右方向键
                if (pageSize == 1) {
                    if (!StringUtil.isEmpty(etSearch.getText().toString().trim())) {
                        scanBarcode = etSearch.getText().toString().trim();
                        if ((etSearch.getText().toString().trim()).substring(0, 1).equals("D") || (etSearch.getText().toString().trim()).substring(0, 1).equals("M")) {
                            getDate(etSearch.getText().toString().trim());
                        } else if ((etSearch.getText().toString().trim()).substring(0, 1).equals("S")) {
                            getCKDate(etSearch.getText().toString().trim());
                        } else if ((etSearch.getText().toString().trim()).substring(0, 1).equals("L")) {
                            getLLDate(etSearch.getText().toString().trim());
                        } else {
                            break;
                        }
                    } else {
                        SyDialogHelper.showWarningDlg(TLReceiptActivity.this, "", "请输入单号", "确定", null);
                    }
                }
                break;
            case 0://扫描
                if (pageSize == 1) {
                    etSearch.setText("");
                }
                break;
            case 131://F1
                if (pageSize == 2) {
                    onOutClicked();
                }
                break;
            case 132://F2
                if (pageSize == 2) {
                    prePage();
                }
                break;
            case 133://F3
                if (pageSize == 2) {
                    nextPage();
                }
                break;
            case 134://F4
                if (pageSize == 2) {
                    onOKClicked();
                }
                break;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void setCKData(final CKAdapter.ViewHolder viewHolder, final int position) {
        //获取修改的子列对象
        final RkWmsCkdbEntity bean = ckList.get(position);
        //勾选按钮 设置数据
        viewHolder.checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewHolder.checkbox.isChecked()) {
                    bean.setChecked(true);
                } else {
                    bean.setChecked(false);
                }
            }
        });
        //减号
        viewHolder.btn_jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double number = 0.0;
                if (StringUtil.isEmpty(viewHolder.number.getText().toString().trim())) {
                    SyDialogHelper.showWarningDlg(TLReceiptActivity.this, "", "数量不能为空", "确定", null);
                    return;
                } else {
                    if (Double.valueOf(viewHolder.number.getText().toString().trim()) <= 0.0) {
                        SyDialogHelper.showWarningDlg(TLReceiptActivity.this, "", "数量不能为负", "确定", null);
                        viewHolder.number.setText(0.0 + "");
                        return;
                    } else {
                        number = Double.valueOf(viewHolder.number.getText().toString().trim());
                    }
                }
                Double old = bean.getJhsl();
                if (Double.doubleToLongBits(DoubleUtil.sub(number, 1)) > Double.doubleToLongBits(old)) {
                    SyDialogHelper.showWarningDlg(TLReceiptActivity.this, "", "收货数量不能大于交货数量", "确定", null);
                } else {
                    viewHolder.number.setText("");
                    viewHolder.number.setText(DoubleUtil.sub(number, 1) + "");
                    ckList.get(position).setPpmen(DoubleUtil.sub(number, 1));
                }
            }
        });
        //加号
        viewHolder.btn_jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double number = 0.0;
                if (StringUtil.isEmpty(viewHolder.number.getText().toString().trim())) {
                    number = 0.0;
                } else {
                    number = Double.valueOf(viewHolder.number.getText().toString().trim());
                }
                Double old = bean.getJhsl();
                if (Double.doubleToLongBits(DoubleUtil.sum(number, 1)) > Double.doubleToLongBits(old)) {
                    SyDialogHelper.showWarningDlg(TLReceiptActivity.this, "", "收货数量不能大于交货数量", "确定", null);
                } else {
                    viewHolder.number.setText("");
                    viewHolder.number.setText(DoubleUtil.sum(number, 1) + "");
                    ckList.get(position).setPpmen(DoubleUtil.sum(number, 1));
                }
            }
        });
    }

    @Override
    public void setLlData(final LlAdapter.ViewHolder viewHolder, final int position) {
//获取修改的子列对象
        final RkWmsScllEntity bean = llList.get(position);
        //勾选按钮 设置数据
        viewHolder.checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewHolder.checkbox.isChecked()) {
                    bean.setChecked(true);
                } else {
                    bean.setChecked(false);
                }
            }
        });
        //减号
        viewHolder.btn_jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double number = 0.0;
                if (StringUtil.isEmpty(viewHolder.number.getText().toString().trim())) {
                    SyDialogHelper.showWarningDlg(TLReceiptActivity.this, "", "数量不能为空", "确定", null);
                    return;
                } else {
                    if (Double.valueOf(viewHolder.number.getText().toString().trim()) <= 0.0) {
                        SyDialogHelper.showWarningDlg(TLReceiptActivity.this, "", "数量不能为负", "确定", null);
                        viewHolder.number.setText(0.0 + "");
                        return;
                    } else {
                        number = Double.valueOf(viewHolder.number.getText().toString().trim());
                    }
                }
                Double old = bean.getJhsl();
                if (Double.doubleToLongBits(DoubleUtil.sub(number, 1)) > Double.doubleToLongBits(old)) {
                    SyDialogHelper.showWarningDlg(TLReceiptActivity.this, "", "收货数量不能大于交货数量", "确定", null);
                } else {
                    viewHolder.number.setText("");
                    viewHolder.number.setText(DoubleUtil.sub(number, 1) + "");
                    llList.get(position).setRkSl(DoubleUtil.sub(number, 1));
                }
            }
        });
        //加号
        viewHolder.btn_jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double number = 0.0;
                if (StringUtil.isEmpty(viewHolder.number.getText().toString().trim())) {
                    number = 0.0;
                } else {
                    number = Double.valueOf(viewHolder.number.getText().toString().trim());
                }
                Double old = bean.getJhsl();
                if (Double.doubleToLongBits(DoubleUtil.sum(number, 1)) > Double.doubleToLongBits(old)) {
                    SyDialogHelper.showWarningDlg(TLReceiptActivity.this, "", "收货数量不能大于交货数量", "确定", null);
                } else {
                    viewHolder.number.setText("");
                    viewHolder.number.setText(DoubleUtil.sum(number, 1) + "");
                    llList.get(position).setRkSl(DoubleUtil.sum(number, 1));
                }
            }
        });
    }
}
