package cn.neko.springframework.utils;

/**
 *
 * 字符串解析接口
 * @Author: Elaina
 * @Date: 2022/3/29 19:00
 */
public interface StringValueResolver {

    /**
     * 解析字符串
     * @param strVal
     * @return
     */
    String resolveStringValue(String strVal);
}
