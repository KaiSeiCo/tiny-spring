package cn.neko.springframework.context;

import cn.neko.springframework.beans.BeansException;

/**
 * @Author: Elaina
 * @Date: 2022/3/17 10:27
 */
public interface ConfigurableApplicationContext extends ApplicationContext {


    /**
     * 刷新容器
     * @throws BeansException
     */
    void refresh() throws BeansException;

    /**
     * 关闭钩子注册调用销毁方法
     */
    void registerShutdownHook();

    /**
     * 手动关闭方法
     */
    void close();
}
