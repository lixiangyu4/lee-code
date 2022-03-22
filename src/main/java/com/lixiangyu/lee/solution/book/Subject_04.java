package com.lixiangyu.lee.solution.book;

import java.util.Arrays;

/**
 * @author lixiangyu
 * @description 合并两个有序数组
 * @create 2021-05-04 17:31:00
 */
public class Subject_04 {

    /**
     *  方法一
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge_01(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            System.out.print(Arrays.toString(nums1));
        }

        int i = m - 1;
        int j = n - 1;
        int po = m + n - 1;

        while (j >=0) {
            nums1[po--] = (i >= 0 && nums1[i] > nums2[j]) ?  nums1[i--] : nums2[j--];
            //二者等价
//            if (i >= 0) {
//                if (nums1[i] <= nums2[j]) {
//                    nums1[po--] = nums2[j--];
//                } else {
//                    nums1[po--] = nums1[i--];
//                }
//            }  else {
//                nums1[po--] = nums2[j--];
//            }
        }
        System.out.print(Arrays.toString(nums1));
    }

    public static void merge_02(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            System.out.print(Arrays.toString(nums1));
        }

        int i = 0;
        int j = 0;
        int index = 0;
        int[] temp = new int[m + n];
        while (i < m && j < n) {
            if (nums1[i] <=nums2[j]) {
                temp[index++] = nums1[i++];
            } else {
                temp[index++] = nums2[j++];
            }
        }

        while (i<m) {
            temp[index++] = nums1[i++];
        }
        while (j<n) {
            temp[index++] = nums2[j++];
        }

        for (int num= 0; num< m+n;num++) {
            nums1[num] = temp[num];
        }
        System.out.print(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        int[] a = new int[]{4,0,0,0,0,0};
        int[] b = new int[]{1,2,3,5,6};
        int m = 1;
        int n = 5;
        merge_02(a, m, b, n);
    }
}
