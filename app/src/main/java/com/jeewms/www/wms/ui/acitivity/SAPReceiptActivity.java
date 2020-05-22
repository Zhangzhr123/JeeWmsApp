package com.jeewms.www.wms.ui.acitivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.alibaba.fastjson.JSON;
import com.android.volley.VolleyError;
import com.jeewms.www.wms.R;
import com.jeewms.www.wms.base.BaseActivity;
import com.jeewms.www.wms.bean.bean.*;
import com.jeewms.www.wms.constance.Constance;
import com.jeewms.www.wms.ui.adapter.SAPReceiptAdapter;
import com.jeewms.www.wms.ui.view.dialog.SyDialogHelper;
import com.jeewms.www.wms.util.*;
import com.jeewms.www.wms.volley.HTTPUtils;
import com.jeewms.www.wms.volley.VolleyListener;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.OnDismissCallback;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zhangzhr
 * Created Date 2020-05-20
 * 采购订单收货
 */

public class SAPReceiptActivity extends BaseActivity implements OnDismissCallback, SAPReceiptAdapter.DetailViewHolderListener {

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
    @BindView(R.id.radio_1)//收货
            RadioButton radio1;
    @BindView(R.id.radio_2)//收货投料
            RadioButton radio2;
    @BindView(R.id.id_radiogroup)//方式单选控件
            RadioGroup radioGroup;
    @BindView(R.id.cb_all)//全选按钮
            CheckBox cbAll;
    @BindView(R.id.ll_fangshi)//方式行
            LinearLayout ll_fangshi;

    private SAPReceiptAdapter mAdapter;//收货单列表适配器
    private List<RkWmsShdbEntity> dataList;//列表数据
    private String shType;

    public static void show(Context context) {
        Intent intent = new Intent(context, SAPReceiptActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initView() {
        super.initView();
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        mBtnLeft.setVisibility(View.VISIBLE);//左方向键

        //获取收货单编码
        etSearch.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int i, KeyEvent keyEvent) {
                if (i == KeyEvent.KEYCODE_ENTER) {
                    //查询收货单数据
                    getDate(etSearch.getText().toString());
                    return true;
                }
                return false;
            }
        });
        //设置表头名称
        setTitle("采购订单收货");
        //获取收货方式
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) SAPReceiptActivity.this.findViewById(radioGroup.getCheckedRadioButtonId());
                //获取收货方式
                shType = rb.getText().toString();
            }
        });

    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void MessageEventBus(MessageEvent msg) {
        //查询收货单数据
        getDate(etSearch.getText().toString());
    }

    @Override
    protected int getContentResId() {
        return R.layout.activity_sapreceipt;
    }

    //获取收货单编码查询收货单数据添加列表内容
    private void getDate(String searchKey) {
        //加载动画开启
        LoadingUtil.showLoading(this);
        //SAP送货单接口
        Map<String, String> params = new HashMap<>();
        params.put("shdbh", searchKey);
        String url = SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.HTTPADDRESS) + Constance.POSTRiWmsSAPEntity;
        HTTPUtils.post(this, url, params, new VolleyListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }

            @Override
            public void onResponse(String response) {
                //将json对象转换为java对象
                SAPRkWmsListVm res = GsonUtils.parseJSON(response, SAPRkWmsListVm.class);
                dataList = res.getObj();
                //判断是否为空
                if (dataList != null && dataList.size() > 0) {
                    //设置展示数据设置未选中
                    for (int i = 0; i < dataList.size(); i++) {
                        dataList.get(i).setChecked(false);
                    }
                    //添加数据到列表中
                    mAdapter = new SAPReceiptAdapter(SAPReceiptActivity.this, dataList, SAPReceiptActivity.this);
                    mAdapter.notifyDataSetChanged();
                    mListView.setAdapter(mAdapter);
                    //设置送货单编号
                    tvshdbm.setText(dataList.get(0).getPshwln());
                    //判断用户描述是否为空
                    if (StringUtil.isEmpty(dataList.get(0).getPtype())) {
                        ll_fangshi.setVisibility(View.GONE);
                        shType = "收货";
                    }
                    //加载动画关闭
                    LoadingUtil.hideLoading();
                    //前往第二页
                    llscan.setVisibility(View.GONE);
                    rlsap.setVisibility(View.VISIBLE);
                } else {
                    //加载动画关闭
                    LoadingUtil.hideLoading();
                    Toast.makeText(SAPReceiptActivity.this, "未查询到送货单，请重新输入！", Toast.LENGTH_SHORT).show();
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

    //取消按钮
    @OnClick(R.id.btn_Out)
    public void onOutClicked() {
        //返回第一页
        rlsap.setVisibility(View.GONE);
        llscan.setVisibility(View.VISIBLE);
        ll_fangshi.setVisibility(View.VISIBLE);
        cbAll.setChecked(false);
        radio1.setChecked(false);
        radio2.setChecked(false);
        shType = "";
    }

    //确定按钮 展示勾选的数据
    @OnClick(R.id.btn_OK)
    public void onOKClicked() {
        //判断收货方式是否为空
        if (StringUtil.isEmpty(shType)) {
            SyDialogHelper.showWarningDlg(this, "", "请选择方式", "确定");
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            List<RkWmsShdbEntity> list = new ArrayList<>();
            List<RkWmsShdbEntity> inflglist = new ArrayList<>();
            //获取选中的数据
            for (int i = 0; i < dataList.size(); i++) {
                //判断是否勾选
                if (dataList.get(i).getChecked()) {
                    list.add(dataList.get(i));
                }
            }
            //获取选中质检行项目
            for (int i = 0; i < dataList.size(); i++) {
                //判断是否勾选
                if (dataList.get(i).getChecked()) {
                    if (!StringUtil.isEmpty(dataList.get(i).getInflg())) {
                        inflglist.add(dataList.get(i));
                    }
                }
            }
            //判断有没有选择行项目
            if (list.size() > 0 && list != null) {
                //发送收货表
                for (int i = 0; i < list.size(); i++) {
                    Map<String, String> map = new HashMap<>();
                    //创建人名称
                    map.put("createName", dataList.get(i).getPname());
                    //创建人登录名称
                    map.put("createBy", dataList.get(i).getPname());
                    //创建日期
                    map.put("createDate", sdf.format(new Date()));
                    //更新人名称
                    map.put("updateName", SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.USERNAME));
                    //更新人登录名称
                    map.put("updateBy", SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.LOGINNAME));
                    //更新日期
                    map.put("updateDate", sdf.format(new Date()));
                    //所属部门
                    map.put("sysOrgCode", SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.DEPT));
                    //所属公司
                    map.put("sysCompanyCode", SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.COMPANY));
                    //流程状态
                    map.put("bpmStatus", dataList.get(i).getBpmStatus());
                    //工厂
                    map.put("rkGc", dataList.get(i).getPwerks());
                    //采购订单
                    map.put("rkCgdd", dataList.get(i).getEbeln());
                    //行项目
                    map.put("rkHxm", dataList.get(i).getShwlp());
                    //供应商编号
                    map.put("rkGysbh", dataList.get(i).getPlifnr());
                    //供应商名称
                    map.put("rkGysmc", dataList.get(i).getPliftx());
                    //用途描述
                    map.put("rkYtms", dataList.get(i).getPtype());
                    //送货地点
                    map.put("rkShdd", dataList.get(i).getPlgort());
                    //WBS
                    map.put("rkWbs", dataList.get(i).getPsptx());
                    //物料编码
                    map.put("rkWlbm", dataList.get(i).getMaktr());
                    //物料描述
                    map.put("rkWlms", dataList.get(i).getMaktx());
                    //数量
                    map.put("rkSl", dataList.get(i).getMenge() + "");
                    //收货日期
                    map.put("rkShrq", sdf.format(new Date()));
                    //收货人
                    map.put("rkShr", SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.USERNAME));
                    //溯源单据号
                    map.put("rkSydjh", dataList.get(i).getPshwln());
                    //溯源单行项目
                    map.put("rkSydhxm", dataList.get(i).getShwlp());
                    //SAP状态
                    map.put("rkSapzz", "执行中");
                    //SAP异常信息
                    map.put("rkSapycxx", null);
                    //人工处理
                    map.put("rkRgcl", null);
                    //处理时间
                    map.put("rkClsj", null);
                    //处理人
                    map.put("rkClr", null);

                    //类型转换
                    JSONObject jsonObject = new JSONObject(map);
                    Map<String, String> params = new HashMap<>();
                    params.put("str", jsonObject.toString());//上传实体json
                    //发送数据
                    String url = SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.HTTPADDRESS) + Constance.POSTRiWmsShdbEntity;
                    HTTPUtils.post(this, url, params, new VolleyListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                        }

                        @Override
                        public void onResponse(String response) {
                        }
                    });
                    SyDialogHelper.showSuccessDlg(SAPReceiptActivity.this, "", "发送出库成功", "确定");
                }

                //发送入库表
                if (shType.equals("收货")) {
                    for (int i = 0; i < list.size(); i++) {
                        Map<String, String> map = new HashMap<>();
                        //创建人名称
                        map.put("createName", dataList.get(i).getPname());
                        //创建人登录名称
                        map.put("createBy", dataList.get(i).getPname());
                        //创建日期
                        map.put("createDate", sdf.format(new Date()));
                        //更新人名称
                        map.put("updateName", SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.USERNAME));
                        //更新人登录名称
                        map.put("updateBy", SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.LOGINNAME));
                        //更新日期
                        map.put("updateDate", sdf.format(new Date()));
                        //所属部门
                        map.put("sysOrgCode", SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.DEPT));
                        //所属公司
                        map.put("sysCompanyCode", SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.COMPANY));
                        //流程状态
                        map.put("bpmStatus", dataList.get(i).getBpmStatus());
                        //工厂
                        map.put("rkGc", dataList.get(i).getPwerks());
                        //WBS
                        map.put("rkWbs", dataList.get(i).getPsptx());
                        //物料编码
                        map.put("rkWlbm", dataList.get(i).getMaktr());
                        //物料描述
                        map.put("rkWlms", dataList.get(i).getMaktx());
                        //入库类型
                        map.put("rkRklx", "供应商入库");
                        //入库库存地点
                        map.put("rkRkkcdd", dataList.get(i).getPlgort());
                        //出库库存地点
                        map.put("rkCkcddd", "出库地点");
                        //数量
                        map.put("rkSl", dataList.get(i).getMenge() + "");
                        //入库日期
                        map.put("rkRksj", sdf.format(new Date()));
                        //操作人
                        map.put("rkCzr", SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.USERNAME));
                        //溯源单据号
                        map.put("rkSydjh", dataList.get(i).getPshwln());
                        //溯源单行项目
                        map.put("rkSydhxm", dataList.get(i).getShwlp());
                        //SAP状态
                        map.put("rkSapzz", "执行中");
                        //SAP异常信息
                        map.put("rkSapycxx", null);
                        //人工处理
                        map.put("rkRgcl", null);
                        //处理时间
                        map.put("rkClsj", null);
                        //处理人
                        map.put("rkClr", null);

                        //类型转换
                        JSONObject jsonObject = new JSONObject(map);
                        Map<String, String> params = new HashMap<>();
                        params.put("str", jsonObject.toString());//上传实体json
                        //发送数据
                        String url = SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.HTTPADDRESS) + Constance.POSTRiWmsRkdbEntity;
                        HTTPUtils.post(this, url, params, new VolleyListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                            }

                            @Override
                            public void onResponse(String response) {
                            }
                        });
                    }

                    //发送投料表
                } else if (shType.equals("收货投料")) {
                    for (int i = 0; i < list.size(); i++) {
                        Map<String, String> map = new HashMap<>();
                        //创建人名称
                        map.put("createName", dataList.get(i).getPname());
                        //创建人登录名称
                        map.put("createBy", dataList.get(i).getPname());
                        //创建日期
                        map.put("createDate", sdf.format(new Date()));
                        //更新人名称
                        map.put("updateName", SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.USERNAME));
                        //更新人登录名称
                        map.put("updateBy", SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.LOGINNAME));
                        //更新日期
                        map.put("updateDate", sdf.format(new Date()));
                        //所属部门
                        map.put("sysOrgCode", SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.DEPT));
                        //所属公司
                        map.put("sysCompanyCode", SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.COMPANY));
                        //流程状态
                        map.put("bpmStatus", dataList.get(i).getBpmStatus());
                        //工厂
                        map.put("rkGc", dataList.get(i).getPwerks());
                        //WBS
                        map.put("rkWbs", dataList.get(i).getPsptx());
                        //投料编号
                        map.put("rkTlbh", "投料编号");
                        //投料类型
                        map.put("rkTllx", "投料类型");
                        //物料编码
                        map.put("rkWlbm", dataList.get(i).getMaktr());
                        //物料描述
                        map.put("rkWlms", dataList.get(i).getMaktx());
                        //投料库存地点
                        map.put("rkTlkcdd", dataList.get(i).getPlgort());
                        //数量
                        map.put("rkSl", dataList.get(i).getMenge() + "");
                        //投料时间
                        map.put("rkTlsj", sdf.format(new Date()));
                        //投料人
                        map.put("rkTlr", SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.USERNAME));
                        //溯源单据号
                        map.put("rkSydjh", dataList.get(i).getPshwln());
                        //溯源单行项目
                        map.put("rkSydhxm", dataList.get(i).getShwlp());
                        //SAP状态
                        map.put("rkSapzz", "执行中");
                        //SAP异常信息
                        map.put("rkSapycxx", null);
                        //人工处理
                        map.put("rkRgcl", null);
                        //处理时间
                        map.put("rkClsj", null);
                        //处理人
                        map.put("rkClr", null);

                        //类型转换
                        JSONObject jsonObject = new JSONObject(map);
                        Map<String, String> params = new HashMap<>();
                        params.put("str", jsonObject.toString());//上传实体json
                        //发送数据
                        String url = SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.HTTPADDRESS) + Constance.POSTRiWmsShtlEntity;
                        HTTPUtils.post(this, url, params, new VolleyListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                            }

                            @Override
                            public void onResponse(String response) {
                            }
                        });
                    }
                }
            } else {
                SyDialogHelper.showWarningDlg(this, "", "请选择数据", "确定");
            }

            //判断是否有质检标识的行项目
            if (inflglist.size() > 0 && inflglist != null) {
                //发送行项目到外协检验记录表
                for (int i = 0; i < list.size(); i++) {
                    Map<String, String> map = new HashMap<>();
                    //创建人名称
                    map.put("createName", dataList.get(i).getPname());
                    //创建人登录名称
                    map.put("createBy", dataList.get(i).getPname());
                    //创建日期
                    map.put("createDate", sdf.format(new Date()));
                    //更新人名称
                    map.put("updateName", SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.USERNAME));
                    //更新人登录名称
                    map.put("updateBy", SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.LOGINNAME));
                    //更新日期
                    map.put("updateDate", sdf.format(new Date()));
                    //所属部门
                    map.put("sysOrgCode", SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.DEPT));
                    //所属公司
                    map.put("sysCompanyCode", SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.COMPANY));
                    //流程状态
                    map.put("bpmStatus", dataList.get(i).getBpmStatus());
                    //WBS
                    map.put("rkWbs", dataList.get(i).getPsptx());
                    //采购订单
                    map.put("rkCgdd", dataList.get(i).getEbeln());
                    //行项目
                    map.put("rkHxm", dataList.get(i).getShwlp());
                    //物料编码
                    map.put("rkWlbm", dataList.get(i).getMaktr());
                    //物料描述
                    map.put("rkWlms", dataList.get(i).getMaktx());
                    //订单数量
                    map.put("rkDdsl", dataList.get(i).getBdmng() + "");
                    //收货数量
                    map.put("rkShsl", dataList.get(i).getMenge() + "");
                    //检验类型
                    map.put("rkJylx", dataList.get(i).getInflg());

                    //类型转换
                    JSONObject jsonObject = new JSONObject(map);
                    Map<String, String> params = new HashMap<>();
                    params.put("str", jsonObject.toString());//上传实体json
                    //发送数据
                    String url = SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.HTTPADDRESS) + Constance.POSTRkWmsWxjyjlbEntity;
                    HTTPUtils.post(this, url, params, new VolleyListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                        }

                        @Override
                        public void onResponse(String response) {
                        }
                    });
                }
            }
            SyDialogHelper.showSuccessDlg(SAPReceiptActivity.this, "", "发送成功", "确定");
        }
    }

    //修改数据
    @Override
    public void setData(final SAPReceiptAdapter.ViewHolder viewHolder, final int position) {
        //获取修改的子列对象
        final RkWmsShdbEntity bean = dataList.get(position);
        //勾选按钮 设置发送数据
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
    }

    /*
     * 设置列表取消全选，并刷新列表
     */
    private void uncheckAllItem() {
        for (int i = 0; i < dataList.size(); i++) {
            dataList.get(i).setChecked(false);
        }
        mAdapter.notifyDataSetChanged();
    }

    /*
     * 设置列表全选，并刷新列表
     */
    public void checkAllItem() {
        for (int i = 0; i < dataList.size(); i++) {
            dataList.get(i).setChecked(true);
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //右方向键
        switch (keyCode) {
            case 22:
                getDate(etSearch.getText().toString());
                break;
        }
        return super.onKeyDown(keyCode, event);
    }


}
