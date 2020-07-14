package com.md.mp.dal.bean;

import com.baomidou.mybatisplus.annotation.*;
import com.md.it.framework.constraint.annotation.NotNull;
import com.md.mp.base.model.AbstractBean;
import com.md.mp.base.model.BaseBean;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.annotations.Options;

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
public class MpAccountBean extends AbstractBean implements BaseBean {

    private static final long serialVersionUID = -1L;

    @TableId(value = "id", type = IdType.AUTO)
    private long id;

    @NotNull
    private String pin;

    private String name;

    private String mobile;

    private String organizationCode;

    private int age;

    private Date birthDay;

    private String status;


}
