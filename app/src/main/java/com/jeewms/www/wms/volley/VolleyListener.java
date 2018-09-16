package com.jeewms.www.wms.volley;

import com.android.volley.Response;
import com.android.volley.Response.Listener;

public abstract class VolleyListener implements Response.ErrorListener, Listener<String>{
    /** 访问成功或者失败都会调用此方法，可以在这里做progressBar的操作或者其他*/
    public void requestComplete(){};
}
