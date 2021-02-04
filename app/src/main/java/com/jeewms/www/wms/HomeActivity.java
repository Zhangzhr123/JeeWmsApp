package com.jeewms.www.wms;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.*;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.volley.VolleyError;
import com.jeewms.www.wms.base.BaseActivity;
import com.jeewms.www.wms.bean.bean.HomeBtnBean;
import com.jeewms.www.wms.bean.bean.ResultDO;
import com.jeewms.www.wms.bean.vm.LoginVm;
import com.jeewms.www.wms.constance.Constance;
import com.jeewms.www.wms.ui.acitivity.SAPReceiptActivity;
import com.jeewms.www.wms.ui.adapter.HomeGridAdapter;
import com.jeewms.www.wms.util.GsonUtils;
import com.jeewms.www.wms.util.SharedPreferencesUtil;
import com.jeewms.www.wms.util.StringUtil;
import com.jeewms.www.wms.util.ToastUtil;
import com.jeewms.www.wms.volley.HTTPUtils;
import com.jeewms.www.wms.volley.VolleyListener;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    List<String> nameList = new ArrayList<>();

    public static void show(Context context) {
        Intent intent = new Intent(context, HomeActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);
        init();
        //权限控制
        jurisdiction();
    }

    private void init() {
        //获取控件
        ll_Main = (LinearLayout) findViewById(R.id.ll_Main);
        tv_User = (TextView) findViewById(R.id.tv_User);
        //设置用户名
        if (!StringUtil.isEmpty(SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.USERNAME))) {
            tv_User.setText(SharedPreferencesUtil.getInstance(this).getKeyValue(Constance.SHAREP.USERNAME));
        }
        //点击用户名
        findViewById(R.id.tv_User).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isShow) {
                    isShow = false;
                    ll_Main.setVisibility(View.GONE);
                } else {
                    isShow = true;
                    ll_Main.setVisibility(View.VISIBLE);
                }

            }
        });
        //更新按钮
        findViewById(R.id.btn_Update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = SharedPreferencesUtil.getInstance(HomeActivity.this).getKeyValue(Constance.SHAREP.HTTPADDRESS) + Constance.download;
                download(url);
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
                SharedPreferencesUtil.getInstance(HomeActivity.this).setKeyValue(Constance.SHAREP.PASSWORD, "");
                //退出
                LoginActivity.show(HomeActivity.this);
                finish();
            }
        });

//        adapter = new HomeGridAdapter();
//        gvHome = findViewById(R.id.gv_home);
//        gvHome.setAdapter(adapter);
//        addBtn();

    }

    //权限控制
    public void jurisdiction() {
        Map<String, String> params = new HashMap<>();
        params.put("username", SharedPreferencesUtil.getInstance(HomeActivity.this).getKeyValue(Constance.SHAREP.LOGINNAME));
        params.put("password", SharedPreferencesUtil.getInstance(HomeActivity.this).getKeyValue(Constance.SHAREP.PASSWORD));

        String url = SharedPreferencesUtil.getInstance(HomeActivity.this).getKeyValue(Constance.SHAREP.HTTPADDRESS) + Constance.LOGIN;

        HTTPUtils.post(this, url, params, new VolleyListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                ToastUtil.show(HomeActivity.this, "网络连接失败");
            }

            @Override
            public void onResponse(String response) {
                nameList.clear();
                LoginVm vm = GsonUtils.parseJSON(response, LoginVm.class);
                //判断是否拥有PDA权限
                if (vm.isOk()) {
                    //获取json内的数据
                    JSONObject jsonobj = JSON.parseObject(response);
                    if (jsonobj != null && jsonobj.getJSONObject("obj") != null) {
//                        System.out.println(jsonobj.getJSONObject("obj").getString("appPermission"));
                        //获取用户权限
                        String s = jsonobj.getJSONObject("obj").getString("appPermission");
                        if (s != null && !StringUtil.isEmpty(s)) {
                            String[] split = s.split(",");
                            if (split.length > 0 && split != null) {
                                for (int i = 0; i < split.length; i++) {
                                    nameList.add(split[i]);
                                }
                                //权限控制
                                adapter = new HomeGridAdapter();
                                gvHome = findViewById(R.id.gv_home);
                                gvHome.setAdapter(adapter);
                                addBtn2(nameList);
                            } else {
                                ToastUtil.show(HomeActivity.this, "用户没有操作PDA权限");
                            }
                        } else {
                            ToastUtil.show(HomeActivity.this, "用户没有操作PDA权限");
                        }
                    } else {
                        ToastUtil.show(HomeActivity.this, "用户没有操作PDA权限");
                    }


                } else {
                    ToastUtil.show(HomeActivity.this, vm.getErrorMsg());
                }
            }
        });
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

    //添加按钮
    private void addBtn2(List<String> nameList) {
        list.clear();
        for (int j = 0; j < nameList.size(); j++) {
            for (int i = 0; i < Constance.btnNameList.length; i++) {
                if (nameList.get(j).equals(Constance.btnNameList[i])) {
                    addBtn2List(Constance.btnNameList[i], Constance.btnImgList[i]);
                }
            }
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
//        switch (keyCode) {
//            case 8://1
//                SAPReceiptActivity.show(this);
//                break;
//
//        }
        return super.onKeyDown(keyCode, event);
    }

    //根据地址下载APK并自动安装
    public void download(String url) {
        final DownloadManager dManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        // 设置下载路径和文件名
        request.setDestinationInExternalPublicDir("download", "wms.apk");
        request.setDescription("软件新版本下载");
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setMimeType("application/vnd.android.package-archive");
        // 设置为可被媒体扫描器找到
        request.allowScanningByMediaScanner();
        // 设置为可见和可管理
        request.setVisibleInDownloadsUi(true);
        // 获取此次下载的ID
        final long refernece = dManager.enqueue(request);
        // 注册广播接收器，当下载完成时自动安装
        IntentFilter filter = new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
        BroadcastReceiver receiver = new BroadcastReceiver() {

            public void onReceive(Context context, Intent intent) {
                long myDwonloadID = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
                if (refernece == myDwonloadID) {
                    unregisterReceiver(this);
                    Intent install = new Intent(Intent.ACTION_VIEW);
                    Uri downloadFileUri = dManager.getUriForDownloadedFile(refernece);
                    install.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    install.setDataAndType(downloadFileUri, "application/vnd.android.package-archive");
                    startActivity(install);
                }
            }
        };
        registerReceiver(receiver, filter);
    }

}
