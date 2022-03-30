package cn.neko.springframework.context.event;

import cn.neko.springframework.beans.factory.BeanFactory;
import cn.neko.springframework.context.ApplicationEvent;
import cn.neko.springframework.context.ApplicationListener;

/**
 * @Author: Elaina
 * @Date: 2022/3/27 22:15
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @Override
    public void multicastEvent(final ApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}
