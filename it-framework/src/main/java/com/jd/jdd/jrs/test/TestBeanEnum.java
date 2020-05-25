package com.jd.jdd.jrs.test;

import com.jd.jdd.jrs.it.framework.model.TableFieldEnum;

public enum TestBeanEnum implements TableFieldEnum {

    ADMIN("10","管理");

    ;

    private String code;
    private String desc;

    private TestBeanEnum(String code,String desc){
        this.code = code;
        this.desc = desc;
    }
    @Override
    public String getDesc() {
        return null;
    }

    @Override
    public String getCode() {
        return null;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
