package com.lixiangyu.lee.java8.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: leecode
 * @description: test
 * @author: lixiangyu
 * @create: 2018-11-01 16:42
 **/
public class Java8Test1 {

    public static void main(String[] args) {
        Java8Test1 java8Test1 = new Java8Test1();
        List<String> names1 = new ArrayList<>();
        names1.add("Google ");
        names1.add("Runoob ");
        names1.add("Taobao ");
        names1.add("Baidu ");
        names1.add("Sina ");
        java8Test1.sortUsingJava7(names1);
        System.out.println(names1);

        List<String> names2 = new ArrayList<>();
        names2.add("Google ");
        names2.add("Runoob ");
        names2.add("Taobao ");
        names2.add("Baidu ");
        names2.add("Sina ");
        java8Test1.sortUsingJava8(names2);
        System.out.println(names2);

    }


    public void sortUsingJava7(List<String> list) {
        System.out.println("sortUsingJava7");
        list.sort((o1, o2) -> o1.compareTo(o2));
    }

    public void sortUsingJava8(List<String> list) {
        System.out.println("sortUsingJava8");
        Collections.sort(list, (String o1,String o2) -> o2.compareTo(o1));
    }

}
