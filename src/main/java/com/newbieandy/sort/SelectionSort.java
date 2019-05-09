package com.newbieandy.sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 8, 3, 2, 9, 0, 2, 4};
        System.out.println(Arrays.toString(arr));
        selectionSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSort(int[] arr, int length) {
        for (int i = 0; i < length - 1; i++) {
            int min = arr[i];
            int min_post = i;
            int j = i;
            for (; j < length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    min_post = j;
                }
            }
            int temp = arr[i];
            arr[i] = min;
            arr[min_post] = temp;
        }
    }
}
