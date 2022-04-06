package cn.neko.springframework.context.annotation;

import java.lang.annotation.*;

/**
 * 作用域注解
 * @Author: Elaina
 * @Date: 2022/3/29 12:13
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Scope {

    String value() default "singleton";
}
