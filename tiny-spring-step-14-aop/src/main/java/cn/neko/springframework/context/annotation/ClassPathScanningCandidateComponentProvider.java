package cn.neko.springframework.context.annotation;

import cn.hutool.core.util.ClassUtil;
import cn.neko.springframework.beans.factory.config.BeanDefinition;
import cn.neko.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 处理对象扫描装配
 *
 * @Author: Elaina
 * @Date: 2022/3/29 12:13
 */
public class ClassPathScanningCandidateComponentProvider {

    public Set<BeanDefinition> findCandidateComponents(String basePackage) {
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for (Class<?> clazz : classes) {
            candidates.add(new BeanDefinition(clazz));
        }
        return candidates;
    }
}
