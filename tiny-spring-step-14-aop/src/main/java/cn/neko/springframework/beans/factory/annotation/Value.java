package cn.neko.springframework.beans.factory.annotation;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * @Author: Elaina
 * @Date: 2022/3/29 19:22
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Value {

    String value();
}
