package com.md.it.framework.support;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * SupportProperties
 *
 * @author zhuhaipeng6 in 2020/8/5 19:36
 * @version 1.0
 **/
@Component
@ConfigurationProperties(prefix = "system.support", ignoreInvalidFields = true)
public class SupportProperties {

    private boolean swaggerEnable = false;

    public boolean isSwaggerEnable() {
        return swaggerEnable;
    }

    public void setSwaggerEnable(boolean swaggerEnable) {
        this.swaggerEnable = swaggerEnable;
    }
}
