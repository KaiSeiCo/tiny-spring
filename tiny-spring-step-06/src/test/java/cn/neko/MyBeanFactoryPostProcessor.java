package cn.neko;


import cn.neko.springframework.beans.BeansException;
import cn.neko.springframework.beans.PropertyValue;
import cn.neko.springframework.beans.PropertyValues;
import cn.neko.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.neko.springframework.beans.factory.config.BeanDefinition;
import cn.neko.springframework.beans.factory.config.BeanFactoryPostProcessor;
import cn.neko.springframework.beans.factory.config.ConfigurableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "字节跳动"));
    }

}
