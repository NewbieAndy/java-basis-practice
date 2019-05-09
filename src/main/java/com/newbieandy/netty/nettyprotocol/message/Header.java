package com.newbieandy.netty.nettyprotocol.message;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chao.ma
 * @Date 2019/4/23 15:11
 * @Version 1.0
 */
public final class Header {
    /*
     * 消息校验码,3部分组成
     * 1).0XABEF:固定值,2字节
     * 2).主版本号:1~255,1字节
     * 3).次版本号:1~225,1字节
     * crcCode=0XABEF+主版本号+次版本号
     */
    private int crcCode = 0Xabef0101;
    /*
     * 消息长度
     * 整个消息,包括消息头和消息体
     */
    private int length;

    /*
     *唯一会话ID
     */
    private long sessionID;

    /*
     *类型
     * 0:业务请求消息
     * 1:业务响应消息
     * 2:业务one way 消息
     * 3:握手请求消息
     * 4:握手应答消息
     * 5:心跳请求消息
     * 6:心跳应答消息
     */
    private byte type;

    /*
     * 消息优先级0~255
     */
    private byte priority;

    /*
     *可选字段
     */
    private Map<String, Object> attachment = new HashMap<>();

    public final int getCrcCode() {
        return crcCode;
    }

    public final void setCrcCode(int crcCode) {
        this.crcCode = crcCode;
    }

    public final int getLength() {
        return length;
    }

    public final void setLength(int length) {
        this.length = length;
    }

    public final long getSessionID() {
        return sessionID;
    }

    public final void setSessionID(long sessionID) {
        this.sessionID = sessionID;
    }

    public final byte getType() {
        return type;
    }

    public final void setType(byte type) {
        this.type = type;
    }

    public final byte getPriority() {
        return priority;
    }

    public final void setPriority(byte priority) {
        this.priority = priority;
    }

    public final Map<String, Object> getAttachment() {
        return attachment;
    }

    public final void setAttachment(Map<String, Object> attachment) {
        this.attachment = attachment;
    }

    @Override
    public String toString() {
        return "Header{" +
                "crcCode=" + crcCode +
                ", length=" + length +
                ", sessionID=" + sessionID +
                ", type=" + type +
                ", priority=" + priority +
                ", attachment=" + attachment +
                '}';
    }
}
