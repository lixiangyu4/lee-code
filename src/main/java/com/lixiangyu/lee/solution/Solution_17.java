package com.lixiangyu.lee.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leecode
 * @description: Letter Combinations of a Phone Number
 * @author: lixiangyu
 * @create: 2019-04-10 16:58
 **/
public class Solution_17 {

    public static List<String> letterCombinations(String digits) {
        int[] numbers =     {  2 ,    3 ,    4 ,    5 ,     6 ,     7 ,    8 ,     9};
        String[] alphabet = {"abc", "def", "ghi", "jkl" , "mno", "pqrs", "tuv", "wxyz"};

        List<String> res = new ArrayList<>();
        List<String> param = new ArrayList<>();
        for (int i = 0 ; i < digits.length(); i++) {
            param.add(alphabet[Integer.valueOf(String.valueOf(digits.charAt(i)))-2]);
        }

        for (String str : param) {
            res = recursionLetterCombinations(res, str);
        }

        return res;
    }

    /**
     * 在str1字符串list后面拼接str2的字符
     * @param strList
     * @param str2
     * @return
     */
    private static List<String> recursionLetterCombinations(List<String> strList, String str2) {
        List<String> list = new ArrayList<>();
        if(strList.size() == 0) {
            for (int i = 0; i < str2.length(); i++) {
                list.add(String.valueOf(str2.charAt(i)));
            }
        } else {
            for (String str : strList) {
                for (int i = 0; i < str2.length(); i++) {
                    StringBuilder sb = new StringBuilder();
                    list.add(sb.append(str).append(str2.charAt(i)).toString());
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23").toString());
    }

}
