package cn.neko.springframework.beans;

import cn.neko.springframework.beans.factory.Aware;

/**
 * @Author: Elaina
 * @Date: 2022/3/26 12:50
 */
public interface BeanNameAware extends Aware {

    void setBeanName(String beanName);
}
