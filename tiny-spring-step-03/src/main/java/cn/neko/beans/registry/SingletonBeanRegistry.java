package cn.neko.beans.registry;

/**
 * 单例注册接口
 * @Author: Elaina
 * @Date: 2022/3/13 16:34
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);
}
