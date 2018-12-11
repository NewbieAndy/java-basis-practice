package com.newbieandy.java.bigdecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalTime;

/**
 * Created by mchao on 2017/7/27.
 */
public class BigDecimalTest {
    public static void main(String[] args) {
//        String str = "203";
//        String[] split = str.split(",");
//        System.out.println(split[0]);
//        System.out.println(split[1]);

//        int sellementPrice = getSellementPrice(1000, 90, 1000);
//        System.out.println(sellementPrice);
        LocalTime of = LocalTime.of(0, 0, 0);
        LocalTime of1 = LocalTime.of(0, 0);
        System.out.println(of.equals(of1));
    }

    /**
     * 四舍五入
     */
    private static double divide(double a, double b) {
        return BigDecimal.valueOf(a).divide(BigDecimal.valueOf(b), 2, RoundingMode.HALF_EVEN).doubleValue();
    }

    private static int getSellementPrice(int basePrice, int percentage, int fixPrice) {
        return BigDecimal.valueOf(basePrice).multiply(BigDecimal.valueOf(percentage)).divide(BigDecimal.TEN).divide(BigDecimal.TEN).add(BigDecimal.valueOf(fixPrice)).intValue();
    }
}
