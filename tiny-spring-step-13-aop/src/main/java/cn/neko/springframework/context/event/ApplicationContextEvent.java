package cn.neko.springframework.context.event;

import cn.neko.springframework.context.ApplicationContext;
import cn.neko.springframework.context.ApplicationEvent;

/**
 * @Author: Elaina
 * @Date: 2022/3/27 22:14
 */
public class ApplicationContextEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    /**
     * Get the <code>ApplicationContext</code> that the event was raised for
     * @return
     */
    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }
}
