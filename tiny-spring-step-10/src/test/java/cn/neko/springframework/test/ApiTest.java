package cn.neko.springframework.test;

import cn.neko.springframework.context.support.ClassPathXmlApplicationContext;
import cn.neko.springframework.test.event.CustomEvent;
import org.junit.Test;

/**
 * @Author: Elaina
 * @Date: 2022/3/26 9:46
 */

/**
 * Target : 实现 Event 事件功能, 它可以提供事件的定义, 发布 以及 监听事件来完成一些自定义的动作
 * 将[某个动作完成后]通过事件[通知]其他服务, 避免将这些代码耦合在一起, 还能以此来增加后续服务
 * 类似于 [观察者模式] : 定义对象间的一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新。
 *
 * 6. 初始化事件发布者 applicationEventMulticaster, 这个类持有 applicationListeners 来存放所有观察者
 * 7. 在配置了事件的 Bean 之后会先注册到容器中, 之后会从容器取出实现了 ApplicationListener 的 Bean, 随后加入到 applicationListeners
 * 8. 之后执行 提前实例化 单例 Bean 对象 preInstantiateSingletons()
 * 9. 此时容器刷新完成, 通过 finishRefresh() 发布容器刷新事件
 * * 事件通过 multicastEvent 最终执行事件Bean的 onApplicationEvent 进行执行发布
 */

public class ApiTest {

    @Test
    public void test_event() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 1019129009086763L, "成功了！"));

        applicationContext.registerShutdownHook();
    }

}
