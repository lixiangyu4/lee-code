package com.lixiangyu.lee.java8.redo.frunctioninterface;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import static java.util.Comparator.comparing;
/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-05-15 19:53
 **/
public class Test {

    @org.junit.Test
    public void test_01() {
        File[] fileList = new File("/Users/lixiangyu").listFiles(File::isHidden);
        for (File s : fileList) {
            System.out.println(s.getName());
        }
    }

    @org.junit.Test
    public void test_02() {
        List<Apple> appleList = getApples();
        prettyPrintApple(appleList, a -> "an apple of " + a.getName());
        prettyPrintApple(appleList, a -> "an apple of " + a.getWeight());
        prettyPrintApple(appleList, a -> "an apple of " + a.getPlace());
    }

    @org.junit.Test
    public void test_03() {
        //使用jdk内置的Predicate函数式接口
        List<Apple> appleList = getApples();
        isAppleFromChina(appleList, a -> a.getPlace().equals("中国"));
    }

    @org.junit.Test
    public void test_04() {
        //使用jdk内置的Consumer函数式接口
        List<Apple> appleList = getApples();
        printEveryOne(appleList, a -> System.out.println(a.getName()));
    }

    @org.junit.Test
    public void test_05() {
        //使用jdk内置的Function函数式接口
        List<Apple> appleList = getApples();
        List<Integer> map = map(appleList, a -> {
            Integer b = a.getName().length();
            b = b + 112312;
            return b;
        });
        System.out.println(map);
    }

    @org.junit.Test
    public void test_06() {
        IntPredicate evenNumbers = (int i) -> i % 2 == 0;
    }

    @org.junit.Test
    public void test_07() {
        Map<String, Function<Integer, Fruit>> map = new HashMap<>(8);
        map.put("apple", Apple::new);
        map.put("orange", Orange::new);

        Fruit a = map.get("apple").apply(1);
        System.out.println(a.toString());
    }

    /**
     * lambda表达式综合应用 + 接口的默认辅助方法
     */
    @org.junit.Test
    public void test_08() {
        //lambda表达式综合应用
        List<Apple> appleList = getApples();
        //方法一为单独实现Comparator接口
        //方法二使用匿名类
        appleList.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getNumber() - o2.getNumber();
            }
        });
        //方法三使用lambda 表达式
        appleList.sort((o1, o2) -> o1.getNumber().compareTo(o2.getNumber()));
        //方法四 Comparator的静态辅助方法
        Comparator<Apple> compar = Comparator.comparing((Apple a) -> a.getNumber());
        appleList.sort(compar);
        //方法五 使用静态引用
        //需要添加import static java.util.Comparator.comparing
        appleList.sort(comparing((Apple a) -> a.getNumber()));
        //方法六 在方法五的基础上使用方法引用
        appleList.sort(comparing(Apple::getNumber));
        //逆序
        appleList.sort(comparing(Apple::getNumber).reversed());
        //如果第一步比较相等的话，需要进一步比较 比较器复合
        appleList.sort(comparing(Apple::getNumber).reversed().thenComparing(Apple::getWeight));
        System.out.println(appleList.toString());

    }

    /**
     * 谓词组合
     */
    @org.junit.Test
    public void test_09() {
        //谓词组合
        //是否为红苹果
        Predicate<Apple> redApple = (Apple a) -> "red".equals(a.getColor());
        //是否不是红苹果
        Predicate<Apple> notRedApple = redApple.negate();
        //重150以上的红苹果 或 绿苹果 即 (a || b) && c
        redApple.and((a) -> a.getNumber() > 150).or((a) -> "green".equals(a.getColor()));
    }

    private static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(function.apply(t));
        }
        return result;
    }

    private static <T> void printEveryOne(List<T> list, Consumer<T> consumer) {
        for (T l : list) {
            consumer.accept(l);
        }
    }

    private static void prettyPrintApple(List<Apple> inventory, IApplePredicate predicate) {
        for (Apple apple : inventory) {
            String output = predicate.accept(apple);
            System.out.println(output);
        }
    }

    private static void isAppleFromChina(List<Apple> inventory, Predicate<Apple> predicate) {
        for (Apple a : inventory) {
            if(predicate.test(a)) {
                System.out.println(a.getName() + " is from china");
            }
        }
    }

    private static List<Apple> getApples() {
        Apple apple1 = new Apple();
        apple1.setName("1号苹果");
        apple1.setPlace("中国");
        apple1.setWeight("1.0");
        apple1.setNumber(111);
        apple1.setColor("red");
        Apple apple2 = new Apple();
        apple2.setName("2号苹果");
        apple2.setPlace("日本");
        apple2.setWeight("2.0");
        apple2.setNumber(2);
        apple2.setColor("green");
        Apple apple3 = new Apple();
        apple3.setName("3号苹果");
        apple3.setPlace("韩国");
        apple3.setWeight("3.0");
        apple3.setNumber(155);
        apple3.setColor("red");
        List<Apple> appleList = new ArrayList<>();
        appleList.add(apple1);
        appleList.add(apple2);
        appleList.add(apple3);
        return appleList;
    }



}
