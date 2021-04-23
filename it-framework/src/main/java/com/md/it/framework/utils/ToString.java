package com.md.it.framework.utils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * ToString
 *
 * @author zhuhaipeng6 in 2020/2/25
 * @version 1.0
 **/
public class ToString implements Serializable {

    private static final long serialVersionUID = -7187454415838423368L;
    /**
     * 缓存
     */
    private static Map<Class<?>, Field[]> filedMap = new HashMap();
    /**
     * 序列化常量key
     */
    private final String SERIAL_VERSION_UID = "serialVersionUID";

    public ToString() {
    }

    public String toString() {
        Field[] fields = null;
        int i;
        if (filedMap.containsKey(this.getClass())) {
            fields = (Field[]) filedMap.get(this.getClass());
        } else {
            fields = this.getClass().getDeclaredFields();
            Field[] fields2 = fields;
            i = fields.length;

            for (int j = 0; j < i; ++j) {
                Field field = fields2[j];
                field.setAccessible(true);
            }
        }

        StringBuffer sb = new StringBuffer("{");

        for (i = 0; i < fields.length; ++i) {
            Field field = fields[i];
            if (!field.getName().equals(SERIAL_VERSION_UID)) {
                try {
                    Object value = field.get(this);
                    sb.append(String.format("%s: %s", field.getName(), value));
                    if (i != fields.length - 1) {
                        sb.append(", ");
                    }
                } catch (IllegalArgumentException e1) {
                    e1.printStackTrace();
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                }
            }
        }

        sb.append("}");
        return sb.toString();
    }
}
