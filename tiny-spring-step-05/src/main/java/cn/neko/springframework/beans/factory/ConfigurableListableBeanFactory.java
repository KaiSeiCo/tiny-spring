package cn.neko.springframework.beans.factory;

import cn.neko.springframework.beans.BeansException;
import cn.neko.springframework.beans.factory.config.AutowireCapableBeanFactory;
import cn.neko.springframework.beans.factory.config.ConfigurableBeanFactory;

import java.util.Map;

/**
 * @Author: Elaina
 * @Date: 2022/3/14 15:02
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;
}
