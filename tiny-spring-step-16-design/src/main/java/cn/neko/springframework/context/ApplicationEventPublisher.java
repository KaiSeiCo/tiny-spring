package cn.neko.springframework.context;

/**
 * 事件发布者接口
 *
 * @Author: Elaina
 * @Date: 2022/3/27 22:16
 */
public interface ApplicationEventPublisher {

    /**
     * notify all listeners registered with this application of an application event.
     * Events may be framework events (such as RequestHandlerEvent) or application-specific events.
     * @param event the event to publish.
     */
    void publishEvent(ApplicationEvent event);
}
