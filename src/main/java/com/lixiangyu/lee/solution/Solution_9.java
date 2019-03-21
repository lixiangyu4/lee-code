package com.lixiangyu.lee.solution;

/**
 * @program: leecode
 * @description: Palindrome Number
 * @author: lixiangyu
 * @create: 2019-03-20 21:59
 **/
public class Solution_9 {

    public static boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        } else if(x == 0) {
            return true;
        } else {
            int reserseNum = reverse(x);
            return x == reserseNum;
        }

    }

    public static int reverse(int x) {
        int result=0, pre = 0;
        while (x != 0) {
            pre = result;
            result = result * 10 + x % 10;
            if(result / 10 != pre) {
                return 0;
            }
            x = x / 10;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(isPalindrome(111));
    }

}
