package com.lixiangyu.lee.java8.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @program: leecode
 * @description: test
 * @author: lixiangyu
 * @create: 2018-11-06 15:51
 **/
public class Java8Test1 {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> list = strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
        System.out.println(list.toString());
        //foreach
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::print);
        System.out.println();

        //每个数的平方
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<Integer> collect = numbers.stream().map(x -> x * x).distinct().collect(Collectors.toList());
        System.out.println(collect.toString());


        List<String> stringList = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        String aa = stringList.stream().filter(a -> !a.isEmpty()).map(String::toUpperCase).collect(Collectors.joining(","));
        System.out.println(aa.toString());

        //统计
        List<Integer> numberList = Arrays.asList(1,2,3,5,2,4,5,7453,34);
        IntSummaryStatistics intSummaryStatistics = numberList.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println(intSummaryStatistics.getMax());
        System.out.println(intSummaryStatistics.getAverage());
        System.out.println(intSummaryStatistics.getCount());

        //空字符串的数量
        long count = strings.stream().filter(String::isEmpty).count();
        System.out.println("空字符串的数量: "+ count );
        //长度为3的数量
        long count1 = strings.stream().filter(x -> x.length()==3).count();
        System.out.println("长度为3的数量: "+ count1);
        // 删除空字符串
        List<String> filterList = strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
        System.out.println(filterList.toString());
        // 删除空字符串，并使用逗号把它们合并起来
        String result = strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.joining(","));
        System.out.println(result);
        // 获取列表元素平方数
        List<Integer> numbersResult = numbers.stream().map(x -> x * x).distinct().collect(Collectors.toList());
        System.out.println(numbersResult.toString());
        // 输出10个随机数
        Random r = new Random();
        r.ints().limit(10).forEach(System.out::println);
        // 并行处理
        strings.parallelStream().filter(s ->!s.isEmpty()).collect(Collectors.toList());
    }

}
