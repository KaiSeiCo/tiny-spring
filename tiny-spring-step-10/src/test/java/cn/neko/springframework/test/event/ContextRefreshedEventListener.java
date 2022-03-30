package cn.neko.springframework.test.event;

import cn.neko.springframework.context.ApplicationListener;
import cn.neko.springframework.context.event.ContextRefreshedEvent;

/**
 * @Author: Elaina
 * @Date: 2022/3/27 22:18
 */
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("刷新事件：" + this.getClass().getName());
    }

}

