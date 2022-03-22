package com.lixiangyu.lee.hashcode;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-02-13 14:16
 **/
public class Test {


    private static final int HASH_INCREMENT = 0x61c88647;

    public static void main(String[] args) {
        hashCode(8);
        hashCode(16);
        hashCode(32);

    }


    private static void hashCode(Integer length) {
        int hashCode = 0;
        for (int i = 0; i < length ;i++) {
            hashCode += HASH_INCREMENT;
            int pos = hashCode & (length - 1);
            System.out.print(pos);
            System.out.print("   ");
        }
        System.out.println("");

    }



}
