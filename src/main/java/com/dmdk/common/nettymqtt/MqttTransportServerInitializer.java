package com.dmdk.common.nettymqtt;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.mqtt.MqttDecoder;
import io.netty.handler.codec.mqtt.MqttEncoder;

public class MqttTransportServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel sc) throws Exception {
        ChannelPipeline pipeline = sc.pipeline();

        //编码，解码65536
        pipeline.addLast("decoder", new MqttDecoder(65536));
        pipeline.addLast("encoder", MqttEncoder.INSTANCE);
        MqttHandler handler = new MqttHandler();
        pipeline.addLast(handler);
        sc.closeFuture().addListener(handler);
    }

}
