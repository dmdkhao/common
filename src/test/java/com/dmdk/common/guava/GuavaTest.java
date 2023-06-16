package com.dmdk.common.guava;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.MultimapBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class GuavaTest {

    @Test
    void guavaTest(){
        ListMultimap<Integer, String> multimap = MultimapBuilder.treeKeys().arrayListValues().build();
        multimap.put(1,"s");
        multimap.put(1,"a");
        multimap.put(1,"s");
        multimap.put(1,"d");
        multimap.put(1,"r");
        log.info("{}", JSONObject.toJSONString(multimap));
        List<String> strings = multimap.get(1);
        log.info(strings.toString());
    }
}
