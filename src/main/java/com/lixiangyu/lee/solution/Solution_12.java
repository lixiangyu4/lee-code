package com.lixiangyu.lee.solution;

/**
 * @program: leecode
 * @description: Integer to Roman
 *  Input is guaranteed to be within the range from 1 to 3999.
 * @author: lixiangyu
 * @create: 2019-03-29 14:55
 **/
public class Solution_12 {


    public static String intToRoman(int num) {

        String[] romans = {"M", "CM", "D", "CD",  "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] nums =      {1000, 900, 500, 400,  100,  90,   50,  40,   10,   9,   5,    4 ,  1};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] <= num) {
                num = num - nums[i];
                sb.append(romans[i]);
            }
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(intToRoman(400));
    }


}
