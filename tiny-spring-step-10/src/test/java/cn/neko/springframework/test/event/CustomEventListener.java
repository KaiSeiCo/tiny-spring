package cn.neko.springframework.test.event;

import cn.neko.springframework.context.ApplicationListener;

import java.util.Date;

/**
 * @Author: Elaina
 * @Date: 2022/3/27 22:19
 */
public class CustomEventListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("收到: " + event.getSource() + "消息, 时间: " + new Date());
        System.out.println("消息: " + event.getId() + ":" + event.getMessage());
    }
}
