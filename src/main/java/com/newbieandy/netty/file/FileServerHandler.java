package com.newbieandy.netty.file;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.io.File;

/**
 * @author chao.ma
 * @Date 2019/4/22 17:31
 * @Version 1.0
 */
public class FileServerHandler extends SimpleChannelInboundHandler<String> {
    public static final String CR = System.getProperty("line.separator");

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, String msg) throws Exception {
        File file = new File(msg);
        if (file.exists()) {

        }

    }
}
