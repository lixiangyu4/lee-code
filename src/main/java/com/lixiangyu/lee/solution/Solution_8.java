package com.lixiangyu.lee.solution;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-03-22 11:05
 **/
public class Solution_8 {


    public static int myAtoi(String str) {
        if(null == str || (str = str.trim()).length() == 0) {
            return 0;
        }
        int length = str.length();
        int result = 0;
        boolean plus = true;
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if(c == '+' && i == 0) {
                plus = true;
                continue;
            }
            if(c == '-'  && i == 0) {
                plus = false;
                continue;
            }
            if(((int)c >= 48 && (int)c <= 57)) {
                int pre = result;
                result = 10 * result + Character.getNumericValue(c);
                if(result / 10 != pre) {
                    return plus?Integer.MAX_VALUE:Integer.MIN_VALUE;
                }
            } else {
                return plus?result:-result;
            }
        }
        return plus?result:-result;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("   +0 123"));
    }

}
