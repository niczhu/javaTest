package com.jd.jdd.jrs.mp.dal.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * MpAccountBean
 *
 * @author zhuhaipeng6 in 2020/5/9 18:18
 * @version 1.0
 **/
@Setter
@Getter
public class MpAccountModel extends BaseModel{
    private String id;
    private String pin;
    private String name;
    private String mobile;
    private String organizationCode;
    private int age;
    private Date birthDay;
    private String status;
}
