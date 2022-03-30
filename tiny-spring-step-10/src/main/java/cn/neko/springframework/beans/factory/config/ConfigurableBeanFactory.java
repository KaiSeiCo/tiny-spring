package cn.neko.springframework.beans.factory.config;

import cn.neko.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @Author: Elaina
 * @Date: 2022/3/14 15:01
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    public static final String SCOPE_SINGLETON = "singleton";

    public static final String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    /**
     * 销毁单例对象
     */
    void destroySingletons();
}
