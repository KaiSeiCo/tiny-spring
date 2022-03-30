package cn.neko;

import cn.neko.beans.BeanDefinition;
import cn.neko.beans.BeanReference;
import cn.neko.beans.PropertyValue;
import cn.neko.beans.PropertyValues;
import cn.neko.beans.exception.BeansException;
import cn.neko.beans.factory.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * @Author: Elaina
 * @Date: 2022/3/13 21:00
 */
public class ApiTest {

    @Test
    public void test() throws BeansException {
        // 1. 初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 注册 UserDao
        beanFactory.registryBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        // 3. UserService 设置属性 [uId, userDao]
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        // 4. UserService 注入 Bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registryBeanDefinition("userService", beanDefinition);

        // 5. 获取 Bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

    }
}
