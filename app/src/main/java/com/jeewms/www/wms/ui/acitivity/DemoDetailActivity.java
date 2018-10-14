package com.jeewms.www.wms.ui.acitivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.jeewms.www.wms.R;
import com.jeewms.www.wms.base.BaseBackActivity;
import com.jeewms.www.wms.bean.bean.MessageEvent;
import com.jeewms.www.wms.bean.listvm.DemoListVm;
import com.jeewms.www.wms.bean.vm.PickingSaveVm;
import com.jeewms.www.wms.constance.Constance;
import com.jeewms.www.wms.ui.adapter.DemoAdapter;
import com.jeewms.www.wms.util.GsonUtils;
import com.jeewms.www.wms.util.LoadingUtil;
import com.jeewms.www.wms.util.Logutil;
import com.jeewms.www.wms.util.SharedPreferencesUtil;
import com.jeewms.www.wms.util.ToastUtil;
import com.jeewms.www.wms.util.UpdataUiUtil;
import com.jeewms.www.wms.volley.HTTPUtils;
import com.jeewms.www.wms.volley.VolleyListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 13799 on 2018/8/5.
 */

public class DemoDetailActivity extends BaseBackActivity {

    @BindView(R.id.tv_wuliaohao)
    TextView tvWuliaohao;
    @BindView(R.id.tv_shangjiachuwei)
    EditText tvShangjiachuwei;
    @BindView(R.id.tv_shuliang)
    TextView tvShuliang;
    @BindView(R.id.lv_list)
    ListView lvList;
    @BindView(R.id.tv_xiayixiang)
    TextView tvXiayixiang;
    private String shuliang;
    private String wuliaoHao;
    private String jiaojiedan;
    private String id;
    DemoAdapter adapter;


    public static void show(Context context, String wuliaoHao, String shuliang, String jiaojiedan,String id) {
        Intent intent = new Intent(context, DemoDetailActivity.class);
        intent.putExtra("shuliang", shuliang);
        intent.putExtra("wuliaoHao", wuliaoHao);
        intent.putExtra("jiaojiedan", jiaojiedan);
        intent.putExtra("id", id);
        context.startActivity(intent);
    }
    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void MessageEventBus(MessageEvent msg) {
        if (msg.getKey().equals("key2")) {
            DemoDetailActivity.show(getActivity(),msg.getMessage(),msg.getMessage2(),msg.getMessage3(),msg.getMessage5());
            finish();
        }else if(msg.getKey().equals("key3")) {
            ToastUtil.show(this,"这是最后一项了");
        }
    }
    @Override
    protected void initView() {
        super.initView();
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        shuliang = getIntent().getStringExtra("shuliang");
        wuliaoHao = getIntent().getStringExtra("wuliaoHao");
        jiaojiedan = getIntent().getStringExtra("jiaojiedan");
        id = getIntent().getStringExtra("id");
        UpdataUiUtil.getDefaul().setText(wuliaoHao, tvWuliaohao)
                .setText(shuliang, tvShuliang);
        setTitle("上架详情");
        ((TextView) mBtnRight).setText("上架");
        mBtnRight.setVisibility(View.VISIBLE);
        initAdapter();
        getData();
        LoadingUtil.showLoading(this);

    }

    private void initAdapter() {
        adapter = new DemoAdapter(getActivity());
        adapter.setType(1);
        lvList.setAdapter(adapter);

    }

    @Override
    protected void onRightButtonClick() {
        super.onRightButtonClick();
        save();
    }

    //获取列表
    private void getData() {
        String url = Constance.gettSapStockControllerURL() + "?username=" + SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.LOGINNAME);
        url += "&searchstr1=" + wuliaoHao;
        Logutil.print("detail");
        HTTPUtils.get(getActivity(), url, new VolleyListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }

            @Override
            public void onResponse(String response) {
                DemoListVm vm = GsonUtils.parseJSON(response, DemoListVm.class);
                if (vm != null) {
                    adapter.setList(vm.getObj());
                    adapter.notifyDataSetChanged();
                    LoadingUtil.hideLoading();

                }
            }
        });
    }


    @Override
    protected int getContentResId() {
        return R.layout.activity_demodetail;
    }

    private void save() {

        Map<String, String> map = new HashMap<>();
        map.put("x1", jiaojiedan);
        map.put("x2", wuliaoHao);
        map.put("x3", shuliang);//商品编码
        map.put("x4", tvShangjiachuwei.getText().toString());
        JSONObject jsonObject = new JSONObject(map);
        Map<String, String> params = new HashMap<>();
        params.put("tSapLtttstr", jsonObject.toString());//上传实体json
        params.put("username", SharedPreferencesUtil.getInstance(getActivity()).getKeyValue(Constance.SHAREP.LOGINNAME));//上传实体json
        Logutil.print("jsonObject.toString()==" + jsonObject.toString());
        HTTPUtils.post(getActivity(), Constance.gettSapLtttControllerURL(), params, new VolleyListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                ToastUtil.show(getActivity(), "未知错误");
            }

            @Override
            public void onResponse(String response) {
                Logutil.print("res==" + response);
                PickingSaveVm vm = GsonUtils.parseJSON(response, PickingSaveVm.class);
                if (vm != null && vm.isOk()) {
                    ToastUtil.show(getActivity(), "保存成功");
                } else if (vm != null) {
                    ToastUtil.show(getActivity(), vm.getErrorMsg());
                } else {
                    ToastUtil.show(getActivity(), "未知错误");
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tv_xiayixiang)
    public void onViewClicked() {
        EventBus.getDefault().post(new MessageEvent("key1",id));
    }
}
