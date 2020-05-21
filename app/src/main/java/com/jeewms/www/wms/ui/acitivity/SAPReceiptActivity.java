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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 13799 on 2018/6/7.
 * 收货
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

    private SAPReceiptAdapter mAdapter;//收货单列表适配器
    private List<RkWmsSctlEntity> dataList;//列表数据
    private String shType;
    //数据变换
    private List<RkWmsSctlEntity> saplist;

    public static void show(Context context) {
        Intent intent = new Intent(context, SAPReceiptActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initView() {
        super.initView();
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        mBtnLeft.setVisibility(View.VISIBLE);

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

        //SAP送货单接口
        Map<String, String> params = new HashMap<>();
        params.put("syd", searchKey);
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
                if (dataList != null && dataList.getClass() != null) {
                    //设置展示数据
                    for (int i = 0; i < dataList.size(); i++) {
                        dataList.get(i).setChecked(false);
                    }
                    //添加数据到列表中
                    mAdapter = new SAPReceiptAdapter(SAPReceiptActivity.this, dataList, SAPReceiptActivity.this);
                    mAdapter.notifyDataSetChanged();
                    mListView.setAdapter(mAdapter);
                    //加载动画关闭
                    LoadingUtil.hideLoading();
                    tvshdbm.setText(etSearch.getText().toString().trim());
                    //前往第二页
                    llscan.setVisibility(View.GONE);
                    rlsap.setVisibility(View.VISIBLE);
                    //设置发送数据
                    saplist = res.getObj();
                    for (int i = 0; i < saplist.size(); i++) {
                        saplist.get(i).setChecked(false);
                    }
                } else {
                    Toast.makeText(SAPReceiptActivity.this, res.getErrorMsg(), Toast.LENGTH_SHORT).show();
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
    public void onViewClicked(View view) {
        getDate(etSearch.getText().toString());
        //加载动画开启
        LoadingUtil.showLoading(this);
    }

    //全选按钮
    @OnClick(R.id.cb_all)
    public void onAllClicked(View view) {
        switch (view.getId()) {
            case R.id.cb_all:
                //  处理全选的逻辑
                if (cbAll.isChecked()) {
                    checkAllItem();
                } else {
                    uncheckAllItem();
                }
                break;
        }
    }

    //取消按钮
    @OnClick(R.id.btn_Out)
    public void onOutClicked(View view) {
        //返回第一页
        rlsap.setVisibility(View.GONE);
        llscan.setVisibility(View.VISIBLE);
    }

    //确定按钮 展示勾选的数据
    @OnClick(R.id.btn_OK)
    public void onOKClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_OK:
                if (StringUtil.isEmpty(shType)) {
                    SyDialogHelper.showWarningDlg(this, "", "请选择方式", "确定");
                } else {
                    List<RkWmsSctlEntity> list = new ArrayList<>();
                    //获取选中的数据
                    for (int i = 0; i < saplist.size(); i++) {
                        if (saplist.get(i).getChecked()) {//判断是否勾选
                            list.add(saplist.get(i));
                        }
                    }
                    //判断有没有选择行项目
                    if (list.size() > 0 && list != null) {
                        //发送收货单
                        for (int i = 0; i < list.size(); i++) {
                            Map<String, String> map = new HashMap<>();
                            map.put("id", saplist.get(i).getId());
                            map.put("sysOrgCode", saplist.get(i).getSysOrgCode());
                            map.put("sysCompanyCode", saplist.get(i).getSysCompanyCode());
                            map.put("bpmStatus", saplist.get(i).getBpmStatus());
                            map.put("rkSydhxm", saplist.get(i).getRkSydhxm());
                            map.put("rkWlbm", saplist.get(i).getRkWlbm());
                            map.put("rkWlms", saplist.get(i).getRkWlms());
                            map.put("rkSl", saplist.get(i).getRkSl() + "");
                            map.put("rkSapzz", "执行中");
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
                        }
                        //发送入库单
                        if (shType.equals("收货")) {
                            for (int i = 0; i < list.size(); i++) {
                                Map<String, String> map = new HashMap<>();
                                map.put("id", saplist.get(i).getId());
                                map.put("sysOrgCode", saplist.get(i).getSysOrgCode());
                                map.put("sysCompanyCode", saplist.get(i).getSysCompanyCode());
                                map.put("bpmStatus", saplist.get(i).getBpmStatus());
                                map.put("rkSydhxm", saplist.get(i).getRkSydhxm());
                                map.put("rkWlbm", saplist.get(i).getRkWlbm());
                                map.put("rkWlms", saplist.get(i).getRkWlms());
                                map.put("rkSl", saplist.get(i).getRkSl() + "");
                                map.put("rkRklx", "供应商入库");
                                map.put("rkSapzz", "执行中");
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
                            SyDialogHelper.showSuccessDlg(SAPReceiptActivity.this, "", "发送成功", "确定");

                            //发送投料单
                        } else if (shType.equals("收货投料")) {
                            for (int i = 0; i < list.size(); i++) {
                                Map<String, String> map = new HashMap<>();
                                map.put("id", saplist.get(i).getId());
                                map.put("sysOrgCode", saplist.get(i).getSysOrgCode());
                                map.put("sysCompanyCode", saplist.get(i).getSysCompanyCode());
                                map.put("bpmStatus", saplist.get(i).getBpmStatus());
                                map.put("rkSydhxm", saplist.get(i).getRkSydhxm());
                                map.put("rkWlbm", saplist.get(i).getRkWlbm());
                                map.put("rkWlms", saplist.get(i).getRkWlms());
                                map.put("rkSl", saplist.get(i).getRkSl() + "");
                                map.put("rkSapzz", "执行中");
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
                            SyDialogHelper.showSuccessDlg(SAPReceiptActivity.this, "", "发送成功", "确定");
                        }
                    } else {
                        SyDialogHelper.showWarningDlg(this, "", "请选择数据", "确定");
                    }
                }
                break;
        }
    }

    //修改数据
    @Override
    public void setData(final SAPReceiptAdapter.ViewHolder viewHolder, final int position) {
        final RkWmsSctlEntity bean = saplist.get(position);
        //添加数据
//        viewHolder.sapHxm.setText(bean.getRkSydhxm());
//        viewHolder.rkWlms.setText(bean.getRkWlms());
//        viewHolder.checkbox.setChecked(bean.getChecked());
        //减号
        viewHolder.btn_jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double number = Double.valueOf(viewHolder.number.getText().toString().trim());
                Double old = viewHolder.old;
                if (Double.doubleToLongBits(DoubleUtil.sub(number, 1)) > Double.doubleToLongBits(old)) {
                    SyDialogHelper.showWarningDlg(SAPReceiptActivity.this, "", "收货数量不能大于交货数量", "确定");
                } else {
                    viewHolder.number.setText("");
                    viewHolder.number.setText(DoubleUtil.sub(number, 1) + "");
                    bean.setRkSl(DoubleUtil.sub(number, 1));
                }
            }
        });
        //加号
        viewHolder.btn_jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double number = Double.valueOf(viewHolder.number.getText().toString().trim());
                Double old = viewHolder.old;
                if (Double.doubleToLongBits(DoubleUtil.sum(number, 1)) > Double.doubleToLongBits(old)) {
                    SyDialogHelper.showWarningDlg(SAPReceiptActivity.this, "", "收货数量不能大于交货数量", "确定");
                } else {
                    viewHolder.number.setText("");
                    viewHolder.number.setText(DoubleUtil.sum(number, 1) + "");
                    bean.setRkSl(DoubleUtil.sum(number, 1));
                }
            }
        });
        //勾选时设置数据
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
        for (int i = 0; i < saplist.size(); i++) {
            saplist.get(i).setChecked(false);
        }
        mAdapter.notifyDataSetChanged();
    }

    /*
     * 设置列表全选，并刷新列表
     */
    public void checkAllItem() {
        for (int i = 0; i < saplist.size(); i++) {
            saplist.get(i).setChecked(true);
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //右方向键
        switch (keyCode) {
            case 22:
                getDate(etSearch.getText().toString());
                //加载动画开启
                LoadingUtil.showLoading(this);
                break;
        }
        return super.onKeyDown(keyCode, event);
    }


}
