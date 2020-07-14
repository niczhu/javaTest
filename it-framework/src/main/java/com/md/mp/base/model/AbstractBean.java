package com.md.mp.base.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;

import java.util.Date;

/**
 * AbstractBean
 *
 * @author zhuhaipeng6 in 2020/7/14 14:17
 * @version 1.0
 **/
public abstract class AbstractBean {

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String modifiedBy;

//    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date modifiedTime;

    @TableField(fill = FieldFill.INSERT)
    private String createdBy;

    private Date createdTime;

    @Version
    private int version;

    @TableLogic
    private int deleteFlag;

}
