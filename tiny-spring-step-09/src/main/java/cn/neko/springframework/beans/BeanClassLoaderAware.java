package cn.neko.springframework.beans;

import cn.neko.springframework.beans.factory.Aware;

/**
 * @Author: Elaina
 * @Date: 2022/3/26 12:49
 */
public interface BeanClassLoaderAware extends Aware {

    void setBeanClassLoader(ClassLoader classLoader);
}
