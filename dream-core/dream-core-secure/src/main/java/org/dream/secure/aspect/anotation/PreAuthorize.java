package org.dream.secure.aspect.anotation;

import java.lang.annotation.*;

/**
 * @Author 刘牌
 * @Opration 权限注解
 * @Date 2020/3/15 0015 19:16
 * @Version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Inherited
public @interface PreAuthorize {
    String[] value() default {}  ;
}
