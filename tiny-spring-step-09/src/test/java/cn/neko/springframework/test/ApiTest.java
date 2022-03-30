package cn.neko.springframework.test;

import cn.neko.springframework.context.supoort.ClassPathXmlApplicationContext;
import cn.neko.springframework.test.bean.UserService;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

/**
 * @Author: Elaina
 * @Date: 2022/3/26 9:46
 */

/**
 * 对象作用域 和 FactoryBean
 * FactoryBean 主要适用组件开发, 将组件中对象实现 FactoryBean 并注入到容器中, 与 Bean 类似地进行创建和初始化并缓存, 并对其进行管理
 *
 * 1. 范围作用域 通过XML解析 <scope> 获得范围作用域
 * 2. 把作用域设置在 BeanDefinition 中
 * 3. 在创建 Bean 时, 最后判断 BeanDefinition 为单例还是原型, 若为单例则会缓存到 DefaultSingletonBeanRegistry 的 singletonObjects 中
 * 4. 在 createBean 基本完成后, 会判断整个对象是否为一个 FactoryBean 扩展对象
 *    - 若为扩展对象 :
 *          若 factoryBeanObjectCache 存在此扩展对象缓存, 则返回, 否则则创建并缓存(单例)
 *          若为原型, 则每次会调用此扩展对象的 getObject 返回, 不会被缓存
 *    - 若不为扩展对象, 则直接返回这个 Bean
 *
 * 5. 在之后调用中, 会先在 singletonObjects 缓存获取缓存对象,
 *    若获取到的对象是扩展对象, 且没有被缓存则会调用 FactoryBean#getObject
 *                          若被缓存, 则从 FactoryBeanRegistrySupport-factoryBeanObjectCache 中获取
 *    若不为扩展对象, 则会被直接返回, 若不为 singleton 则创建后返回
 *
 */

public class ApiTest {

    @Test
    public void test_prototype() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        UserService userService01 = applicationContext.getBean("userService", UserService.class);
        UserService userService02 = applicationContext.getBean("userService", UserService.class);

        // 3. 配置 scope="prototype/singleton"
        System.out.println(userService01);
        System.out.println(userService02);

        // 4. 打印十六进制哈希
//        System.out.println(userService01 + " 十六进制哈希：" + Integer.toHexString(userService01.hashCode()));
//        System.out.println(ClassLayout.parseInstance(userService01).toPrintable());
    }

    @Test
    public void test_factory_bean() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();
        // 2. 调用代理方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }
}
