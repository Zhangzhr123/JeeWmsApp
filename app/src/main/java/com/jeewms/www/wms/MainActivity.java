package com.jeewms.www.wms;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;

import com.hjm.bottomtabbar.BottomTabBar;
import com.jeewms.www.wms.ui.frag.FriendsFragment;
import com.jeewms.www.wms.ui.frag.HomeFragment;
import com.jeewms.www.wms.ui.frag.MineFragment;
import com.jeewms.www.wms.util.ToastUtil;

import butterknife.ButterKnife;

/**
 * Created by 13799 on 2018/5/29.
 */

public class MainActivity extends FragmentActivity {

    private BottomTabBar mBottomTabBar;
    private long exitTime = 0;



    public static void show(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        setContentView( R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    protected void initView() {
        mBottomTabBar = (BottomTabBar) findViewById(R.id.bottom_tab_bar);
        mBottomTabBar.init(getSupportFragmentManager(),720,1280)
                .setImgSize(50, 50)
                .setFontSize(12)
                .setTabPadding(10, 2, 5)
                .setChangeColor(Color.parseColor("#45ACF9"), Color.parseColor("#505050"))
                .addTabItem("首页", R.drawable.shouye_haoyou, R.drawable.shouye_haoyou, HomeFragment.class)
                .addTabItem("好友", R.drawable.shouye_haoyou, R.drawable.shouye_haoyou, FriendsFragment.class)
                .addTabItem("我的", R.drawable.shouye_haoyou, R.drawable.shouye_haoyou, MineFragment.class)
                .isShowDivider(true)
                .setDividerColor(getResources().getColor(R.color.divider_color))
                .setTabBarBackgroundColor(Color.parseColor("#00FF0000"))
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name, View view) {

                    }
                })
                .setSpot(0, true)
                .setSpot(1, true)
                .setSpot(2, false)
                .setCurrentTab(0);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
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
        return super.onKeyDown(keyCode, event);
    }
}
