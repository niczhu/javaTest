package com.md.test;

import com.md.it.framework.model.TableFieldEnum;

public enum TestBeanEnum implements TableFieldEnum {

    ADMIN("10", "管理");;

    private String code;
    private String desc;

    private TestBeanEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String getDesc() {
        return this.desc;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
