package cn.neko.springframework.test.event;

import cn.neko.springframework.context.ApplicationListener;
import cn.neko.springframework.context.event.ContextClosedEvent;

/**
 * @Author: Elaina
 * @Date: 2022/3/27 22:18
 */
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("关闭事件：" + this.getClass().getName());
    }

}
