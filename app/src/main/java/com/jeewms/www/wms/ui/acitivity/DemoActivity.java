package com.jeewms.www.wms.ui.acitivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.jeewms.www.wms.R;
import com.jeewms.www.wms.base.BaseBackActivity;
import com.jeewms.www.wms.bean.bean.MessageEvent;
import com.jeewms.www.wms.bean.listvm.DemoListVm;
import com.jeewms.www.wms.bean.vm.DemoVm;
import com.jeewms.www.wms.constance.Constance;
import com.jeewms.www.wms.ui.adapter.DemoAdapter;
import com.jeewms.www.wms.util.GsonUtils;
import com.jeewms.www.wms.util.Logutil;
import com.jeewms.www.wms.util.SharedPreferencesUtil;
import com.jeewms.www.wms.util.StringUtil;
import com.jeewms.www.wms.volley.HTTPUtils;
import com.jeewms.www.wms.volley.VolleyListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 13799 on 2018/8/5.
 */

public class DemoActivity extends BaseBackActivity {

    @BindView(R.id.tv_jiaojiedan)
    TextView tvJiaojiedan;
    @BindView(R.id.et_jiaojiedan)
    EditText etJiaojiedan;
    @BindView(R.id.et_fangweima)
    EditText etFangweima;
    @BindView(R.id.tv_search)
    TextView tvSearch;
    @BindView(R.id.lv_mylistview)
    ListView lvMylistview;
    DemoAdapter adapter;
    List<DemoVm> list = new ArrayList<>();

    @Override
    protected void initView() {
        super.initView();
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        setTitle("上架");
        initAdapter();
        getData();
    }

    //绑定界面《setContentView(R.layout.activity_demo);》
    @Override
    protected int getContentResId() {
        return R.layout.activity_demo;
    }

    private void initAdapter() {
        adapter = new DemoAdapter(getActivity());
        lvMylistview.setAdapter(adapter);
        lvMylistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                DemoDetailActivity.show(getActivity(), list.get(i).getX2(), list.get(i).getX3(), list.get(i).getX1(), list.get(i).getId());
            }
        });
    }

    public void setList() {
        List<DemoVm> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DemoVm vm = new DemoVm();

            list.add(vm);
        }
        adapter.setList(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void MessageEventBus(MessageEvent msg) {
        if (msg.getKey().equals("key1")) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId().equals(msg.getMessage())) {
                    if (i < list.size() - 1)
                        EventBus.getDefault().post(new MessageEvent("key2", list.get(i + 1).getX2(), list.get(i + 1).getX3(), list.get(i + 1).getX1(), list.get(i + 1).getId()));
                    else
                        EventBus.getDefault().post(new MessageEvent("key3"));
                }
            }
        }
    }

    public void getData() {
        String url = Constance.gettSapLsqdControllerURL() + "?username=" + SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.LOGINNAME);
        if (!StringUtil.isEmpty(etJiaojiedan.getText().toString()))
            url += "&searchstr=" + etJiaojiedan.getText().toString();
        if (!StringUtil.isEmpty(etFangweima.getText().toString()))
            url += "&searchstr2=" + etFangweima.getText().toString();
        Logutil.print("url" + url);
        HTTPUtils.get(getActivity(), url, new VolleyListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }

            @Override
            public void onResponse(String response) {
                Logutil.print("res==" + response);
                DemoListVm vm = GsonUtils.parseJSON(response, DemoListVm.class);
                if (vm != null) {
                    adapter.setList(vm.getObj());
                    list = vm.getObj();
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }

    @OnClick({R.id.tv_jiaojiedan, R.id.tv_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_jiaojiedan:
                break;
            case R.id.tv_search:
                break;
        }
    }

    @OnClick(R.id.tv_search)
    public void onViewClicked() {
        getData();
    }
}
