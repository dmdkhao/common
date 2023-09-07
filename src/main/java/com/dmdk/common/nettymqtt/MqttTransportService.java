package com.dmdk.common.nettymqtt;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service("MqttTransportService")
@ConditionalOnExpression("'${transport.mqtt.enabled:true}' == 'true'")
@Slf4j
public class MqttTransportService {

    @Value("${transport.mqtt.bind_address}")
    private String host;
    @Value("${transport.mqtt.bind_port}")
    private Integer port;
    @Value("${transport.mqtt.netty.boss_group_thread_count}")
    private Integer bossGroupThreadCount;
    @Value("${transport.mqtt.netty.worker_group_thread_count}")
    private Integer workerGroupThreadCount;
    @Value("${transport.mqtt.netty.so_keep_alive}")
    private boolean keepAlive;


    private EventLoopGroup bossGroup;
    private EventLoopGroup workerGroup;
    private Channel serverChannel;


    @PostConstruct
    public void init() throws Exception{
        log.info("[mqttTransportService]即将开启服务器");
        bossGroup = new NioEventLoopGroup(bossGroupThreadCount);
        workerGroup = new NioEventLoopGroup(workerGroupThreadCount);
        ServerBootstrap b = new ServerBootstrap();
        b.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new MqttTransportServerInitializer())
                .childOption(ChannelOption.SO_KEEPALIVE, keepAlive);
        serverChannel = b.bind(host, port).sync().channel();
        log.info("[mqttTransportService]mqtt服务器开启成功");
    }

    @PreDestroy
    public void preDestroy() {
        log.info("[preDestroy]即将关闭mqtt服务器...");
        try {
            serverChannel.close().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
        log.info("[preDestroy]mqtt服务器已关闭");
    }
}
