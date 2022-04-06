package cn.neko.springframework.beans.factory.config;

import cn.neko.springframework.beans.BeansException;
import cn.neko.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * @Author: Elaina
 * @Date: 2022/3/17 10:24
 */
public interface BeanFactoryPostProcessor {

    /**
     * 在所有 BeanDefinition 加载完成后, 实例化 Bean 对象之前, 提供修改 BeanDefinition 属性的机制
     *
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
