package cn.neko.springframework.stereotype;

import java.lang.annotation.*;

/**
 * @Author: Elaina
 * @Date: 2022/3/29 12:36
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {

    String value() default "";
}
