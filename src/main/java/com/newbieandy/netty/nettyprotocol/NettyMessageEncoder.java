package com.newbieandy.netty.nettyprotocol;

import com.newbieandy.netty.nettyprotocol.message.NettyMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.marshalling.MarshallingEncoder;

import java.util.List;

/**
 * 编码器
 *
 * @author chao.ma
 * @Date 2019/4/23 15:59
 * @Version 1.0
 */
public class NettyMessageEncoder extends MessageToMessageEncoder<NettyMessage> {

    MarshallingEncoder marshallingEncoder;

    public NettyMessageEncoder() {
//        marshallingEncoder=new MarshallingEncoder();
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, NettyMessage msg, List<Object> out) throws Exception {

    }
}
