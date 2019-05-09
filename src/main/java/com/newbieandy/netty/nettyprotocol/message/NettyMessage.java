package com.newbieandy.netty.nettyprotocol.message;

/**
 * @author chao.ma
 * @Date 2019/4/23 15:50
 * @Version 1.0
 */
public final class NettyMessage {
    private Header header;
    private Object body;

    public final Header getHeader() {
        return this.header;
    }

    public final void setHeader(Header header) {
        this.header = header;
    }

    public final Object getBody() {
        return this.body;
    }

    public final void setBody(Object body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "NettyMessage{" +
                "header=" + header +
                ", body=" + body +
                '}';
    }
}
