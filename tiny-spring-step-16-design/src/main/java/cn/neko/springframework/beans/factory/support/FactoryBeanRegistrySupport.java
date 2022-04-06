package cn.neko.springframework.beans.factory.support;

import cn.neko.springframework.beans.BeansException;
import cn.neko.springframework.beans.factory.FactoryBean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: Elaina
 * @Date: 2022/3/27 15:16
 */
public abstract class FactoryBeanRegistrySupport extends DefaultSingletonBeanRegistry {

    /**
     * 单例对象的缓存
     */
    private final Map<String, Object> factoryBeanObjectCache = new ConcurrentHashMap<>();

    protected Object getCachedObjectForFactoryBean(String beanName) {
        Object o = this.factoryBeanObjectCache.get(beanName);
        return (o != NULL_OBJECT ? o : null);
    }

    protected Object getObjectFromFactoryBean(FactoryBean factoryBean, String beanName) {
        if (factoryBean.isSingleton()) {
            Object o = this.factoryBeanObjectCache.get(beanName);
            if (o == null) {
                o = doGetObjectFromFactoryBean(factoryBean, beanName);
                this.factoryBeanObjectCache.put(beanName, (o != null ? o : NULL_OBJECT));
            }
            return (o != NULL_OBJECT ? o : null);
        } else {
            return doGetObjectFromFactoryBean(factoryBean, beanName);
        }
    }

    private Object doGetObjectFromFactoryBean(final FactoryBean factoryBean, final String beanName) {
        try {
            return factoryBean.getObject();
        } catch (Exception e) {
            throw new BeansException("FactoryBean threw exception on object[" + beanName + "] creation", e);
        }
    }
}
