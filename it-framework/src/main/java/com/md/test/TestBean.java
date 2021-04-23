package com.md.test;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.md.it.framework.constraint.annotation.NotBlank;
import com.md.it.framework.model.TableFieldEnum;
import com.md.it.framework.support.converter.TableFieldEnumSerializer;
import com.md.it.framework.utils.ToString;
import com.md.it.framework.constraint.annotation.Length;
import com.md.it.framework.constraint.annotation.NotNull;

public class TestBean extends ToString
{
    @NotBlank(propName = "name")
    private String name;

    @NotNull
    private String id;

    @Length(min = 1,max = 3)
    private int age;

    @JSONField(serializeUsing = TableFieldEnumSerializer.class)
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
