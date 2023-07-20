package com.dmdk.common.snowflake;

import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@SpringBootTest
public class Demo {


    @Test
    void testGenId() {
        for (int i = 0; i < 10; i++) {
            Long id = MyIdGenerator.genId();
            log.info(id.toString());
        }

    }

    @Test
    void testGenId7() {
        long l = 1681226070014255104L % 1_000_000_000_000_000L;
        System.out.println(l);

    }

    @Test
    void testGenId2() {
        for (int i = 0; i < 10; i++) {
            Long id = IdUtil.getSnowflakeNextId();
            long l = id % 1_000_000_000_000_000L;
            log.info(l + "");
        }

    }

    @Test
    void distinct() {
        List<Long> idList = new ArrayList<>(1 << 10);
        for (int i = 0; i < 1 << 10; i++) {
            Long id = MyIdGenerator.genId();
            idList.add(id);
        }
        log.info("list size ={}", idList.size());
        List<Long> collect = idList.stream().distinct().collect(Collectors.toList());
        log.info("distinct list size = {}", collect.size());
    }


}
