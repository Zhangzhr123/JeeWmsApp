package com.jeewms.www.wms.bean.listvm;

import com.jeewms.www.wms.bean.vm.RecheckLoadingVm;

import java.util.List;

/**
 * Created by 13799 on 2018/7/5.
 */

public class RecheckLoadingListVm {
    private String errorCode;
    private String ok;
    private String errorMsg;
    private List<RecheckLoadingVm> obj;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public List<RecheckLoadingVm> getObj() {
        return obj;
    }

    public void setObj(List<RecheckLoadingVm> obj) {
        this.obj = obj;
    }
}
