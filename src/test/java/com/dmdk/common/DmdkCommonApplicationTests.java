package com.dmdk.common;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dmdk.common.dto.ParameterBool;
import com.dmdk.common.dto.ParameterEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@Slf4j
@SpringBootTest
class DmdkCommonApplicationTests {

    @Test
    void contextLoads() {
        log.info("ss");
    }

    @Test
    void test2() {
        for (int i = 0; i < 10; i++) {
            log.info("dasdsa");
        }
    }

    private static void paramBoolTest() {
        String jsonString = "{\"type\":\"bool\",\"mapping\":{\"0\":\"关\",\"1\":\"开\"}}";
        final ParameterBool parameterBool = JSONObject.parseObject(jsonString, ParameterBool.class);
        //masterdosomething
        System.out.println(parameterBool);
    }

    private static void paramEnumTest() {
        String jsonString = "{\"type\":\"enum\",\"mapping\":{\"0\":\"Red\",\"1\":\"Green\",\"2\":\"Blue\"}}";
        ParameterEnum parameterEnum = JSONObject.parseObject(jsonString, ParameterEnum.class);
        System.out.println(parameterEnum);
    }

    private static void jsonTest() {
        String jsonString = "{\"type\":\"STRUCT\",\"specs\":[{\"id\":\"stringid\",\"name\":\"stringid\",\"dataType\":{\"type\":\"STRING\",\"max\":8892}},{\"id\":\"boolid\",\"name\":\"boolid\",\"dataType\":{\"type\":\"BOOL\",\"mapping\":{\"0\":\"jk\",\"1\":\"ol\"}}}]}";
        final JSONObject jsonObject = JSONObject.parseObject(jsonString);
        final JSONArray specs = jsonObject.getJSONArray("specs");
        for (Object o : specs) {
            JSONObject o1 = (JSONObject) o;
            log.info(o1.toString());

        }
        log.info(jsonObject.toString());
    }
}
