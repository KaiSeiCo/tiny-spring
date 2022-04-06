package cn.neko.springframework.test.converter;


import cn.neko.springframework.core.convert.converter.Converter;

/**
 *
 */
public class StringToIntegerConverter implements Converter<String, Integer> {

    @Override
    public Integer convert(String source) {
        return Integer.valueOf(source);
    }

}
