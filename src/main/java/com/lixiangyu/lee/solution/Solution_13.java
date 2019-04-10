package com.lixiangyu.lee.solution;

/**
 * @program: leecode
 * @description: Roman to Integer
 *  Input is guaranteed to be within the range from 1 to 3999.
 * @author: lixiangyu
 * @create: 2019-04-09 10:14
 **/
public class Solution_13 {




    public static int romanToInt(String s) {

        int length = s.length();
        int num = 0;

        for (int i = 0; i < length; i++) {
            String c1 = s.charAt(i) + "";
            String c2 = null;
            if(i+1 < length) {
                c2 = s.charAt(i+1) + "";
            }
            if(toInt(c1 + c2) != -1) {
                num += toInt(c1 + c2);
                i++;
            } else if(toInt(c1) != -1) {
                num += toInt(c1);
            }
        }
        return num;

    }

    private static int toInt(String c) {
        switch (c) {
            case "M" :
                return 1000;
            case "CM" :
                return 900;
            case "D" :
                return 500;
            case "CD" :
                return 400;
            case "C" :
                return 100;
            case "XC" :
                return 90;
            case "L" :
                return 50;
            case "XL" :
                return 40;
            case "X" :
                return 10;
            case "IX" :
                return 9;
            case "V" :
                return 5;
            case "IV" :
                return 4;
            case "I" :
                return 1;
            default:
                return -1;
        }


    }

    public static void main(String[] args) {
        System.out.println(romanToInt("DCXXI"));
    }

}
