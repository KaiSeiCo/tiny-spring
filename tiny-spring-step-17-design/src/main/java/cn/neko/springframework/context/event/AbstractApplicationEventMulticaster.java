package cn.neko.springframework.context.event;

import cn.neko.springframework.beans.BeanFactoryAware;
import cn.neko.springframework.beans.BeansException;
import cn.neko.springframework.beans.factory.BeanFactory;
import cn.neko.springframework.context.ApplicationEvent;
import cn.neko.springframework.context.ApplicationListener;
import cn.neko.springframework.utils.ClassUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @Author: Elaina
 * @Date: 2022/3/27 22:14
 */
public abstract class AbstractApplicationEventMulticaster implements ApplicationEventMulticaster, BeanFactoryAware {

    public final Set<ApplicationListener<ApplicationEvent>> applicationListeners = new LinkedHashSet<>();

    private BeanFactory beanFactory;

    @Override
    public void addApplicationListener(ApplicationListener<?> listener) {
        applicationListeners.add((ApplicationListener<ApplicationEvent>) listener);
    }

    @Override
    public void removeApplicationListener(ApplicationListener<?> listener) {
        applicationListeners.remove(listener);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    protected Collection<ApplicationListener> getApplicationListeners(ApplicationEvent event) {
        LinkedList<ApplicationListener> allListeners = new LinkedList<ApplicationListener>();
        for (ApplicationListener<ApplicationEvent> listener : applicationListeners) {
            if (supportsEvent(listener, event)) {
                allListeners.add(listener);
            }
        }
        return allListeners;
    }

    /**
     * 判断监听器是否对事件感兴趣
     * @param applicationListener
     * @param event
     * @return
     */
    private boolean supportsEvent(ApplicationListener<ApplicationEvent> applicationListener, ApplicationEvent event) {

        Class<? extends ApplicationListener> listenerClass = applicationListener.getClass();

        // 按照 CglibSubclassingInstantiationStrategy/SimpleInstantiationStrategy 不同实例化类型, 需要判断后获取目标 Class
        Class<?> targetClass = ClassUtils.isCglibProxyClass(listenerClass) ? listenerClass.getSuperclass() : listenerClass;
        Type genericInterface = targetClass.getGenericInterfaces()[0];

        Type actualTypeArgument = ((ParameterizedType) genericInterface).getActualTypeArguments()[0];
        String className = actualTypeArgument.getTypeName();
        Class<?> eventClassName;

        try {
            eventClassName = Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new BeansException("wrong event class named: " + className);
        }
        /**
         * 判断此 eventClassName 对象所表示的类或接口与指定的 event.getClass() 参数所表示的类或接口是否相同, 或是否是其超类或超接口
         * isAssignableFrom 是用来判断子类和父类的关系的, 或者接口实现类和接口的关系, 默认所有类顶层父类为 Object
         * 若为true, 则说明A可以转换为B, B也可以由A转换
         */
        return eventClassName.isAssignableFrom(event.getClass());
    }


}
