package com.lixiangyu.lee.solution.book;

/**
 * @author lixiangyu
 * @description 只出现一次的数字
 * @create 2021-05-01 00:29:52
 */
public class Subject_01 {

    public static int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int value = 0;
        for (int num : nums) {
            value ^= num;
        }
        return value;
    }

    public static void main(String[] args) {
        int[] num  =  new int []{2,2,1};
        System.out.println(singleNumber(num));
    }

}
