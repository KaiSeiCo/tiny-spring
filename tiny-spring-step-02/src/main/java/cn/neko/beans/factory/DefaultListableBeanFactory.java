package cn.neko.beans.factory;

import cn.neko.beans.BeanDefinition;
import cn.neko.beans.exception.BeansException;
import cn.neko.beans.registry.BeanDefinitionRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Elaina
 * @Date: 2022/3/13 16:33
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    public void registryBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new BeansException("No bean named '" + beanName + "' is defined");
        }
        return beanDefinition;
    }
}
