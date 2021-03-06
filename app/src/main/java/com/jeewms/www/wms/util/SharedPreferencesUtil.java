package com.jeewms.www.wms.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.jeewms.www.wms.constance.Constance;

/**
 * Created by 13799 on 2018/6/2.
 */

public class SharedPreferencesUtil {
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    private static volatile SharedPreferencesUtil instance = null;

    public static SharedPreferencesUtil getInstance(Context context) {
        if (instance == null) {
            instance = new SharedPreferencesUtil(context);
        }
        return instance;
    }


    public SharedPreferencesUtil(Context context) {
        sp = context.getSharedPreferences(Constance.SHAREP.SHAREDSAVE, context.MODE_PRIVATE);
        editor = sp.edit();
    }

    //设置值
    public void setKeyValue(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    //获取值
    public String getKeyValue(String key) {
        return sp.getString(key, "");
    }

    public void clear() {
        editor.clear();
        editor.commit();
    }
}
