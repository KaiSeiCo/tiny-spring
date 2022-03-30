package cn.neko.springframework.beans.factory;

import cn.neko.springframework.beans.BeansException;

/**
 * @Author: Elaina
 * @Date: 2022/3/14 15:01
 */
public interface BeanFactory {

    Object getBean(String beanName) throws BeansException;

    Object getBean(String beanName, Object... args)  throws BeansException;

    <T> T getBean(String beanName, Class<T> requiredType) throws BeansException;
}
