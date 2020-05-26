package com.jeewms.www.wms;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.*;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.volley.VolleyError;
import com.jeewms.www.wms.base.BaseActivity;
import com.jeewms.www.wms.bean.vm.LoginVm;
import com.jeewms.www.wms.constance.Constance;
import com.jeewms.www.wms.util.GsonUtils;
import com.jeewms.www.wms.util.SharedPreferencesUtil;
import com.jeewms.www.wms.util.StringUtil;
import com.jeewms.www.wms.util.ToastUtil;
import com.jeewms.www.wms.volley.HTTPUtils;
import com.jeewms.www.wms.volley.VolleyListener;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zhangzhr
 * Created Date 2020-05-20
 * 登录
 */

public class LoginActivity extends BaseActivity {

    @BindView(R.id.tv_userName)//登录名
            EditText tvUserName;
    @BindView(R.id.tv_password)//密码
            EditText tvPassword;
    @BindView(R.id.forgetPassword)//忘记密码
            TextView forgetPassword;
    @BindView(R.id.btn_login)//登录按钮
            Button btnLogin;
    @BindView(R.id.btn_register)//底部按钮
            Button btnRegister;
    @BindView(R.id.tv_address)//输入地址
            EditText tvAddress;
    @BindView(R.id.radio1)//单选框
            RadioButton radio1;
    @BindView(R.id.radio2)//单选框
            RadioButton radio2;
    @BindView(R.id.tv_setIP)//头部文本
            TextView tvSetIP;

    String addressTemp;//登录使用地址
    String addressPer;
    String userName;//登录人姓名
    private long exitTime = 0;

    public static void show(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int getContentResId() {
        return R.layout.activity_login;
    }

    @Override
    protected int getTitleBarResId() {
        return -1;
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //自动登录
        if (!StringUtil.isEmpty(SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.PASSWORD))) {
            doLogin(SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.LOGINNAME), SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.PASSWORD));
        }
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        if (!StringUtil.isEmpty(SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.LOGINNAME)) && tvUserName != null) {
            tvUserName.setText(SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.LOGINNAME));
            tvPassword.setFocusable(true);
            tvPassword.setFocusableInTouchMode(true);
            tvPassword.requestFocus();
            this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);

        }

        //设置点击事件
        tvSetIP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //设置登录IP地址
                final EditText et = new EditText(LoginActivity.this);
                et.setHint(Constance.COMMON_URL);
                new AlertDialog.Builder(LoginActivity.this).setTitle("请输入IP地址")
                        .setView(et)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //按下确定键后的事件
                                if (!StringUtil.isEmpty(et.getText().toString())) {
                                    addressTemp = et.getText().toString();
                                }
                                Toast.makeText(getApplicationContext(), et.getText().toString(), Toast.LENGTH_SHORT).show();
                            }
                        }).setNegativeButton("取消", null).show();
            }
        });

    }

    @OnClick({R.id.forgetPassword, R.id.btn_login, R.id.btn_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
//            case R.id.forgetPassword:
//                ToastUtil.show(this, "忘记密码");
//                break;
            case R.id.btn_login:
                check();
                break;
//            case R.id.btn_register:
//                ToastUtil.show(this, "注册");
//                break;
        }
    }

    private void check() {
        if (StringUtil.isEmpty(tvUserName.getText().toString())) {
            ToastUtil.show(this, "请输入用户名");
            return;
        }
        if (StringUtil.isEmpty(tvPassword.getText().toString())) {
            ToastUtil.show(this, "请输入密码");
            return;
        }
        doLogin(tvUserName.getText().toString(), tvPassword.getText().toString());
    }

    public void doLogin(String username, String password) {
        Map<String, String> params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);

        if (StringUtil.isEmpty(addressTemp)) {
            addressTemp = Constance.COMMON_URL;
        }

        HTTPUtils.post(this, addressTemp + Constance.LOGIN, params, new VolleyListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                ToastUtil.show(LoginActivity.this, "网络连接失败");
            }

            @Override
            public void onResponse(String response) {
                LoginVm vm = GsonUtils.parseJSON(response, LoginVm.class);
                if (vm.isOk()) {
                    //获取json内的数据
                    JSONObject jsonobj = JSON.parseObject(response);
//                    System.out.println(jsonobj.getJSONObject("obj"));
                    //获取用户名
                    userName = jsonobj.getJSONObject("obj").getString("realName");
                    //保存用户名/部门/公司
                    SharedPreferencesUtil.getInstance(LoginActivity.this).setKeyValue(Constance.SHAREP.USERNAME, userName);
                    SharedPreferencesUtil.getInstance(LoginActivity.this).setKeyValue(Constance.SHAREP.DEPT, jsonobj.getJSONObject("obj").getJSONObject("currentDepart").getString("orgCode"));
//                    SharedPreferencesUtil.getInstance(LoginActivity.this).setKeyValue(Constance.SHAREP.COMPANY, jsonobj.getJSONObject("obj").getJSONObject("currentDepart").getString("departname"));
                    //保存登录名、密码和IP地址并跳转到菜单页面
                    savePassword();
                } else {
                    ToastUtil.show(LoginActivity.this, vm.getErrorMsg());
                }
            }
        });
    }

    private void savePassword() {
        ToastUtil.show(this, "登陆成功");
        if (!StringUtil.isEmpty(tvPassword.getText().toString())) {
            SharedPreferencesUtil.getInstance(this).setKeyValue(Constance.SHAREP.LOGINNAME, tvUserName.getText().toString());
            SharedPreferencesUtil.getInstance(this).setKeyValue(Constance.SHAREP.PASSWORD, tvPassword.getText().toString());
        }
        if (!StringUtil.isEmpty(addressTemp)) {
            SharedPreferencesUtil.getInstance(this).setKeyValue(Constance.SHAREP.HTTPADDRESS, addressTemp);
        }
        HomeActivity.show(this);
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //返回键双击退出
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                ToastUtil.show(this, "再按一次退出程序");
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        //右方向键登录按钮
        if (keyCode == 22) {
            check();
        }
        return super.onKeyDown(keyCode, event);
    }
}
