package com.lixiangyu.lee.solution;

/**
 * @program: leecode
 * @description: Implement strStr()
 * @author: lixiangyu
 * @create: 2019-04-25 16:42
 **/
public class Solution_28 {

    public static int strStr(String haystack, String needle) {
        if("".equals(needle)) {
            return 0;
        }
        if(haystack.trim().length() == 0) {
            return -1;
        }
        if(haystack.length() < needle.length()) {
            return -1;
        }

        for (int i = 0; i < haystack.length(); i++) {
            for (int j = 0, k = i; j < needle.length(); k++,j++) {
                if(k >= haystack.length()) {
                    return -1;
                }
                if (haystack.charAt(k) != needle.charAt(j)) {
                    break;
                } else if(j == needle.length()-1) {
                    return k-needle.length()+1;
                }
            }

        }
        return -1;

    }

    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "issipi"));
    }

}
