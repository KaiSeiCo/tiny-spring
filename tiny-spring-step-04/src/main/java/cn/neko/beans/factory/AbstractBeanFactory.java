package cn.neko.beans.factory;

import cn.neko.beans.BeanDefinition;
import cn.neko.beans.exception.BeansException;
import cn.neko.beans.registry.DefaultSingletonBeanRegistry;

import java.beans.Beans;


/**
 * 抽象Bean工厂
 * @Author: Elaina
 * @Date: 2022/3/13 16:33
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {


    @Override
    public Object getBean(String beanName) throws BeansException {
        return doGetBean(beanName, null);
    }

    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        return doGetBean(beanName, args);
    }

    protected <T> T doGetBean(final String name, final Object[] args) throws BeansException {
        Object bean = getSingleton(name);
        if (bean != null) {
            return (T) bean;
        }
        // 没有获取到bean则做相应的实例化操作, 由具体实现完成
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;
}
