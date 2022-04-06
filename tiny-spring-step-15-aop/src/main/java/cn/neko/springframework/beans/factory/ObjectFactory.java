package cn.neko.springframework.beans.factory;

import cn.neko.springframework.beans.BeansException;

/**
 *
 * Defines a factory which can return an Object instance
 * (possibly shared or independent) when invoked.
 *
 * @Author: Elaina
 * @Date: 2022/4/5 18:45
 */
public interface ObjectFactory<T> {

    T getObject() throws BeansException;
}

