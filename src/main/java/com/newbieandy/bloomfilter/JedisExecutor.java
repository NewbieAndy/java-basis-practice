package com.newbieandy.bloomfilter;

import redis.clients.jedis.Jedis;

@FunctionalInterface
public interface JedisExecutor<T> {
    T execute(Jedis jedis);
}
