package com.lixiangyu.lee.solution;

/**
 * @program: leecode
 * @description: Longest Palindromic Substring
 * @author: lixiangyu
 * @create: 2019-03-20 16:47
 **/
public class Solution_5 {


    public String longestPalindrome(String s) {

        if(null == s) {
            return null;
        }
        if(s.length() <= 1) {
            return s;
        }

        int length = s.length();

        int [][] table = new int[length][length];

        for (int i = 0; i < length; i++) {
            table[i][i] = 1;
        }
        printtable(table);






        return null;
    }

    public static void printtable(int [][] table) {
        for (int[] y : table) {
            for (int x : y) {
                System.out.print(x + " ");
            }
            System.out.println("---");
        }
    }

    public static void main(String[] args) {
        Solution_5 solution_5 = new Solution_5();
        System.out.println(solution_5.longestPalindrome("abcaaa"));
    }

}
