package cn.neko.springframework.context.support;

import cn.neko.springframework.beans.factory.FactoryBean;
import cn.neko.springframework.beans.factory.InitializingBean;
import cn.neko.springframework.core.convert.ConversionService;
import cn.neko.springframework.core.convert.converter.Converter;
import cn.neko.springframework.core.convert.converter.ConverterFactory;
import cn.neko.springframework.core.convert.converter.ConverterRegistry;
import cn.neko.springframework.core.convert.converter.GenericConverter;
import cn.neko.springframework.core.convert.support.DefaultConversionService;
import cn.neko.springframework.core.convert.support.GenericConversionService;
import com.sun.istack.internal.Nullable;

import java.util.Set;

/**
 * 提供创建 ConversionService 工厂
 * @Author: Elaina
 * @Date: 2022/4/6 17:25
 */
public class ConversionServiceFactoryBean implements FactoryBean<ConversionService>, InitializingBean {

    @Nullable
    private Set<?> converters;

    @Nullable
    private GenericConversionService conversionService;

    @Override
    public ConversionService getObject() throws Exception {
        return conversionService;
    }

    @Override
    public Class<?> getObjectType() {
        return conversionService.getClass();
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.conversionService = new DefaultConversionService();
        registerConverters(converters, conversionService);
    }

    private void registerConverters(Set<?> converters, ConverterRegistry registry) {
        if (converters != null) {
            for (Object converter : converters) {
                if (converter instanceof GenericConverter) {
                    registry.addConverter((GenericConverter) converter);
                } else if (converter instanceof Converter<?, ?>) {
                    registry.addConverter((Converter<?, ?>) converter);
                } else if (converter instanceof ConverterFactory<?, ?>) {
                    registry.addConverterFactory((ConverterFactory<?, ?>) converter);
                } else {
                    throw new IllegalArgumentException("Each converter object must implement one of the " +
                            "Converter, ConverterFactory, or GenericConverter interfaces");
                }
            }
        }
    }

    public void setConverters(Set<?> converters) {
        this.converters = converters;
    }
}
