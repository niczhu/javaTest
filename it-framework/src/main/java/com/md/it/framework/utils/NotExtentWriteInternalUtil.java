package com.md.it.framework.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * NotExtentWriteInternalUtil
 *
 * @author zhuhaipeng6 in 2020/8/4 20:01
 * @version 1.0
 **/
public class NotExtentWriteInternalUtil {
    private static List<String> notExtentPackagePrefix = new ArrayList<>();

    public NotExtentWriteInternalUtil() {
    }

    public static List<String> getNotExtentWritePackages() {
        return notExtentPackagePrefix;
    }

    public static void setNotExtentWritePackages(String packageName) {
        if (null != notExtentPackagePrefix) {
            notExtentPackagePrefix.add(packageName);
        }
    }

    static {
//        notExtentPackagePrefix.add("springfox.documentation");
//        notExtentPackagePrefix.add("io.swagger");
    }

}
