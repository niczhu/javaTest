package com.md.it.framework.utils;

import java.util.List;

/**
 * Not
 *
 * @author zhuhaipeng6 in 2020/8/4 20:17
 * @version 1.0
 **/
public class Not extends NotExtentWriteInternalUtil {
    public Not() {
        List<String> pa = getNotExtentWritePackages();
        pa.add("com.jd.jdd");
    }
}
