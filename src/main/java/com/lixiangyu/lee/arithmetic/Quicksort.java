package com.lixiangyu.lee.arithmetic;

import java.util.Arrays;

/**
 * @program: leecode
 * @description: 快速排序 
 * @author: lixiangyu
 * @create: 2019-07-25 10:58
 **/
public class Quicksort {


    private static void sort_01(int[] nums, int low, int height) {
        if (low > height) {
            return;
        }
        int i, j , index;
        i = low;
        j = height;
        //用子表的第一个元素做基准
        index = nums[i];
        while (i < j) {
            while (i < j && nums[j] > index) {
                j--;
            }
            if (i < j) {
                //用比基准小的数替换低位记录
                nums[i++] = nums[j];
            }
            while (i < j && nums[i] < index) {
                i++;
            }
            if (i < j) {
                //用比基准大的数替换高位记录
                nums[j--] = nums[i];
            }
        }

        nums[i] = index;
        sort_01(nums, low, i -1);
        sort_01(nums, i + 1, height);

    }

    private static void sort_01(int[] nums) {
        sort_01(nums , 0, nums.length - 1);
    }


    public static void sort_02(int[] nums , int low, int height) {

    }

    public static void sort_02(int[] nums) {

    }

    public static void main(String[] args) {
        int a[] = { 48, 38, 65, 97, 76, 13, 27, 49 };
        sort_01(a);
        System.out.println(Arrays.toString(a));
    }

}
