package com.dmdk.common.snowflake;

import cn.hutool.core.lang.Singleton;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Slf4j
public class MyIdGenerator {

    public static Long genId() {
        MySnowflake mySnowflake = getSnowFlake();
        long id = mySnowflake.generateId();
        return id;
    }

    private static MySnowflake getSnowFlake() {
        MySnowflake mySnowflake = Singleton.get(MySnowflake.class);
        return mySnowflake;
    }

    public static void main(String[] args) throws InterruptedException {
        List<Long> idList = new ArrayList<>(1<<11);
        for (int j = 0; j < 4; j++) {
            new Thread(()->{
                for (int i = 0; i < 1<< 8; i++) {
                    Long id = MyIdGenerator.genId();
                    log.info(Thread.currentThread().getName());
                    idList.add(id);
                }
            }, "thread"+j).start();
        }
        TimeUnit.SECONDS.sleep(2);
        log.info("list size ={}", idList.size());
        List<Long> collect = idList.stream().distinct().collect(Collectors.toList());
        log.info("distinct list size = {}", collect.size());
    }
}
