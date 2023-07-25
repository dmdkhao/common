package com.dmdk.common.snowflake;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.thread.NamedThreadFactory;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
@DependsOn(value = "redisTemplate")
@Component
public class DcsSnowflakeGenerator implements CommandLineRunner {


    private final AtomicBoolean initFlag = new AtomicBoolean(false);
    private ExecutorService executorService;

    private static final String REDIS_KEY_SNOW_PREFIX = "snow1-";
    private String snowIdDataKey;
    private String lockKey;
    private String localhostStr;

    private SnowIdDTO snowIdDTO;


    @Autowired
    private RedissonClient redissonClient;


    @Override
    public void run(String... args) throws Exception {
        if (!initFlag.compareAndSet(false, true)) {
            return;
        }
        snowIdDataKey = REDIS_KEY_SNOW_PREFIX;
        lockKey = snowIdDataKey + "-lock";
        localhostStr = getIpAdd();

        // 心跳，防止redis中的值丢失

        // 线程池初始化
        executorService = new ThreadPoolExecutor(
                1,
                1,
                // 此处最大最小不一样没啥大的意义,因为消息队列需要达到 Integer.MAX_VALUE 才有点作用，
                // 矛盾来了，我每次批量拉下来不可能设置Integer.MAX_VALUE这么多，
                // 个人觉得每次批量下拉的原则 觉得消费可控就行，
                // 不然，如果出现异常情况下，整个服务示例突然挂了，拉下来太多，这些消息会被重复消费一次。
                0,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1),
                new NamedThreadFactory("paiotSnowflakeHeart", false),
                new ThreadPoolExecutor.DiscardOldestPolicy());

        executorService.execute(() -> {
            String lockKey = getLockKey();
            String dataKey = getKey();
            while (initFlag.get()) {
                SnowIdDTO snowIdDTO = getSnowIdDTO();
                if (snowIdDTO == null) {
                    continue;
                }



            }
        });

    }

    private String getLockKey() {
        return lockKey;
    }

    private String getKey() {
        return snowIdDataKey;
    }

    private SnowIdDTO getSnowIdDTO() {
        return snowIdDTO;
    }

    private static String getIpAdd() {
        return Optional.ofNullable(getLocalInetAddress()).map(InetAddress::getHostAddress).orElse("127.0.0.1");
    }

    private static InetAddress getLocalInetAddress() {
        final LinkedHashSet<InetAddress> localAddressList = NetUtil.localAddressList(address -> {
            // 非loopback地址，指127.*.*.*的地址
            return !address.isLoopbackAddress()
                    // 非地区本地地址，指10.0.0.0 ~ 10.255.255.255、172.16.0.0 ~ 172.31.255.255、192.168.0.0 ~ 192.168.255.255
//                    && false == address.isSiteLocalAddress()
                    // 需为IPV4地址
                    && address instanceof Inet4Address;
        });

        if (CollUtil.isNotEmpty(localAddressList)) {
            return CollUtil.get(localAddressList, 0);
        }
        try {
            return InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            // ignore
        }

        return null;
    }

    @Data
    public static class SnowIdDTO implements Serializable {
        private static final long serialVersionUID = 6570834012971579180L;
        /**
         * 注册时的时间戳
         */
        private Long timestamp;

        /**
         * 数据中心节点  0~31
         */
        private Integer dataCenterId;
        /**
         * 工作节点 0~31
         */
        private Integer workerId;

        /**
         * ip地址
         */
        private String ip;

        /**
         * 是否在线，0：离线，1：在线
         */
        private Integer online;

        public SnowIdDTO() {
        }

        public SnowIdDTO(Long timestamp, Integer dataCenterId, Integer workerId, String ip) {
            this.timestamp = timestamp;
            this.dataCenterId = dataCenterId;
            this.workerId = workerId;
            this.ip = ip;
            this.online = 1;
        }

    }
}
