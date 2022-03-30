package cn.neko.beans.factory;

import cn.neko.beans.BeanDefinition;
import cn.neko.beans.exception.BeansException;
import cn.neko.beans.strategy.CglibSubclassingInstantiationStrategy;
import cn.neko.beans.strategy.InstantiationContext;

import java.lang.reflect.Constructor;

/**
 * @Author: Elaina
 * @Date: 2022/3/13 16:32
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationContext instantiationContext = null;

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object... args) throws BeansException {
        Object bean = null;
        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        addSingleton(beanName, bean);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object... args) throws BeansException {
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor<?> ctor : declaredConstructors) {
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        instantiationContext = new InstantiationContext(new CglibSubclassingInstantiationStrategy());
        return instantiationContext.executeInstantiationStrategy(beanDefinition, beanName, constructorToUse, args);
    }
}
