package cn.neko.springframework.beans.factory;

import cn.neko.springframework.beans.BeansException;

import java.util.Map;

/**
 * @Author: Elaina
 * @Date: 2022/3/14 15:02
 */
public interface ListableBeanFactory extends BeanFactory {

    /**
     * 按照类型返回Bean实例
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * 返回注册表中所有的Bean名称
     * @return
     */
    String[] getBeanDefinitionNames();

}
