package com.dmdk.common.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class JacksonTest {

    /**
     * jackson 测试
     *  给出json字符串，按照父类接收，自动转为子类类型
     */
    @Test
    void jaskconTest() throws JsonProcessingException {
        String jsonStr = "[{\"typeInJson\":\"COCA\",\"color\":\"fake_data\",\"co2\":82.89},{\"typeInJson\":\"MINUTE_MAID\",\"sugar\":24.41},{\"typeInJson\":\"PEPSI\",\"color\":\"fake_data\",\"co2\":49.53},{\"typeInJson\":\"WATER\",\"temperature\":21.75},{\"typeInJson\":\"MINUTE_MAID\",\"sugar\":24.41}]";
        ObjectMapper mapper = new ObjectMapper();
        List<IDrink> iDrink = mapper.readValue(jsonStr, new TypeReference<List<IDrink>>() {
        });
        log.info("iDrink={}", iDrink);
    }

    @Test
    void jacksonSingleTest() throws JsonProcessingException {
        String jsonStr = "{\"typeInJson\":\"COCA\",\"color\":\"fake_data\",\"co2\":82.89}";
        ObjectMapper mapper = new ObjectMapper();
        final IDrink iDrink = mapper.readValue(jsonStr, IDrink.class);
        log.info(iDrink.toString());
    }

    @Test
    void jacksonJsonNodeConvert() throws JsonProcessingException {
        String jsonStr = "{\"drink\":[{\"typeInJson\":\"COCA\",\"color\":\"fake_data\",\"co2\":82.89},{\"typeInJson\":\"MINUTE_MAID\",\"sugar\":24.41},{\"typeInJson\":\"PEPSI\",\"color\":\"fake_data\",\"co2\":49.53},{\"typeInJson\":\"WATER\",\"temperature\":21.75},{\"typeInJson\":\"MINUTE_MAID\",\"sugar\":24.41}]}";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(jsonStr);
        Drink drink = mapper.convertValue(jsonNode, Drink.class);
        log.info(drink.toString());
    }

}
