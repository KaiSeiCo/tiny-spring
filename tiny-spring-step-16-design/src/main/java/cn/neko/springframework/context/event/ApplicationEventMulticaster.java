package cn.neko.springframework.context.event;

import cn.neko.springframework.context.ApplicationEvent;
import cn.neko.springframework.context.ApplicationListener;

/**
 * 事件广播器
 *
 * 通过 multicastEvent 来进行推送, 通过此接口处理谁该接收该事件
 * @Author: Elaina
 * @Date: 2022/3/27 22:14
 */
public interface ApplicationEventMulticaster {

    /**
     * Add a listener to be notified of all events
     * @param listener the listener to add
     */
    void addApplicationListener(ApplicationListener<?> listener);

    /**
     * Remove a listener from the notification list
     * @param listener the listener to remove
     */
    void removeApplicationListener(ApplicationListener<?> listener);

    /**
     * Multicast the given application event to appropriate listeners
     * @param event the event to multicast
     */
    void multicastEvent(ApplicationEvent event);

}
