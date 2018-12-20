package com.lixiangyu.lee.java8.test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: leecode
 * @description: lambda排序
 * @author: lixiangyu
 * @create: 2018-11-02 17:56
 **/
public class Java8Test5 {

    public static void main(String[] args) {
        String[] players = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka", "David Ferrer",
                "Roger Federer", "Andy Murray",
                "Tomas Berdych", "Juan Martin Del Potro",
                "Richard Gasquet", "John Isner"};

        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(Arrays.toString(players));

        Arrays.sort(players, (o1,o2) -> o1.compareTo(o2));

        Arrays.sort(players, (p1,p2) -> p1.length() - p2.length());
        System.out.println(Arrays.toString(players));
    }

}
