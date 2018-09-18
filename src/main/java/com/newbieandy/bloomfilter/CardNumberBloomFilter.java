package com.newbieandy.bloomfilter;


public class CardNumberBloomFilter {

//    static  CardNumberBloomFilter create(long total, double fpp) {
//        checkNotNull(funnel);
//        checkArgument(
//                expectedInsertions >= 0, "Expected insertions (%s) must be >= 0", expectedInsertions);
//        checkArgument(fpp > 0.0, "False positive probability (%s) must be > 0.0", fpp);
//        checkArgument(fpp < 1.0, "False positive probability (%s) must be < 1.0", fpp);
//        checkNotNull(strategy);
//
//        if (expectedInsertions == 0) {
//            expectedInsertions = 1;
//        }
//        /*
//         * TODO(user): Put a warning in the javadoc about tiny fpp values, since the resulting size
//         * is proportional to -log(p), but there is not much of a point after all, e.g.
//         * optimalM(1000, 0.0000000000000001) = 76680 which is less than 10kb. Who cares!
//         */
//        long numBits = optimalNumOfBits(expectedInsertions, fpp);
//        int numHashFunctions = optimalNumOfHashFunctions(expectedInsertions, numBits);
//        try {
//            return new BloomFilter<T>(new LockFreeBitArray(numBits), numHashFunctions, funnel, strategy);
//        } catch (IllegalArgumentException e) {
//            throw new IllegalArgumentException("Could not create BloomFilter of " + numBits + " bits", e);
//        }
//    }
//
//    public boolean put(String string, int numHashFunctions, RedisBitmaps bits) {
//        long bitSize = bits.bitSize();
//        byte[] bytes = Hashing.murmur3_128().hashString(string, Charsets.UTF_8).asBytes();
//        long hash1 = lowerEight(bytes);
//        long hash2 = upperEight(bytes);
//
//        boolean bitsChanged = false;
//        long combinedHash = hash1;
////        for (int i = 0; i < numHashFunctions; i++) {
////            bitsChanged |= bits.set((combinedHash & Long.MAX_VALUE) % bitSize);
////            combinedHash += hash2;
////        }
//        long[] offsets = new long[numHashFunctions];
//        for (int i = 0; i < numHashFunctions; i++) {
//            offsets[i] = (combinedHash & Long.MAX_VALUE) % bitSize;
//            combinedHash += hash2;
//        }
//        bitsChanged = bits.set(offsets);
//        bits.ensureCapacityInternal();//自动扩容
//        return bitsChanged;
//    }
//
//    public boolean mightContain(String object, int numHashFunctions, RedisBitmaps bits) {
//        long bitSize = bits.bitSize();
//        byte[] bytes = Hashing.murmur3_128().hashString(object, Charsets.UTF_8).asBytes();
//        long hash1 = lowerEight(bytes);
//        long hash2 = upperEight(bytes);
//        long combinedHash = hash1;
////        for (int i = 0; i < numHashFunctions; i++) {
////            if (!bits.get((combinedHash & Long.MAX_VALUE) % bitSize)) {
////                return false;
////            }
////            combinedHash += hash2;
////        }
////        return true;
//        long[] offsets = new long[numHashFunctions];
//        for (int i = 0; i < numHashFunctions; i++) {
//            offsets[i] = (combinedHash & Long.MAX_VALUE) % bitSize;
//            combinedHash += hash2;
//        }
//        return bits.get(offsets);
//    }
}
