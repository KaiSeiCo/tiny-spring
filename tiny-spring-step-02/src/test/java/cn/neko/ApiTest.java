package cn.neko;

import cn.neko.beans.BeanDefinition;
import cn.neko.beans.factory.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * @Author: Elaina
 * @Date: 2022/3/13 17:03
 */
public class ApiTest {

    @Test
    public void testBeanFactory() throws Exception {
        // 1. 初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2. 注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registryBeanDefinition("userService", beanDefinition);

        // 3. 第一次获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.query();
        // 4. 第二次获取 bean
        UserService userService1 = (UserService) beanFactory. getBean("userService");
        userService1.query();
    }
}
