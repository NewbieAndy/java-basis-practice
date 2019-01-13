package com.newbieandy.sort;

import java.util.Arrays;

/**
 * bubble sort
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 8, 3, 2, 9, 0, 2, 4};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }
}
