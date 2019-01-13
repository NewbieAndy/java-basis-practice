package com.newbieandy.sort;

public class MergeSort {
    /**
     * recursion
     * merge_sort(p...r)=merge(merge_sort(p...q),merge_sort(q+1..r));
     * <p>
     * termination
     * p>=r
     *
     * @param arr
     * @param n
     */
    public static void mergeSort(int[] arr, int n) {


    }

    private static void mergeSortC(int[] arr, int start, int end) {
        if (end <= start) {
            return;
        }

        //get the median
        int median = (start + end) / 2;
        mergeSortC(arr, start, median);
        mergeSortC(arr, median + 1, end);
        merge(arr, start, median, end);
    }

    private static void merge(int[] arr, int start, int middle, int end) {

    }
}
