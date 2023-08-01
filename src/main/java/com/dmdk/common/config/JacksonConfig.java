package com.dmdk.common.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class JacksonConfig implements Jackson2ObjectMapperBuilderCustomizer, Ordered {
    @Override
    public void customize(Jackson2ObjectMapperBuilder builder) {
        SimpleModule simpleModule = JacksonConfigUtil.createWebSimpleModule();

        // jdk8日期序列化和反序列化设置
        JavaTimeModule javaTimeModule = JSR310DateFormatterUtil.createJacksonTimeModule();


        builder.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE,
                DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, SerializationFeature.FAIL_ON_EMPTY_BEANS, SerializationFeature.INDENT_OUTPUT);
        builder.featuresToEnable(SerializationFeature.WRITE_ENUMS_USING_INDEX, JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES,
                JsonParser.Feature.ALLOW_SINGLE_QUOTES, DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);

        builder.createXmlMapper(false).modules(javaTimeModule, simpleModule, new ParameterNamesModule(), new Jdk8Module()).build();

    }

    @Override
    public int getOrder() {
        return 99;
    }
}
