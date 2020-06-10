package com.sodacar.starter.sms.weimi;

import java.io.Serializable;

public class WeimiResponse implements Serializable {
    private static final long serialVersionUID = -5580022688238931923L;

    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
