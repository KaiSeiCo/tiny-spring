package cn.neko.springframework.context;

import cn.neko.springframework.beans.factory.ListableBeanFactory;

/**
 *
 * 上下文接口
 * @Author: Elaina
 * @Date: 2022/3/17 10:27
 */
public interface ApplicationContext extends ListableBeanFactory, ApplicationEventPublisher {
}
