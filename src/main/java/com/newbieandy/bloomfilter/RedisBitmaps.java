package com.newbieandy.bloomfilter;

import com.google.common.math.LongMath;

import java.math.RoundingMode;
import java.util.Arrays;

public class RedisBitmaps {
    private static final String BASE_KEY = "cardnumberbloomfilter";

    private JedisUtils jedisUtils;
    private long bitSize;

    RedisBitmaps(long bits) {
        this.jedisUtils = new JedisUtils();
        this.bitSize = LongMath.divide(bits, 64, RoundingMode.CEILING) * Long.SIZE;//位数组的长度，相当于n个long的长度
        if (bitCount() == 0) {
            jedisUtils.execute((jedis -> jedis.setbit(BASE_KEY, bitSize - 1, false)));
        }
    }

    boolean get(long[] offsets) {
        return Arrays.stream(offsets).boxed()
                .map(offset -> jedisUtils.execute(jedis -> jedis.getbit(BASE_KEY, offset)))
                .allMatch(b -> (Boolean) b);
    }

    boolean get(final long offset) {
        return jedisUtils.execute(jedis -> jedis.getbit(BASE_KEY, offset));
    }

    boolean set(long[] offsets) {
        boolean bitsChanged = false;
        for (long offset : offsets)
            bitsChanged |= set(offset);
        return bitsChanged;
    }

    boolean set(long offset) {
        if (!get(offset)) {
            jedisUtils.execute(jedis -> jedis.setbit(BASE_KEY, offset, true));
            return true;
        }
        return false;
    }

    long bitCount() {
        return jedisUtils.execute(jedis -> jedis.bitcount(BASE_KEY));
    }

    long bitSize() {
        return this.bitSize;
    }


    private String genkey(long cursor) {
        return BASE_KEY + "-" + cursor;
    }

    private PipelineExecutor apply(PipelineExecutor executor) {
        return executor;
    }
}
