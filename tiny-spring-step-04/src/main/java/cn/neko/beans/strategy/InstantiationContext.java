package cn.neko.beans.strategy;

import cn.neko.beans.BeanDefinition;
import cn.neko.beans.exception.BeansException;

import java.lang.reflect.Constructor;

/**
 * @Author: Elaina
 * @Date: 2022/3/13 19:45
 */
public class InstantiationContext {

    private InstantiationStrategy instantiationStrategy;

    public InstantiationContext(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }

    public Object executeInstantiationStrategy(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object... args) throws BeansException {
        return instantiationStrategy.instantiate(beanDefinition, beanName, ctor, args);
    }
}
