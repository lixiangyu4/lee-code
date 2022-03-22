package com.lixiangyu.lee.arithmetic.reverseList;

/**
 * @author lixiangyu
 * @description
 * @create 2021-03-31 16:05:53
 */
public class ReverseString {

    public static void main(String[] args) {
        System.out.println(new String(reverseString("abcdef".toCharArray(), 0, 5)));
        System.out.println(leftShiftOne("abcdef", 2));
    }

    private static char[] reverseString(char[] s, int m, int n) {
        while (m < n) {
            char temp = s[m];
            s[m++] = s[n];
            s[n--] = temp;
        }
        return s;
    }

    /**
     * abcde -> cdeab
     * 思路：ab反转，cde反转，然后得到的字符串再整体反转即可
     */
    private static String leftShiftOne(String s, int k) {
        char[] chars = s.toCharArray();
        reverseString(chars, 0, k);
        reverseString(chars, k+1, s.length()-1);
        reverseString(chars, 0, s.length()-1);
        return new String(chars);
    }


}
