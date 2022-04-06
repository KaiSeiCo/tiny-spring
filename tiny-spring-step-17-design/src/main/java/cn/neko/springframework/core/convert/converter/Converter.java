package cn.neko.springframework.core.convert.converter;

/**
 * 类型转换处理接口
 * @Author: Elaina
 * @Date: 2022/4/6 17:08
 */
public interface Converter<S, T> {

    /** Convert the source object of type {@code S} to target type {@code T}. */
    T convert(S source);
}
