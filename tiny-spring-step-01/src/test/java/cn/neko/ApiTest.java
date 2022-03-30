package cn.neko;

import cn.neko.beans.factory.BeanFactory;
import org.junit.Test;

/**
 * @Author: Elaina
 * @Date: 2022/3/13 16:19
 */
public class ApiTest {

    @Test
    public void testBeanFactory() {
        // 1. 初始化 Bean 工厂
        BeanFactory beanFactory = new BeanFactory();

        // 2. 注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3. 获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.query();

    }
}
