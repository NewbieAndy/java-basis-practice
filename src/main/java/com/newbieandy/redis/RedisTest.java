package com.newbieandy.redis;

import redis.clients.jedis.Jedis;
import redis.clients.util.MurmurHash;

public class RedisTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("47.104.220.59", 6379);
        jedis.set("1234", "00001");
        String s = jedis.get("1234");
        System.out.println(s);
        jedis.append("1234", "andy");
        System.out.println(jedis.get("1234"));
        System.out.println(jedis.get("333"));
        System.out.println("=============List Test============");
        jedis.expire("list", 0);
        jedis.lpush("list", "andy", "amy", "tom", "jay");
        System.out.println("len" + jedis.llen("list"));
        System.out.println(jedis.lpop("list"));
        System.out.println(jedis.rpop("list"));
        System.out.println(jedis.rpop("list"));
        System.out.println(jedis.lindex("list", 0));
        System.out.println("len" + jedis.llen("list"));
        System.out.println("===============set test=========");
        jedis.sadd("set", "1", "2", "4", "1");
        System.out.println(jedis.srem("set", "1"));
        System.out.println(jedis.sismember("set", "1"));
        System.out.println(jedis.srem("set", "1"));
        System.out.println("=============hash test============");
        jedis.hset("hash", "name", "andy");
        jedis.hset("hash", "age", "22");
        System.out.println(jedis.hgetAll("hash"));
        System.out.println(jedis.hget("hash", "age"));
        System.out.println("==========int test=========");
        jedis.set("int", "1");
        System.out.println(jedis.get("int"));
        jedis.incr("int");
        System.out.println(jedis.get("int"));
        jedis.incrBy("int", 10);
        System.out.println(jedis.get("int"));
        System.out.println("==============byte string test===========");
        jedis.expire("byteString", 0);
        jedis.append("byteString", "HelloAndy");
        System.out.println(jedis.get("byteString"));
        System.out.println(jedis.getrange("byteString", 2, 5));
        jedis.setrange("byteString", 2, "news");
        System.out.println(jedis.getrange("byteString", 2, 5));
        System.out.println("getBit:" + jedis.getbit("byteString", 2));
        jedis.setbit("byteString", 2, true);
        System.out.println("getBit:" + jedis.getbit("byteString", 2));
        System.out.println(jedis.get("byteString"));
        System.out.println("bitCount:" + jedis.bitcount("byteString"));
        System.out.println("bitCount:" + jedis.bitcount("byteString", 0, -1));
        System.out.println("=================bitmap test==============");
        jedis.setbit("bitMap", 536870911, false);
        System.out.println(jedis.bitcount("bitMap"));
        System.out.println("=================MurmurHash test===========");
        int hash = MurmurHash.hash("12343".getBytes(), 6);
        int hash1 = MurmurHash.hash("12345".getBytes(), 6);
        System.out.println(hash);
        System.out.println(hash1);
    }
}
