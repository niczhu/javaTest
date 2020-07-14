package com.md.mp.dal.model;

import com.md.mp.base.model.AbstractModel;
import com.md.mp.base.model.BaseModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * MpAccountBean
 *
 * @author zhuhaipeng6 in 2020/5/9 18:18
 * @version 1.0
 **/
@Setter
@Getter
@ToString
public class MpAccountModel extends AbstractModel implements BaseModel{

    private static final long serialVersionUID = -1L;

    private long id;

    private String pin;

    private String name;

    private String mobile;

    private String organizationCode;

    private int age;

    private Date birthDay;

    private String status;

    private int version;

    private int deleteFlag;

    private String modifiedBy;

    private Date modifiedTime;

    private String createdBy;

    private Date createdTime;

}
