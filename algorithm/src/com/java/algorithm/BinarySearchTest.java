package com.java.algorithm;

import java.util.Arrays;

/**
 * Created by HappyTong
 * Date on 2021/1/18 21:55
 */
public class BinarySearchTest {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,6,6,7,7,7,7,7,7,7,7,7,8};
        System.out.println(String.valueOf(exist(arr, 88)));
    }

    private static boolean exist(int[] arr, int num) {
        if (arr == null || arr.length < 2){
            return true;
        }
        int left = 0;
        int right = arr.length - 1;
        while (right > left){
            int mid = left + ((right - left) >> 1);
            if (arr[mid] == num){
                return true;
            }else if (arr[mid] > num){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return arr[left] == num;
    }

}
