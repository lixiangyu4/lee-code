package com.lixiangyu.lee.java8.redo.collect;

import com.lixiangyu.lee.java8.redo.stream.Dish;
import com.lixiangyu.lee.java8.redo.stream.StreamTest;

import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program: leecode
 * @description: 用流收集数据
 * @author: lixiangyu
 * @create: 2019-05-28 19:33
 **/
public class CollectTest {

    @Test
    public void test_01() {

        List<Dish> menu = StreamTest.getDishList();
        int sum = menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println(sum);

    }

    /**
     * 归约和汇总
     * @throws ParseException
     */
    @Test
    public void test_02() {

        List<Dish> menu = StreamTest.getDishList();
        //通过一次summarizing 可以获取元素个数，热量总和，平均值，最大值，最小值
        System.out.println("====通过一次summarizing 可以获取元素个数，热量总和，平均值，最大值，最小值====");
        IntSummaryStatistics collect = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println(collect.getMax());
        System.out.println(collect.getMin());
        System.out.println(collect.getAverage());
        System.out.println(collect.getCount());

        //joining使用
        System.out.println("======joining使用=======");
        String collect1 = menu.stream().map(Dish::getName).collect(Collectors.joining());
        System.out.println(collect1);
        String collect2 = menu.stream().map(Dish::getName).collect(Collectors.joining(", "));
        System.out.println(collect2);

        System.out.println();
        Stream<Integer> stream = Arrays.asList(1,2,3,4,5,6).stream();
        List<Integer> reduce = stream.reduce(new ArrayList<Integer>(), (List<Integer> l, Integer e) -> {
                l.add(e);
                return l;
            },
            (List<Integer> ll, List<Integer> l2) -> {
                ll.addAll(l2);
                return ll;
            });
        System.out.println(reduce);
    }

    /**
     * 分组
     */
    @Test
    public void test_03() {

        List<Dish> menu = StreamTest.getDishList();
        /**
         * 把菜单中的菜按照类型进行分类
         */
        System.out.println("================把菜单中的菜按照类型进行分类=======================");
        Map<Dish.Type, List<Dish>> collect = menu.stream().collect(Collectors.groupingBy(Dish::getType));
        System.out.println(collect.toString());
        /**
         * 自定义分类方法
         */
        System.out.println("================自定义分类方法=======================");
        Map<CaloricLevel, List<Dish>> collect1 = menu.stream().collect(Collectors.groupingBy(dish -> {
            if (dish.getCalories() <= 400) {
                return CaloricLevel.DIET;
            } else if (dish.getCalories() <= 700) {
                return CaloricLevel.NORMAL;
            } else {
                return CaloricLevel.FAT;
            }
        }));
        System.out.println(collect1);
        /**
         * 多级分组
         */
        System.out.println("================多级分组=======================");
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> collect2 = menu.stream()
            //一级分类函数
            .collect(Collectors.groupingBy(Dish::getType,
            //二级分类函数
            Collectors.groupingBy(dish -> {
            if (dish.getCalories() <= 400) {
                return CaloricLevel.DIET;
            } else if (dish.getCalories() <= 700) {
                return CaloricLevel.NORMAL;
            } else {
                return CaloricLevel.FAT;
            }
        })));
        System.out.println(collect2);
        /**
         * 按子组进行收集数据
         */
        System.out.println("================按子组进行收集数据=======================");
        Map<Dish.Type, Long> collect3 = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
        System.out.println(collect3);
        /**
         * 把收集器的结果转换为另一种类型
         */
        System.out.println("================把收集器的结果转换为另一种类型=======================");
        Map<Dish.Type, Dish> collect4 = menu.stream().collect(Collectors.groupingBy(Dish::getType,
            Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
        System.out.println(collect4);
        /**
         * 与groupingby联和使用的其他收集器的例子
         */
        System.out.println("================与groupingby联和使用的其他收集器的例子=======================");
        Map<Dish.Type, Set<CaloricLevel>> collect5 = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.mapping(dish -> {
            if (dish.getCalories() <= 400) {
                return CaloricLevel.DIET;
            } else if (dish.getCalories() <= 700) {
                return CaloricLevel.NORMAL;
            } else {
                return CaloricLevel.FAT;
            }
        }, Collectors.toSet())));
        System.out.println(collect5);

    }

    /**
     * 分区
     */
    @Test
    public void test_04() {
        List<Dish> menu = StreamTest.getDishList();
        //筛选谓词和谓词的非进行分区, 素食与非素食
        System.out.println("============筛选谓词和谓词的非进行分区, 素食与非素食==================");
        Map<Boolean, Map<Dish.Type, List<Dish>>> collect = menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.groupingBy(Dish::getType)));
        System.out.println(collect);

        //找到素食和非素食中热量最高的菜
        System.out.println("============找到素食和非素食中热量最高的菜==================");
        Map<Boolean, Dish> collect1 = menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
        System.out.println(collect1);

        //自定义收集器
        System.out.println("============自定义收集器==================");
        List<Dish> collect2 = menu.stream().collect(new ToListCollector<Dish>());

    }

    private boolean isPrime(int candidate) {
        return false;
    }

    public enum CaloricLevel {
        DIET, NORMAL, FAT
    }

}
