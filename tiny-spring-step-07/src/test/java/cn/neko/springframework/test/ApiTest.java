package cn.neko.springframework.test;

import cn.neko.springframework.context.support.ClassPathXmlApplicationContext;
import cn.neko.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * @Author: Elaina
 * @Date: 2022/3/26 9:46
 */

/**
 * 新增 :
 * initializeBean 时 执行 invokeInitMethods 调用初始化方法
 * 1 . 检查 Bean 是否实现接口 InitializingBean 而判断是否调用 afterPropertiesSet
 * 2. 从 BeeanDefinition 中获取配置的初始化方法, 并且调用它
 *
 * 在 initializeBean 结束后, 调用 registerDisposableBeanIfNecessary 方法
 * 这个方法主要是为了 注册实现了 DisposableBean 接口的 Bean 对象
 *
 * registerShutdownHook 关闭的钩子方法, 当容器销毁时, 会执行此方法, 并且调用 close(),
 * 调用 close 会遍历被注册的销毁方法, 并且执行配置进去的 自定义 destroy, 之后执行自带的 destroy 进行销毁操作
 *
 */
public class ApiTest {

    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

    @Test
    public void test_hook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("close！")));
    }
}
