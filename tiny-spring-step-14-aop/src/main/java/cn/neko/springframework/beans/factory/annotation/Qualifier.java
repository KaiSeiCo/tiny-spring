package cn.neko.springframework.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * @Author: Elaina
 * @Date: 2022/3/29 19:13
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Qualifier {
    String value() default "";
}
