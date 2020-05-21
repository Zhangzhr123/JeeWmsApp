package com.jeewms.www.wms.bean.vm;

import com.jeewms.www.wms.bean.bean.TSUser;

/**
 * Created by 13799 on 2018/6/2.
 */

public class LoginVm {

//    {"errorCode":null,"ok":false,"errorMsg":"用户账号密码错误!","obj":null}
    private String errorCode;
    private boolean ok;
    private String errorMsg;
//    private TSUser obj;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
//
//    public TSUser getObj() {
//        return obj;
//    }
//
//    public void setObj(TSUser obj) {
//        this.obj = obj;
//    }

}
