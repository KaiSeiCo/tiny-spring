package cn.neko.beans.registry;

import cn.neko.beans.BeanDefinition;

/**
 * @Author: Elaina
 * @Date: 2022/3/13 16:34
 */
public interface BeanDefinitionRegistry {


    public void registryBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
