package com.ys.inventory.system.log.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 每个类的功能描述
 * @author gp
 * @version 2018/06/20
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogModule {

    /**
     * 模块名称
     * @return
     */
    String moduleName() default "";
}
