package cn.neko.springframework.beans.factory;

/**
 * @Author: Elaina
 * @Date: 2022/3/27 14:56
 */
public interface FactoryBean<T> {

    /**
     * 获取对象
     *
     * @return
     * @throws Exception
     */
    T getObject() throws Exception;

    /**
     * 获取对象类型
     *
     * @return
     */
    Class<?> getObjectType();

    /**
     * 是否是单例对象
     * @return
     */
    boolean isSingleton();
}
