package cn.neko.beans.factory;

import cn.neko.beans.exception.BeansException;

/**
 * @Author: Elaina
 * @Date: 2022/3/13 16:33
 */
public interface BeanFactory {

    public Object getBean(String beanName) throws BeansException;

    public Object getBean(String beanName, Object... args)  throws BeansException;
}
