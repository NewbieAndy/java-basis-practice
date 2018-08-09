package com.newbieandy.java.bigdecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by mchao on 2017/7/27.
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        String str = "203";
        String[] split = str.split(",");
        System.out.println(split[0]);
        System.out.println(split[1]);
    }

    /**
     * 四舍五入
     */
    private static double divide(double a, double b) {
        return BigDecimal.valueOf(a).divide(BigDecimal.valueOf(b), 2, RoundingMode.HALF_EVEN).doubleValue();
    }
}
