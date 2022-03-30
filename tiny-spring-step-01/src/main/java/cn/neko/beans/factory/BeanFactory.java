package cn.neko.beans.factory;

import cn.neko.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * bean 工厂
 * @Author: Elaina
 * @Date: 2022/3/13 16:17
 */
public class BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }
}
