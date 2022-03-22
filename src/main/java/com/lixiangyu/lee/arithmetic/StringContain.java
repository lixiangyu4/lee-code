package com.lixiangyu.lee.arithmetic;

/**
 * @author lixiangyu
 * @description 判断字符串是否包含
 * @create 2021-05-21 10:15:36
 */
public class StringContain {

    private static boolean stringContain(String a, String b) {
        int[] num = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59,61, 67, 71, 73, 79, 83, 89, 97, 101};

        char[] achars = a.toCharArray();
        int f = 1;
        for (int i = 0; i < achars.length; i++) {
            int value = num[achars[i] - 'A'];
            if (f % value > 0) {
                f *= value;
            }
        }

        char[] bchars = b.toCharArray();
        for (int j = 0; j < bchars.length; j++) {
            int value = num[bchars[j] - 'A'];
            //没有被整除
            if (f % value >0) {
                return false;
            }
        }
        return true;

    }

}
