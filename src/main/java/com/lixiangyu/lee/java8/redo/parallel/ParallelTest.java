package com.lixiangyu.lee.java8.redo.parallel;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @program: leecode
 * @description: 并行流
 * @author: lixiangyu
 * @create: 2019-05-30 15:31
 **/
public class ParallelTest {

    /**
     * 并行流内部使用了默认的ForkJoinPool,它默认的线程数量就是处理器数量，
     * 这个值是由Runtime.getRuntime().avaliableProcessors()得到的
     * 可以通过系统属性java.util.concurrent.ForkJoinPool.common.parallelism来改变线程池大小
     * System.setProperties("java.util.concurrent.ForkJoinPool.common.parallelism", "12");
     */
    @Test
    public void test_01() {
        int n  = 100;
        Long reduce = Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(0L, Long::sum);
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    @Test
    public void test_02() {
        //因为使用了Stream.iterate，整张归纳列表在程序开始时没有准备好，因而无法有效的把流划分为小块来并行处理
        System.out.println(measureSumPerf(ParallelTest::sequentlialSum, 1000));
        //1、直接产生数字范围，很容易拆分为独立的小块
        //2、直接生产原始类型的long数字，没有装箱拆箱的开销
        System.out.println(measureSumPerf(ParallelTest::rangeSum, 1000));
    }

    @Test
    public void test_03() {
        //并行快于串行
        System.out.println(measureSumPerf(ParallelTest::rangeSum, 1000000));
        System.out.println(measureSumPerf(ParallelTest::parallelRangeSum, 1000000));
        //并行出错例子
        System.out.println(sideEffectSum(10000));
    }

    /**
     * 使用ForkJoin框架进行并行计算
     */
    @Test
    public void test_04() {
        long[] numbers = LongStream.rangeClosed(1,10000).toArray();
        ForkJoinSumCalculator forkJoinSumCalculator = new ForkJoinSumCalculator(numbers);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Long invoke = forkJoinPool.invoke(forkJoinSumCalculator);
        System.out.println(invoke);
    }

    /**
     * 找到String中的空格
     * 实现自己的Spliterator
     */
    @Test
    public void test_05() {

        System.out.println("=========不用流=========");
        String SENTENCE = " Nel  mezzo del cammin di nostra vita mi ritrovai in una selva oscura che la drita via era   smarrita ";
        System.out.println(countWordsIteratively(SENTENCE));

        Stream<Character> characterStream1 = IntStream.range(0, SENTENCE.length()).mapToObj(SENTENCE::charAt);
        Stream<Character> characterStream2 = IntStream.range(0, SENTENCE.length()).mapToObj(SENTENCE::charAt);
        //串行
        System.out.println("=========串行=========");
        WordCounter reduce1 = characterStream1.reduce(new WordCounter(0, true), WordCounter::accumulate, WordCounter::combine);
        System.out.println(reduce1.getCounter());

        //并行错误示例
        System.out.println("=========并行错误示例=========");
        System.out.println("=========并行结果有问题是因为，原始的String在任意位置拆分，所以有时一个词会被分为两个词=========");
        WordCounter reduce2 = characterStream2.parallel().reduce(new WordCounter(0, true), WordCounter::accumulate, WordCounter::combine);
        System.out.println(reduce2.getCounter());

        //使用自定义的Spliterator
        System.out.println("=========使用自定义的Spliterator=========");
        WordCounterSpliterator wordCounterSpliterator = new WordCounterSpliterator(SENTENCE);
        Stream<Character> stream = StreamSupport.stream(wordCounterSpliterator, true);
        WordCounter reduce = stream.reduce(new WordCounter(0, true), WordCounter::accumulate, WordCounter::combine);
        System.out.println(reduce.getCounter());


    }


    @Test
    public void test_06() {

        doSomeThing((ITask) () -> System.out.println(""));

    }


    private static void doSomeThing(ITask task) {
        task.execute();
    }

    private static void doSomeThing(Runnable runnable) {
        runnable.run();
    }


    private int countWordsIteratively(String s) {

        int counter = 0;
        boolean lastSpace = true;
        for (char c : s.toCharArray()) {
            if(Character.isWhitespace(c)) {
                lastSpace = true;
            } else {
                if(lastSpace) {
                    counter++;
                    lastSpace = false;
                }
            }
        }
        return counter;
    }





    private static long sideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(0L, n).forEach(accumulator::add);
        return accumulator.total;
    }







    private static Long sequentlialSum(Long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(0L, Long::sum);
    }

    private static long rangeSum(long n) {
        return LongStream.rangeClosed(0L, n).reduce(0L, Long::sum);
    }

    private static long parallelRangeSum(long n) {
        return LongStream.rangeClosed(0L, n).parallel().reduce(0L, Long::sum);
    }


    private static long measureSumPerf(Function<Long, Long> apply, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = apply.apply(n);
            long duration = (System.nanoTime() - start) / 1000;
            if(duration < fastest) {
                fastest = duration;
            }
        }
        return fastest;
    }

}
