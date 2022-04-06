package cn.neko.springframework.test;


import cn.neko.springframework.context.support.ClassPathXmlApplicationContext;
import cn.neko.springframework.core.convert.converter.Converter;
import cn.neko.springframework.core.convert.support.StringToNumberConverterFactory;
import cn.neko.springframework.test.bean.Husband;
import cn.neko.springframework.test.converter.StringToIntegerConverter;
import org.junit.Test;

/**
 *
 */
public class ApiTest {

    @Test
    public void test_convert() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        Husband husband = applicationContext.getBean("husband", Husband.class);
        System.out.println("测试结果：" + husband);
    }

    @Test
    public void test_StringToIntegerConverter() {
        StringToIntegerConverter converter = new StringToIntegerConverter();
        Integer num = converter.convert("1234");
        System.out.println("测试结果：" + num.equals(new Integer(1234)));
    }

    @Test
    public void test_StringToNumberConverterFactory() {
        StringToNumberConverterFactory converterFactory = new StringToNumberConverterFactory();

        Converter<String, Integer> stringToIntegerConverter = converterFactory.getConverter(Integer.class);
        System.out.println("测试结果：" + stringToIntegerConverter.convert("1234").equals(new Integer(1234)));

        Converter<String, Long> stringToLongConverter = converterFactory.getConverter(Long.class);
        System.out.println("测试结果：" + stringToLongConverter.convert("1234").equals(new Long(1234)));
    }


}
