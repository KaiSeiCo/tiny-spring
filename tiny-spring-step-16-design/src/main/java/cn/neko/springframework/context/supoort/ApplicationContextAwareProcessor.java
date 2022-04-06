package cn.neko.springframework.context.supoort;

import cn.neko.springframework.beans.BeansException;
import cn.neko.springframework.beans.factory.config.BeanPostProcessor;
import cn.neko.springframework.context.ApplicationContext;
import cn.neko.springframework.context.ApplicationContextAware;

/**
 * @Author: Elaina
 * @Date: 2022/3/26 12:57
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
