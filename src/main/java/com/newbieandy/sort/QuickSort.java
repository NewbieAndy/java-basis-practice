package com.newbieandy.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 8, 3, 2, 9, 0, 2, 4};
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] arr, int left, int right) {
        if (right <= left) {
            return;
        }
        int pivot = getPivot(arr, left, right);
        //确定起点指针
        int i = left;
        int j = right - 1;
        //移动指针
        for (; ; ) {
            //移动左边指针
            while (pivot > arr[++i]) {
            }
            //移动右边指针
            while (left < j && pivot < arr[--j]) {
            }
            //比较指针，进行数据交换
            if (j > i) {
                swap(arr, i, j);
            } else {
                break;
            }
        }
        //todo 这里需要注意
        if (i < right) {
            //主元归位
            swap(arr, i, right - 1);
        }
        //递归处理左边数据,i为主元位置
        quickSort(arr, left, i - 1);
        //递归处理右边数据
        quickSort(arr, i + 1, right);
    }

    static int getPivot(int[] arr, int left, int right) {
        int center = (left + right) / 2;
        if (arr[left] > arr[center]) {
            swap(arr, left, center);
        }
        if (arr[left] > arr[right]) {
            swap(arr, left, right);
        }
        if (arr[center] > arr[right]) {
            swap(arr, center, right);
        }
        //主元放到倒数第二位置
        swap(arr, center, right - 1);
        return arr[right - 1];
    }

    static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
