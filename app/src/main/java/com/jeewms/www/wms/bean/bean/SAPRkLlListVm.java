package com.jeewms.www.wms.bean.bean;

import java.util.List;

/**
 * Created by 13799 on 2018/6/23.
 */

public class SAPRkLlListVm {
    private String errorCode;
    private Boolean ok;
    private String errorMsg;
    private List<RkWmsScllEntity> obj;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Boolean getOk() {
        return ok;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public List<RkWmsScllEntity> getObj() {
        return obj;
    }

    public void setObj(List<RkWmsScllEntity> obj) {
        this.obj = obj;
    }
}
