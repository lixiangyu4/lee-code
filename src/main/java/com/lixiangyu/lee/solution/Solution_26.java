package com.lixiangyu.lee.solution;

import java.util.Arrays;

/**
 * @program: leecode
 * @description: Remove Duplicates from Sorted Array
 * @author: lixiangyu
 * @create: 2019-04-23 15:23
 **/
public class Solution_26 {

    public static int removeDuplicates(int[] nums) {

        if(nums == null) {
            return 0;
        }
        if(nums.length == 1) {
            return 1;
        }
        int num = 1;

        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] != nums[i+1]) {
                nums[num] = nums[i+1];
                num++;
            }
        }

        System.out.println(Arrays.toString(nums));
        return num;
    }

    public static void main(String[] args) {
        int [] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }

}
