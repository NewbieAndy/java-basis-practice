package com.newbieandy.netty.netty.serialization.protobuf;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.Arrays;

/**
 * @author chao.ma
 * @Date 2019/4/18 14:30
 * @Version 1.0
 */
public class SubreqclientHandler extends ChannelHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 10; i++) {
            ctx.write(subReq(i));
        }
        ctx.flush();
    }

    private SubscribeReqProto.SubscribeReq subReq(int i) {
        return SubscribeReqProto.SubscribeReq.newBuilder()
                .setSubReqId(i)
                .setUserName("andy")
                .setProductName("Netty Book For Protobuf")
                .addAllAddress(Arrays.asList("DaLian GanJingZi", "BeiJing ChangPing", "Huludao SuiZhong"))
                .build();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("Receive server response:[" + msg + "]");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
