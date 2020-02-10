package com.test.it.framework.exception;

public class PrjException extends BasePrjException {

    private static final long serialVersionUID = -7576992670473664947L;
    private int code;
    private String detail;
    private String viewName;

    public PrjException(int code, String msg, String detail) {
        super(msg);
        this.code = code;
        this.detail = detail;
    }

    public PrjException(String viewName, int code, String msg, String detail) {
        this(code, msg, detail);
        this.viewName = viewName;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDetail() {
        return this.detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getViewName() {
        return this.viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }
}
