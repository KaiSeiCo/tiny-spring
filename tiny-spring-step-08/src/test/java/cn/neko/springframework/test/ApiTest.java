package cn.neko.springframework.test;

import cn.neko.springframework.context.support.ClassPathXmlApplicationContext;
import cn.neko.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * @Author: Elaina
 * @Date: 2022/3/26 9:46
 */

/**
 * Aware接口是为了 让bean获取spring容器的服务
 * 新增 :
 * 定义 Aware 接口, 感知标记性接口, 具体的子类定义和实现能够感知容器中的相关对象
 * BeanFactoryAware 感知 Bean 所属的 BeanFactory
 * BeanClassLoaderAware 感知 Bean 所属的 BeanClassLoader
 * BeanNameAware 感知 Bean 所属的 BeanName
 * ApplicationContextAware 感知 Bean 所属的 ApplicationContext
 *
 * ApplicationContext 无法在创建的时候拿到, 需要 refresh() 操作,
 * 通过 postProcessBeforeInitialization 来调用
 * ApplicationContextAwareProcessor 方法重写 postProcessBeforeInitialization 将 ApplicationContext set进去
 *
 * 在 refresh 执行 BeanFactoryPostProcessors之前,
 * 添加 ApplicationContextAwareProcessor
 * 让继承自 ApplicationContextAware 的 Bean 对象都能感知所属的 ApplicationContext
 *
 * 在 initializeBean 时通过 Aware 进行感知调用操作 --> BeanFactoryAware BeanClassLoaderAware BeanNameAware
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
        System.out.println("ApplicationContextAware: " + userService.getApplicationContext());
        System.out.println("BeanFactoryAware: " + userService.getBeanFactory());
    }

    @Test
    public void test_hook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("close！")));
    }
}
