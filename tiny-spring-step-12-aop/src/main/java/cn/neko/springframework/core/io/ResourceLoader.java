package cn.neko.springframework.core.io;

/**
 * 包装资源加载器
 *
 * @Author: Elaina
 * @Date: 2022/3/14 15:03
 */
public interface ResourceLoader {

    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
