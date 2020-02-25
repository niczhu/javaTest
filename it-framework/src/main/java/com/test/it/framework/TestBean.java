package com.test.it.framework;

import com.test.it.framework.constraint.annotation.NotNull;
import com.test.it.framework.utils.ToString;
import org.hibernate.validator.constraints.NotBlank;

public class TestBean extends ToString
{
    @NotBlank
    private String name;

    @NotNull
    private String id;

    private int age;

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
}
