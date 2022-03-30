package cn.neko.springframework.beans.factory;

/**
 * 销毁方法接口
 * @Author: Elaina
 * @Date: 2022/3/26 8:38
 */
public interface DisposableBean {

    /**
     * 销毁方法
     * @throws Exception
     */
    void destroy() throws Exception;
}
