package com.md.mp.dal.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import com.md.it.framework.constraint.annotation.NotNull;
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
@TableName("mp_account")
public class MpAccountBean extends BaseBean {

    private String id;

    @NotNull
    private String pin;

    private String name;
    private String mobile;
    private String organizationCode;
    private int age;
    private Date birthDay;
    private String status;


}
