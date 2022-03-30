package cn.neko.springframework.beans.factory;

import cn.neko.springframework.beans.BeansException;
import cn.neko.springframework.beans.factory.config.AutowireCapableBeanFactory;
import cn.neko.springframework.beans.factory.config.BeanDefinition;
import cn.neko.springframework.beans.factory.config.BeanPostProcessor;
import cn.neko.springframework.beans.factory.config.ConfigurableBeanFactory;

import java.util.Map;

/**
 * @Author: Elaina
 * @Date: 2022/3/14 15:02
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    void preInstantiateSingletons() throws BeansException;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}
