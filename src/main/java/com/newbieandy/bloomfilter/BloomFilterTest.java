package com.newbieandy.bloomfilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.PrimitiveSink;

public class BloomFilterTest {
    public static void main(String[] args) {
        BloomFilter<String> bloomFilter = BloomFilter.create(new Funnel<String>() {
            @Override
            public void funnel(String from, PrimitiveSink into) {

            }
        }, 6);
        System.out.println(bloomFilter.put("123"));
        System.out.println(bloomFilter.put("123"));
        System.out.println(bloomFilter.mightContain("123"));
    }
}
