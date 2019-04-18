package com.newbieandy.netty.netty.serialization.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chao.ma
 * @Date 2019/4/18 10:48
 * @Version 1.0
 */
public class TestSubscribeReqProto {
    private static byte[] encode(SubscribeReqProto.SubscribeReq req) {
        return req.toByteArray();
    }

    private static SubscribeReqProto.SubscribeReq decode(byte[] body) throws InvalidProtocolBufferException {
        return SubscribeReqProto.SubscribeReq.parseFrom(body);
    }

    private static SubscribeReqProto.SubscribeReq createSubscribeReq() {
        SubscribeReqProto.SubscribeReq.Builder builder = SubscribeReqProto.SubscribeReq
                .newBuilder()
                .setSubReqId(1)
                .setUserName("Andy")
                .setProductName("Netty Book");
        List<String> address = new ArrayList<>();
        address.add("DaLian GanJingZi");
        address.add("BeiJing ChangPing");
        address.add("Huludao SuiZhong");
        builder.addAllAddress(address);
        return builder.build();
    }

    public static void main(String[] args) throws InvalidProtocolBufferException {
        SubscribeReqProto.SubscribeReq req = createSubscribeReq();
        System.out.println("Before encode:" + req.toString());
        SubscribeReqProto.SubscribeReq req2 = decode(encode(req));
        System.out.println("After decode:" + req.toString());
        System.out.println("Assert equal:-->" + req2.equals(req));
    }
}
