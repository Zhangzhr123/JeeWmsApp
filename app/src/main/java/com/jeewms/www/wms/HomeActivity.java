package com.jeewms.www.wms;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.jeewms.www.wms.base.BaseActivity;
import com.jeewms.www.wms.bean.bean.HomeBtnBean;
import com.jeewms.www.wms.constance.Constance;
import com.jeewms.www.wms.ui.acitivity.SAPReceiptActivity;
import com.jeewms.www.wms.ui.adapter.HomeGridAdapter;
import com.jeewms.www.wms.util.SharedPreferencesUtil;
import com.jeewms.www.wms.util.StringUtil;

import java.util.ArrayList;

/**
 * Created by 13799 on 2018/7/2.
 */

public class HomeActivity extends BaseActivity {

    HomeGridAdapter adapter;
    GridView gvHome;
    LinearLayout ll_Main;
    TextView tv_User;
    Boolean isShow = false;

    ArrayList<HomeBtnBean> list = new ArrayList<>();
    public static void show(Context context) {
        Intent intent = new Intent(context, HomeActivity.class);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);
        init();
    }

    private void init() {
        //获取控件
        ll_Main = (LinearLayout)findViewById(R.id.ll_Main);
        tv_User = (TextView) findViewById(R.id.tv_User);
        //设置用户名
        if(!StringUtil.isEmpty(SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.USERNAME))){
            tv_User.setText(SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.USERNAME));
        }
        //点击用户名
        findViewById(R.id.tv_User).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isShow){
                    isShow = false;
                    ll_Main.setVisibility(View.GONE);
                }else{
                    isShow = true;
                    ll_Main.setVisibility(View.VISIBLE);
                }

            }
        });
        //更新按钮
        findViewById(R.id.btn_Update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //退出按钮
        findViewById(R.id.btn_Finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //清空保存数据
                SharedPreferencesUtil.getInstance(HomeActivity.this).setKeyValue(Constance.SHAREP.USERNAME, "");
                SharedPreferencesUtil.getInstance(HomeActivity.this).setKeyValue(Constance.SHAREP.DEPT, "");
                SharedPreferencesUtil.getInstance(HomeActivity.this).setKeyValue(Constance.SHAREP.COMPANY, "");
                SharedPreferencesUtil.getInstance(HomeActivity.this).setKeyValue(Constance.SHAREP.PASSWORD,"");
                //退出
                LoginActivity.show(HomeActivity.this);
                finish();
            }
        });

        adapter = new HomeGridAdapter();
        gvHome =findViewById(R.id.gv_home);
        gvHome.setAdapter(adapter);
        addBtn();

    }
    //添加按钮
    private void addBtn() {
        list.clear();
        for (int i = 0; i < Constance.btnNameList.length; i++) {
            addBtn2List(Constance.btnNameList[i], Constance.btnImgList[i]);
        }
        adapter.setList(list);
        adapter.notifyDataSetChanged();
    }

    private void addBtn2List(String btnName, int imgResId) {
        HomeBtnBean btn1 = new HomeBtnBean();
        btn1.setBtnName(btnName);
        btn1.setImaResId(imgResId);
        list.add(btn1);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //右方向键
        switch (keyCode) {
            case 8://右方向键
                SAPReceiptActivity.show(this);
                break;

        }
        return super.onKeyDown(keyCode, event);
    }
}
