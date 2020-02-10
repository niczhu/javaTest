package com.test.it.framework.utils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ToString implements Serializable {

    private static final long serialVersionUID = -7187454415838423368L;
    private static Map<Class<?>, Field[]> filedMap = new HashMap();

    public ToString() {
    }

    public String toString() {
        Field[] fileds = null;
        int i;
        if (filedMap.containsKey(this.getClass())) {
            fileds = (Field[])filedMap.get(this.getClass());
        } else {
            fileds = this.getClass().getDeclaredFields();
            Field[] var2 = fileds;
            i = fileds.length;

            for(int var4 = 0; var4 < i; ++var4) {
                Field field = var2[var4];
                field.setAccessible(true);
            }
        }

        StringBuffer sb = new StringBuffer("{");

        for(i = 0; i < fileds.length; ++i) {
            Field field = fileds[i];
            if (!field.getName().equals("serialVersionUID")) {
                try {
                    Object value = field.get(this);
                    sb.append(String.format("%s: %s", field.getName(), value));
                    if (i != fileds.length - 1) {
                        sb.append(", ");
                    }
                } catch (IllegalArgumentException var6) {
                    var6.printStackTrace();
                } catch (IllegalAccessException var7) {
                    var7.printStackTrace();
                }
            }
        }

        sb.append("}");
        return sb.toString();
    }
}
