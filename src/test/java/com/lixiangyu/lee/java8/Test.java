package com.lixiangyu.lee.java8;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-01-11 17:55
 **/
public class Test {

    public static void main(String[] args) {
//        System.out.println("=========运行成功======");
//        String str = "a,b,c,d";
//        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
//        while (stringTokenizer.hasMoreTokens()) {
//            System.out.println(stringTokenizer.nextToken());
//        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i< 10000000; i++) {
            list.add(new String("aaa"));
        }
    }

}
