package com.dmdk.common.snowflake;

import cn.hutool.core.lang.Singleton;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * id生成器包装类
 */
@Slf4j
public class MyIdGenerator {

    public static Long genId() {
        SecondSnowflake mySnowflake = getSnowFlake();
        long id = mySnowflake.generateId();
        return id;
    }

    private static SecondSnowflake getSnowFlake() {
        SecondSnowflake mySnowflake = Singleton.get(SecondSnowflake.class);
        return mySnowflake;
    }

    /**
     * 方便测试主键生成情况的main方法
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        List<Long> idList = new ArrayList<>();
//        for (int j = 0; j < 3; j++) {
//            new Thread(()->{
        for (int i = 0; i < 1 << 15; i++) {
            Long id = MyIdGenerator.genId();
//                    log.info(id.toString());
//                    Long id = IdUtil.getSnowflakeNextId();
//                    long l = id % 1_000_000_000_000_000L;
            log.info(id + "");
            idList.add(id);
        }
//            }, "thread"+j).start();
//        }
        TimeUnit.SECONDS.sleep(2);
        log.info("list size = {}", idList.size());
        List<Long> collect = idList.stream().distinct().collect(Collectors.toList());
        log.info("distinct list size = {}", collect.size());
    }
}
