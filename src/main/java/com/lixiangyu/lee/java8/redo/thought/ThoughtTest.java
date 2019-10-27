package com.lixiangyu.lee.java8.redo.thought;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-06-24 19:38
 **/
public class ThoughtTest {

    @Test
    public void test_01() {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(subSets(list));
    }

    /**
     * 基于Stream的阶乘
     */
    @Test
    public void test_02() {
        long n = 100L;
        long reduce = LongStream.rangeClosed(1, n).reduce(1, (long a , long b) -> a * b);
        System.out.println(reduce);
    }

    /**
     * 尾递归
     */
    @Test
    public void test_03() {
        System.out.println(factorialHelper(1, 5));
    }

    private static long factorialHelper(long acc, long n) {
        return n == 1?acc : factorialHelper(acc * n, n-1);
    }

    /**
     * 科里化 start >============================================================<
     *  科里化是一种将具备2个参数的函数f转化为使用一个参数的函数g，并且这个函数的返回值也是一个函数，它会作为新函数的一个参数。
     *  后者的返回值和初始函数的返回值相同
     *  即 f(x,y) = (g(x))(y)
     */
    static DoubleUnaryOperator curriedConverter(double f, double b) {
        return (double x) -> x * f + b;
    }

    DoubleUnaryOperator convertorCtoF = curriedConverter(9.0 / 5, 32);
    DoubleUnaryOperator convertorUSDtoGBP = curriedConverter(0.6, 0);
    DoubleUnaryOperator convertorKmttoMi = curriedConverter(0.6214, 0);

    /**
     * 科里化 end   >============================================================<
     */


    /**
     * Stream延迟计算 start ------------------------------------------------
     */
    private static Stream<Integer> primes(int n) {
        return Stream.iterate(2, i -> i+1).filter(ThoughtTest::isPrime).limit(n);
    }

    private static boolean isPrime(int candidate) {
        int candidateRoot = (int)Math.sqrt((double)candidate);
        return IntStream.rangeClosed(2,candidateRoot).noneMatch( i -> candidate % i == 0);
    }

    @Test
    public void test_04() {
        primes(100).forEach(System.out::println);
    }

    /**
     * 第一步：构造由数字组成的Stream
     * @return
     */
    private static IntStream numbers() {
        return IntStream.iterate(2, n -> n + 1);
    }
    /**
     * 第二步：取得首元素
     */
    private static int head(IntStream numbers) {
        return numbers().findFirst().getAsInt();
    }
    /**
     * 第三步：对尾部元素进行筛选
     */
    private static IntStream tail(IntStream numbers) {
        return numbers.skip(1);
    }
    /**
     * 第四步： 递归地创建由质数组成的Stream
     */
    private static IntStream primes(IntStream numbers) {
        int head = head(numbers);
        return IntStream.concat(IntStream.of(head), primes(tail(numbers).filter(n -> n % head != 0)));
    }

    @Test
    public void test_07() {
        primes(numbers()).forEach(System.out::println);
    }





    @Test
    public void test_05() {
        IntStream numbers = numbers();
        int head = head(numbers);
        IntStream stream = tail(numbers).filter(n -> n % head != 0);
        stream.limit(10).forEach(System.out::println);
    }
    @Test
    public void test_06() {
        IntStream numbers = numbers();
        int head = head(numbers);
        IntStream skip = numbers.skip(1);
        skip.filter(n -> n % head != 0).limit(10).forEach(System.out::println);
    }




    /**
     * Stream延迟计算 end ----------------------------------------------------
     */


    private static List<List<Integer>> subSets(List<Integer> list) {

        if (list.isEmpty()) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(Collections.EMPTY_LIST);
            return ans;
        }

        Integer first = list.get(0);
        List<Integer> rest = list.subList(1, list.size());
        List<List<Integer>> subans = subSets(rest);
        List<List<Integer>> subans2 = insertAll(first, subans);
        return concat(subans, subans2);

    }


    private static List<List<Integer>> insertAll(Integer first, List<List<Integer>> lists) {
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> list : lists) {
            List<Integer> copyList = new ArrayList<>();
            copyList.add(first);
            copyList.addAll(list);
            result.add(copyList);
        }
        return result;
    }

    private static List<List<Integer>> concat(List<List<Integer>> a, List<List<Integer>> b) {
        List<List<Integer>> r = new ArrayList<>(a);
        r.addAll(b);
        return r;
    }

}
