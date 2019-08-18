package com.jeewms.www.wms.ui.acitivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.jeewms.www.wms.bean.bean.MessageEvent;
import com.jeewms.www.wms.util.LoadingUtil;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.OnDismissCallback;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.SwipeDismissAdapter;
import com.jeewms.www.wms.R;
import com.jeewms.www.wms.base.BaseActivity;
import com.jeewms.www.wms.bean.listvm.InventoryListVm;
import com.jeewms.www.wms.constance.Constance;
import com.jeewms.www.wms.ui.adapter.InventoryAdapter;
import com.jeewms.www.wms.util.GsonUtils;
import com.jeewms.www.wms.util.Logutil;
import com.jeewms.www.wms.util.SharedPreferencesUtil;
import com.jeewms.www.wms.util.listviewanimations.swinginadapters.prepared.SwingBottomInAnimationAdapter;
import com.jeewms.www.wms.volley.HTTPUtils;
import com.jeewms.www.wms.volley.VolleyListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 13799 on 2018/6/7.
 * <p>
 * 盘点
 */

public class InventoryActivity extends BaseActivity implements OnDismissCallback {

    InventoryAdapter mAdapter;
    @BindView(R.id.activity_googlecards_listview)
    ListView mListView;
    @BindView(R.id.et_search)
    AutoCompleteTextView etSearch;
    @BindView(R.id.btn_search)
    Button btnSearch;
    @BindView(R.id.et_search2)
    AutoCompleteTextView etSearch2;
    public static void show(Context context) {
        Intent intent = new Intent(context, InventoryActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initView() {
        super.initView();
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        mBtnLeft.setVisibility(View.VISIBLE);
        setTitle("盘点");
        addAdapter();

        etSearch.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int i, KeyEvent keyEvent) {

                if (i == KeyEvent.KEYCODE_ENTER) {
                    getDate(etSearch.getText().toString(),etSearch2.getText().toString());
                    final EditText et_search2 = (EditText) findViewById(R.id.et_search2);
                    et_search2.requestFocus();
                    return true;
                }
                return false;
            }
        });

        etSearch2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int i, KeyEvent keyEvent) {

                if (i == KeyEvent.KEYCODE_ENTER) {
                    getDate(etSearch.getText().toString(),etSearch2.getText().toString());
                    final EditText et_search2 = (EditText) findViewById(R.id.et_search2);
                    et_search2.setText("");
                    return true;
                }
                return false;
            }
        });



        etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_GO){
                    getDate(etSearch.getText().toString(),etSearch2.getText().toString());
                    return true;
                }
                return false;
            }
        });
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
        mAdapter = new InventoryAdapter(this);
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
        String url=Constance.getSttInGoodsControllerURL()+ "?username="+ SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.LOGINNAME);
        url+="&searchstr="+searchKey;
        url += "&searchstr2=" + searchKey2;
        Logutil.print("url"+url);

        HTTPUtils.get(this,url, new VolleyListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }

            @Override
            public void onResponse(String response) {
                InventoryListVm vm = GsonUtils.parseJSON(response, InventoryListVm.class);
                Logutil.print("vm=="+vm.getObj().size());
                mAdapter.seInventoryList(vm.getObj());
                mAdapter.notifyDataSetChanged();
                LoadingUtil.hideLoading();

            }
        });
    }

    @Override
    public void onDismiss(@NonNull ViewGroup listView, @NonNull int[] reverseSortedPositions) {
        for (int position : reverseSortedPositions) {
            mAdapter.remove(position);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_search)
    public void onViewClicked() {
//        getDate(etSearch.getText().toString());
        getDate(etSearch.getText().toString(),etSearch2.getText().toString());
    }
}
