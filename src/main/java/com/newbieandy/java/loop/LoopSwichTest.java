package com.newbieandy.java.loop;

/**
 * Created by mchao on 2017/8/28.
 */
public class LoopSwichTest {
    public static void main(String[] args) {

        String a = "";
        for (int i = 0; i < 10; i++) {
            System.out.println(i + "开始");

            switch (i) {
                case 4:
                    break;
                case 5:
                    break;
                default:
                    break;
            }

            System.out.println(i + "结束");

        }
    }
}
