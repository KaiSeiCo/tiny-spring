package cn.neko.springframework.test;


import cn.neko.springframework.context.support.ClassPathXmlApplicationContext;
import cn.neko.springframework.test.bean.IUserService;
import org.junit.Test;

/**
 *
 */
public class ApiTest {

    @Test
    public void test_scan() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }

}
