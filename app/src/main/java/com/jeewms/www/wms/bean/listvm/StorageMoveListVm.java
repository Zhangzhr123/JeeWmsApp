package com.jeewms.www.wms.bean.listvm;

import com.jeewms.www.wms.bean.vm.StorageMoveVm;

import java.util.List;

/**
 * Created by 13799 on 2018/6/23.
 */

public class StorageMoveListVm {
    private String errorCode;
    private String ok;
    private String errorMsg;
    private List<StorageMoveVm> obj;

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

    public List<StorageMoveVm> getObj() {
        return obj;
    }

    public void setObj(List<StorageMoveVm> obj) {
        this.obj = obj;
    }
}
