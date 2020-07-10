package com.md.mp.dal.bean;

import java.io.Serializable;

/**
 * BaseBean
 *
 * @author zhuhaipeng6 in 2020/5/11 15:39
 * @version 1.0
 **/
public class BaseBean implements Serializable {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
