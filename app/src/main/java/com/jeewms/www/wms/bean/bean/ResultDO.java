//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.jeewms.www.wms.bean.bean;
/**
 * @Title: Controller
 * @Description: 出货通知
 * @author erzhongxmu
 * @date 2017-08-15 23:18:59
 * @version V1.0
 *
 */
import java.io.Serializable;

public class ResultDO<T>  implements Serializable {
    private boolean ok;
    private T obj;
    private String errorMsg;
    private String errorCode;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public ResultDO() {
    }
    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public T getObj() {
        return this.obj;
    }

    public ResultDO<T> setObj(T obj) {
        this.obj = obj;
        return this;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
