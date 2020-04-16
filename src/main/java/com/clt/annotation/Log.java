package com.clt.annotation;

import com.clt.enums.LogOperationTypeEnum;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ：clt
 * @Date ：Created in 18:56 2020/04/16
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
    String value() default "";

    LogOperationTypeEnum method() default LogOperationTypeEnum.QUERY;
}
