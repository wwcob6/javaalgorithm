package com.java.algorithm;

import java.util.Arrays;

/**
 * Created by HappyTong
 * Date on 2021/1/18 15:55
 */
public class InsertionSortTest {
    public static void main(String[] args) {
        int[] arr = {3,1,2,4,5,6,1};
        InsertionSort(arr);
        int[] array = generateRandomArray(10, 10);
        System.out.println(Arrays.toString(array));
    }
    public static int[] generateRandomArray(int maxSize, int maxValue){
        // Math.random [0,1)之间的小数
        // Math.random * N [0,N)之间的数
        // (int) (Math.random * N) [0,N-1]
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }
    private static void InsertionSort(int[] arr) {
        if (arr == null || arr.length < 2){
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j-1]; j--) {
                    swap(arr, j, j-1);
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
