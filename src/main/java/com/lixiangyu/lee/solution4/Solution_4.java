package com.lixiangyu.lee.solution4;

/**
 * @program: leecode
 * @description: Median of Two Sorted Arrays
 * @author: lixiangyu
 * @create: 2018-10-25 21:21
 **/
public class Solution_4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
       if(n > m) {
           findMedianSortedArrays(nums2, nums1);
       }
       int l1,l2,r1,r2,c1,c2,lo = 0, hi = 2*n;
        while (lo <= hi) {
            c1 = (lo + hi) /2;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] num1 = {};
        System.out.println(num1.length);
    }

}
