package com.dmdk.common.config;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

import java.util.Date;
import java.util.List;

public class JacksonConfigUtil {

    public static SimpleModule createWebSimpleModule() {
        SimpleModule simpleModule = new SimpleModule();
        return simpleModule;
    }

    public static ObjectMapper createObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        return mapper;
    }

}
