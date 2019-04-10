package com.lixiangyu.lee.solution;

/**
 * @program: leecode
 * @description: Longest Common Prefix
 * All given inputs are in lowercase letters a-z.
 * @author: lixiangyu
 * @create: 2019-04-09 10:51
 **/
public class Solution_14 {

    public static String longestCommonPrefix(String[] strs) {

        if(strs == null || strs.length == 0) {
            return "";
        }
        int length = 0;
        String string = null;
        for (int i = 0; i < strs.length; i++) {
            if(i == 0) {
                string = strs[i];
                length = strs[i].length();
            } else {
                if(strs[i].length() < length) {
                    string = strs[i];
                    length = strs[i].length();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if(strs[j].charAt(i) != c) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        String[] staArr = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(staArr));
    }

}
