package com.jeewms.www.wms;

import android.os.Bundle;
import android.os.Handler;
import android.widget.LinearLayout;

import com.android.volley.VolleyError;
import com.jeewms.www.wms.base.BaseActivity;
import com.jeewms.www.wms.bean.vm.LoginVm;
import com.jeewms.www.wms.constance.Constance;
import com.jeewms.www.wms.util.GsonUtils;
import com.jeewms.www.wms.util.SharedPreferencesUtil;
import com.jeewms.www.wms.util.StringUtil;
import com.jeewms.www.wms.volley.HTTPUtils;
import com.jeewms.www.wms.volley.VolleyListener;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 13799 on 2018/6/7.
 */

public class WelComeActivity extends BaseActivity {


    @BindView(R.id.ll_root)
    LinearLayout llRoot;
    private int status;

    @Override
    protected int getTitleBarResId() {
        return -1;
    }

    @Override
    protected int getContentResId() {
        return R.layout.activity_linear;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        llRoot.setBackgroundResource(R.drawable.welcome);
        if (!StringUtil.isEmpty(SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.PASSWORD))) {
            doLogin(SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.LOGINNAME), SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.PASSWORD));
        }else {
            LoginActivity.show(this);
            finish();
        }
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (status == 0) {
                    status++;
                } else {
                    HomeActivity.show(WelComeActivity.this);
                    finish();
                }
            }
        }, 3000);
    }

    public void doLogin(String username, String password) {
        Map<String, String> params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);

        Constance.setBaseUrl(SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.HTTPADDRESS));
        HTTPUtils.post(this, Constance.getLoginURL(), params, new VolleyListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                LoginActivity.show(getActivity());
                finish();
            }

            @Override
            public void onResponse(String response) {
                LoginVm vm = GsonUtils.parseJSON(response, LoginVm.class);
                if (vm.isOk()) {
                    if (status == 0) {
                        status++;
                    } else {
                        HomeActivity.show(WelComeActivity.this);
                        finish();
                    }
                } else {
                    LoginActivity.show(getActivity());
                    finish();
                }
            }
        });
    }

}
