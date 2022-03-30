package cn.neko.springframework.beans.factory;

/**
 * 初始化接口
 * @Author: Elaina
 * @Date: 2022/3/26 8:38
 */
public interface InitializingBean {

    /**
     * Bean 处理了属性填充后调用
     * @throws Exception
     */
    void afterPropertiesSet() throws Exception;
}
