package cn.neko.springframework.beans.factory.support;

import cn.neko.springframework.beans.BeansException;
import cn.neko.springframework.beans.factory.FactoryBean;
import cn.neko.springframework.beans.factory.config.BeanDefinition;
import cn.neko.springframework.beans.factory.config.BeanPostProcessor;
import cn.neko.springframework.beans.factory.config.ConfigurableBeanFactory;
import cn.neko.springframework.utils.ClassUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Elaina
 * @Date: 2022/3/14 15:04
 */
public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableBeanFactory {

    /** ClassLoader to resolve bean class names with, if necessary */
    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();

    /**
     * BeanPostProcessors to apply in createBean
     */
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    @Override
    public Object getBean(String beanName) throws BeansException {
        return doGetBean(beanName, null);
    }

    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        return doGetBean(beanName, args);
    }

    @Override
    public <T> T getBean(String beanName, Class<T> requiredType) throws BeansException {
        return (T) getBean(beanName);
    }


    protected <T> T doGetBean(final String name, final Object[] args) throws BeansException {
        Object sharedInstance = getSingleton(name);
        if (sharedInstance != null) {
            // 如果是 FactoryBean, 则需要调用 FactoryBean#getObject
            return (T) getObjectForBeanInstance(sharedInstance, name);
        }
        // 没有获取到bean则做相应的实例化操作, 由具体实现完成
        BeanDefinition beanDefinition = getBeanDefinition(name);
        Object bean = createBean(name, beanDefinition, args);
        return (T) getObjectForBeanInstance(bean, name);
    }

    private Object getObjectForBeanInstance(Object beanInstance, String beanName) {
        if (!(beanInstance instanceof FactoryBean)) {
            return  beanInstance;
        }

        // 从缓存中获取对象
        Object o = getCachedObjectForFactoryBean(beanName);
        // 若缓存中不存在, 调用 getObjectFromFactoryBean 执行具体操作
        if (o == null) {
            FactoryBean<?> factoryBean = (FactoryBean<?>) beanInstance;
            o = getObjectFromFactoryBean(factoryBean, beanName);
        }
        return o;
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    /**
     * Return the list of BeanPostProcessors that will get applied to beans created with this factory
     * @return
     */
    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }

    public ClassLoader getBeanClassLoader() {
        return this.beanClassLoader;
    }
}
