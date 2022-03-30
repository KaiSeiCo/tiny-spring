package cn.neko.springframework.beans;

/**
 * @Author: Elaina
 * @Date: 2022/3/14 15:02
 */
public class PropertyValue {
    private final String name;
    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
