package cn.neko.beans.strategy;

import cn.neko.beans.BeanDefinition;
import cn.neko.beans.exception.BeansException;

import java.lang.reflect.Constructor;

/**
 * 实例化策略接口
 * @Author: Elaina
 * @Date: 2022/3/13 19:25
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object... args) throws BeansException;
}
