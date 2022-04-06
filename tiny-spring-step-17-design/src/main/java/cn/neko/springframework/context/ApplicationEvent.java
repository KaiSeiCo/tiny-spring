package cn.neko.springframework.context;

import java.util.EventObject;

/**
 * @Author: Elaina
 * @Date: 2022/3/27 22:15
 */
public abstract class ApplicationEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
