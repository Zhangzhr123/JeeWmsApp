package com.jeewms.www.wms.bean.listvm;

import com.jeewms.www.wms.bean.vm.DemoVm;

import java.util.List;

/**
 * Created by 13799 on 2018/8/5.
 */

public class DemoListVm {
    private String errorCode;
    private boolean ok;
    private String errorMsg;
    private List<DemoVm> obj;

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

    public List<DemoVm> getObj() {
        return obj;
    }

    public void setObj(List<DemoVm> obj) {
        this.obj = obj;
    }
}
