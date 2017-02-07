package com.ioc.test.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by tangxu on 2017/1/14.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface LogInfo {
    public String value() default "";
}
