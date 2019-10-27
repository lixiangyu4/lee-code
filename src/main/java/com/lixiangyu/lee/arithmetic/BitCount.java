package com.lixiangyu.lee.arithmetic;

/**
 * @program: leecode
 * @description: 求一个数的二进制形式有多少个1
 * @author: lixiangyu
 * @create: 2019-07-09 23:16
 **/
public class BitCount {

    /**
     * 普通移位法
     */
    private static void count1(int number) {
        int count = 0;
        while (number != 0 ) {
            if ((number & 1) == 1) {
                count ++;
            }
            number = number >> 1;
        }
        System.out.println(count);
    }

    /**
     * 取模法 n & (n-1) 可以清除掉最右边的1
     * @param number
     */
    private static void count2(int number) {
        int i;
        for ( i = 0; number !=0 ;i++) {
            number &= number - 1;
        }
        System.out.println(i);
    }


    public static void main(String[] args) {
        count1(7);
        count2(7);
    }


}
