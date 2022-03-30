package cn.neko.springframework.context.event;

import cn.neko.springframework.context.ApplicationEvent;

/**
 * 监听关闭事件
 * @Author: Elaina
 * @Date: 2022/3/27 22:15
 */
public class ContextClosedEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextClosedEvent(Object source) {
        super(source);
    }
}
