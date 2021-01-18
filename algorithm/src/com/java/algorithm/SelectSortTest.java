package com.java.algorithm;

import java.util.Arrays;

/**
 * Created by HappyTong
 * Date on 2021/1/18 11:17
 */
public class SelectSortTest {
    public static void main(String[] args) {

        int[] arr = {5,2,3,7,1,6};
        SelectSort(arr);
    }
    public static void SelectSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr,i,minIndex);
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
