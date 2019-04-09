package com.lixiangyu.lee.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leecode
 * @description: Roman to Integer
 *  Input is guaranteed to be within the range from 1 to 3999.
 * @author: lixiangyu
 * @create: 2019-04-09 10:14
 **/
public class Solution_13 {




    public static int romanToInt(String s) {

        String[] romans = {"M", "CM", "D", "CD",  "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] nums =      {1000, 900, 500, 400,  100,  90,   50,  40,   10,   9,   5,    4 ,  1};


        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < romans.length; i++) {
            map.put(romans[i], nums[i]);
        }

        int length = s.length();
        int num = 0;

        for (int i = 0; i < length; i++) {
            String c1 = s.charAt(i) + "";
            String c2 = null;
            if(i+1 < length) {
                c2 = s.charAt(i+1) + "";
            }
            if(map.keySet().contains(c1+c2)) {
                num += map.get(c1+c2);
                i++;
            } else if(map.keySet().contains(c1)) {
                num += map.get(c1);
            }
        }
        return num;

    }

    public static void main(String[] args) {
        System.out.println(romanToInt("DCXXI"));
    }

}
