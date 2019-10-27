package com.lixiangyu.lee.java8.redo.thought;

import org.junit.Test;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-06-26 15:03
 **/
public class MyListTest {

    @Test
    public void test_01() {
        MyList<Integer> l = new MyLinkedList<>(5, new MyLinkedList<>(10, new Empty<>()));
    }

    public static LazyList<Integer> from(int n) {
        return new LazyList<>(n, () -> from(n + 1));
    }

    @Test
    public void test_02() {
        LazyList<Integer> numbers = from(2);
        int two = numbers.head();
        int three = numbers.tail().head();
        int four = numbers.tail().tail().head();
        System.out.println(two + " " + three + " " + four);
    }

    public static MyList<Integer> primes(MyList<Integer> numbers) {
        return new LazyList<>(numbers.head(), () -> primes(numbers.tail().filter(n -> n % numbers.head()  != 0 )));
    }

    @Test
    public void test_03() {
        LazyList<Integer> numbers = from(2);
        MyList<Integer> primes = primes(numbers);
        System.out.println(primes.head() + " " + primes.tail().head() + " " + primes.tail().tail().head());
    }

    @Test
    public void test_04() {

    }

}
