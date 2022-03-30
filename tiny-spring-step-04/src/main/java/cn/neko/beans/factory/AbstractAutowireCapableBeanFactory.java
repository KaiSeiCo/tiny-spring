package cn.neko.beans.factory;

import cn.hutool.core.bean.BeanUtil;
import cn.neko.beans.BeanDefinition;
import cn.neko.beans.BeanReference;
import cn.neko.beans.PropertyValue;
import cn.neko.beans.PropertyValues;
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
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
            // 给Bean填充属性
            applyPropertyValues(beanName, beanDefinition, bean);
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

    /**
     * Bean属性填充
     * @param beanName
     * @param beanDefinition
     * @param bean
     */
    protected void applyPropertyValues(String beanName, BeanDefinition beanDefinition, Object bean) throws BeansException {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {

                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                if (value instanceof BeanReference) {
                    // A 依赖 B，获取 B 的实例化
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getName());
                }
                // 属性填充
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (BeansException e) {
            throw new BeansException("Error setting property values：" + beanName);
        }
    }
}
