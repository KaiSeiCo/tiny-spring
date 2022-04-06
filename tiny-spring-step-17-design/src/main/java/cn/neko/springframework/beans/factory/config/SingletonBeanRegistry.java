package cn.neko.springframework.beans.factory.config;


/**
 * @Author: Elaina
 * @Date: 2022/3/14 15:01
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

    void registerSingleton(String beanName, Object singletonObject);
}

