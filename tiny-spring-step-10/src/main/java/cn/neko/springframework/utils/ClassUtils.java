package cn.neko.springframework.utils;

import cn.neko.springframework.beans.factory.support.CglibSubclassingInstantiationStrategy;
import cn.neko.springframework.context.ApplicationListener;

/**
 * @Author: Elaina
 * @Date: 2022/3/14 15:04
 */
public class ClassUtils {
    public static ClassLoader getDefaultClassLoader() {
        ClassLoader cl = null;
        try {
            cl = Thread.currentThread().getContextClassLoader();
        }
        catch (Throwable ex) {
            // Cannot access thread context ClassLoader - falling back to system class loader...
        }
        if (cl == null) {
            // No thread context class loader -> use class loader of this class.
            cl = ClassUtils.class.getClassLoader();
        }
        return cl;
    }

    /**
     * Check whether the specified class is a CGLIB-generated class.
     * @param clazz the class to check
     */
    public static boolean isCglibProxyClass(Class<?> clazz) {
        return (clazz != null && isCglibProxyClassName(clazz.getName()));
    }

    /**
     * Check whether the specified class name is a CGLIB-generated class.
     * @param className the class name to check
     */
    private static boolean isCglibProxyClassName(String className) {
        return (className != null && className.contains("$$"));
    }
}
