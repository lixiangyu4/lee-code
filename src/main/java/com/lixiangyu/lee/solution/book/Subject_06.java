package com.lixiangyu.lee.solution.book;

/**
 * @author lixiangyu
 * @description 验证回文串
 * @create 2021-05-04 22:52:40
 */
public class Subject_06 {

    public static boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }

        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isPalindrome("abac"));
    }
}
