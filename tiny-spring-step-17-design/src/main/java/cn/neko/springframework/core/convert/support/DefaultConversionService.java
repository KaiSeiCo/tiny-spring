package cn.neko.springframework.core.convert.support;

import cn.neko.springframework.core.convert.converter.ConverterRegistry;

/**
 * @Author: Elaina
 * @Date: 2022/4/6 17:09
 */
public class DefaultConversionService extends GenericConversionService {

    public DefaultConversionService() {
        addDefaultConverters(this);
    }

    public static void addDefaultConverters(ConverterRegistry converterRegistry) {
        // 添加各类类型转换工厂
        converterRegistry.addConverterFactory(new StringToNumberConverterFactory());
    }
}
