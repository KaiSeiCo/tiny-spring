package cn.neko.springframework.context.supoort;

import cn.neko.springframework.beans.BeansException;
import cn.neko.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.neko.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @Author: Elaina
 * @Date: 2022/3/17 10:26
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws BeansException {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations) {
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}
