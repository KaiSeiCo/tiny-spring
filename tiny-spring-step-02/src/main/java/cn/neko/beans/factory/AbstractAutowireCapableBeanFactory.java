package cn.neko.beans.factory;

import cn.neko.beans.BeanDefinition;
import cn.neko.beans.exception.BeansException;

/**
 * @Author: Elaina
 * @Date: 2022/3/13 16:32
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {


    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        addSingleton(beanName, bean);
        return bean;
    }
}
