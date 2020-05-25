package com.jd.jdd.jrs.test;

import com.alibaba.fastjson.annotation.JSONField;
import com.jd.jdd.jrs.it.framework.utils.ToString;
import com.jd.jdd.jrs.it.framework.constraint.annotation.Length;
import com.jd.jdd.jrs.it.framework.constraint.annotation.NotNull;
import org.hibernate.validator.constraints.NotBlank;

public class TestBean extends ToString
{
    @NotBlank
    private String name;

    @NotNull
    private String id;

    @Length(min = 1,max = 3)
    private int age;
    @JSONField(name = "test")
    private TestBeanEnum testBean;

    public TestBeanEnum getTestBean() {
        return testBean;
    }

    public void setTestBean(TestBeanEnum testBean) {
        this.testBean = testBean;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
