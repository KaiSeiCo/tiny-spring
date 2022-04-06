package cn.neko.springframework.test;

import cn.neko.springframework.context.support.ClassPathXmlApplicationContext;
import cn.neko.springframework.test.bean.A;
import cn.neko.springframework.test.bean.B;
import cn.neko.springframework.test.bean.Husband;
import cn.neko.springframework.test.bean.Wife;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: Elaina
 * @Date: 2022/4/5 13:28
 */

public class ApiTest {

    private final static Map<String, Object> singletonObjects = new ConcurrentHashMap<>();

    /**
     * 循环依赖测试 : 抛出 StackOverflowError
     */
    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
        A a = context.getBean("a", A.class);
        B b = context.getBean("b", B.class);
        System.out.println(a.getB());
        System.out.println(b.getA());
    }

    /**
     * 利用一级缓存解决测试
     * @throws Exception
     */
    @Test
    public void test_level1cache() throws Exception {
        System.out.println(getBean(B.class).getA());
        System.out.println(getBean(A.class).getB());
    }

    /**
     * 一级缓存解决循环依赖 : 创建时, 先将创建的对象缓存到Map中, 再进行填充
     * @param beanClass
     * @param <T>
     * @return
     * @throws Exception
     */
    private static <T> T getBean(Class<T> beanClass) throws Exception {
        String beanName = beanClass.getName().toLowerCase();
        if (singletonObjects.containsKey(beanName)) {
            return (T) singletonObjects.get(beanName);
        }
        // 实例化对象入缓存
        Object object = beanClass.newInstance();
        singletonObjects.put(beanName, object);
        // 属性填充
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Class<?> clazz = field.getType();
            String fieldBeanName = clazz.getSimpleName().toLowerCase();
            field.set(object, singletonObjects.containsKey(fieldBeanName) ? singletonObjects.get(fieldBeanName) : getBean(clazz));
            field.setAccessible(false);
        }
        return (T) object;
    }

    @Test
    public void test_circle() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        Husband husband = applicationContext.getBean("husband", Husband.class);
        Wife wife = applicationContext.getBean("wife", Wife.class);
        System.out.println("老公的媳妇：" + husband.queryWife());
        System.out.println("媳妇的老公：" + wife.queryHusband());
    }
}
