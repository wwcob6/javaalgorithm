package com.java.algorithm;

import java.util.Arrays;

/**
 * Created by HappyTong
 * Date on 2021/1/18 15:19
 */
public class BubbleSortTest {
    public static void main(String[] args) {
        int[] arr = {3,1,2,4,5,6,1};
        BubbleSort(arr);
    }

    private static void BubbleSort(int[] arr) {
        if (arr == null || arr.length < 2){
            return;
        }
        for (int j = arr.length - 1; j > 0; j--) {

            for (int i = 0; i < j; i++) {
                if (arr[i] > arr[i+1]){
                    swap(arr, i, i+1);
                }
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
