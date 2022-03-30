package cn.neko.springframework.beans.factory.config;

/**
 * @Author: Elaina
 * @Date: 2022/3/14 15:00
 */
public class BeanReference {
    private String name;

    public BeanReference(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
