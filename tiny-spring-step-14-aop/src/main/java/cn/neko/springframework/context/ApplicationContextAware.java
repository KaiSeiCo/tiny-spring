package cn.neko.springframework.context;

import cn.neko.springframework.beans.factory.Aware;

/**
 * @Author: Elaina
 * @Date: 2022/3/26 12:49
 */
public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext);
}
