package com.jeewms.www.wms.ui.acitivity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;

import com.android.volley.VolleyError;
import com.jeewms.www.wms.bean.bean.MessageEvent;
import com.jeewms.www.wms.util.LoadingUtil;
import com.jeewms.www.wms.util.SharedPreferencesUtil;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.OnDismissCallback;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.SwipeDismissAdapter;
import com.jeewms.www.wms.R;
import com.jeewms.www.wms.base.BaseActivity;
import com.jeewms.www.wms.bean.listvm.RecheckLoadingListVm;
import com.jeewms.www.wms.bean.vm.RecheckLoadingVm;
import com.jeewms.www.wms.constance.Constance;
import com.jeewms.www.wms.ui.adapter.RecheckLoadingAdapter;
import com.jeewms.www.wms.util.listviewanimations.swinginadapters.prepared.SwingBottomInAnimationAdapter;
import com.jeewms.www.wms.util.GsonUtils;
import com.jeewms.www.wms.volley.HTTPUtils;
import com.jeewms.www.wms.volley.VolleyListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 13799 on 2018/6/7.
 *
 * 装车复核
 */

public class RecheckLoadingActivity extends BaseActivity implements OnDismissCallback {

    RecheckLoadingAdapter mAdapter;
    @BindView(R.id.activity_googlecards_listview)
    ListView mListView;
    @BindView(R.id.et_search)
    AutoCompleteTextView etSearch;
    @BindView(R.id.btn_search)
    Button btnSearch;
    @BindView(R.id.et_search2)
    AutoCompleteTextView etSearch2;
    public static void show(Context context){
        Intent intent=new Intent(context,RecheckLoadingActivity.class);
        context.startActivity(intent);
    }
    @Override
    protected void initView() {
        super.initView();
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        mBtnLeft.setVisibility(View.VISIBLE);
        setTitle("装车复核");
        addAdapter();
        getDate("","");
        LoadingUtil.showLoading(this);

    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void MessageEventBus(MessageEvent msg) {
        getDate(etSearch.getText().toString(),etSearch2.getText().toString());
    }

    private void addAdapter() {
        mAdapter = new RecheckLoadingAdapter(this);
        SwingBottomInAnimationAdapter swingBottomInAnimationAdapter = new SwingBottomInAnimationAdapter(new SwipeDismissAdapter(mAdapter, this));
        swingBottomInAnimationAdapter.setInitialDelayMillis(300);
        swingBottomInAnimationAdapter.setAbsListView(mListView);

        mListView.setAdapter(swingBottomInAnimationAdapter);

    }

    @Override
    protected int getContentResId() {
        return R.layout.activity_picking;
    }

    private void getDate(String searchKey,String searchKey2) {
        Map<String, String> params = new HashMap<>();
        String url = Constance.getwvGiControllerURL() + "?username=" + SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.LOGINNAME);
        url += "&searchstr=" + searchKey;
        url += "&searchstr2=" + searchKey2;
        HTTPUtils.get(this, url, new VolleyListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }

            @Override
            public void onResponse(String response) {
                RecheckLoadingListVm vm = GsonUtils.parseJSON(response, RecheckLoadingListVm.class);
                if(vm!=null&&vm.getObj()!=null) {
                    Date d = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String dateNowStr = sdf.format(d);
                    for (RecheckLoadingVm vms : vm.getObj()) {
                        vms.setCheckData(dateNowStr);
                    }
                    mAdapter.setRecheckLoadingList(vm.getObj());
                    mAdapter.notifyDataSetChanged();
                    LoadingUtil.hideLoading();

                }
            }
        });
    }

    @Override
    public void onDismiss(@NonNull ViewGroup listView, @NonNull int[] reverseSortedPositions) {
        for (int position : reverseSortedPositions) {
            mAdapter.remove(position);
        }
    }

    @OnClick({R.id.et_search, R.id.btn_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.et_search:
                break;
            case R.id.btn_search:
                getDate(etSearch.getText().toString(),etSearch2.getText().toString());
                break;
        }
    }
}
