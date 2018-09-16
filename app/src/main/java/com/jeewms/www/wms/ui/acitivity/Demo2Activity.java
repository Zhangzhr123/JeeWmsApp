package com.jeewms.www.wms.ui.acitivity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.widget.TextView;

import com.jeewms.www.wms.R;
import com.jeewms.www.wms.bean.bean.MessageEvent;
import com.jeewms.www.wms.util.Logutil;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by 13799 on 2018/8/5.
 */

public class Demo2Activity extends Activity {

    String str;
    @BindView(R.id.tv_jiaojiedan)
    TextView tvJiaojiedan;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        ButterKnife.bind(this);
        tvJiaojiedan.setText("demo2");
        str = getIntent().getStringExtra("key");
        Logutil.print("接收到的值==" + str);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    @OnClick(R.id.tv_jiaojiedan)
    public void onViewClicked() {
        EventBus.getDefault().post(new MessageEvent("key1","13777777"));
        List<String> lists = new ArrayList<>();
    }
}
