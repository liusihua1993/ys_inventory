package com.ys.inventory.system.log.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 方法描述
 * @author gp
 * @version 2018/06/20
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LogAction {

    /**
     * 操作说明
     * @return
     */
    String value() default "";
}
