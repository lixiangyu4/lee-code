package com.lixiangyu.lee.java8.redo.collect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * @program: leecode
 * @description: 将Stream<T>中的所有元素收集到一个List<T>中
 * @author: lixiangyu
 * @create: 2019-05-30 14:48
 **/
public class ToListCollector<T> implements Collector<T, List<T>, List<T>> {
    /**
     * 建立新的结果容器
     * @return
     */
    @Override
    public Supplier<List<T>> supplier() {
        return ArrayList::new;
    }

    /**
     * 将元素添加到结果容器中
     * @return
     */
    @Override
    public BiConsumer<List<T>, T> accumulator() {
        return List::add;
    }

    /**
     * 合并两个结果容器
     * @return
     */
    @Override
    public BinaryOperator<List<T>> combiner() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    /**
     * 对结果容器应用最终转换
     * @return
     */
    @Override
    public Function<List<T>, List<T>> finisher() {
        return Function.identity();
    }

    /**
     * 定义收集器的行为-尤其是关于流是否已经并行归约
     * CONCURRENT - accumulator函数可以从多个线程同时调用，且该收集器可以并行归约流。如果收集器没有标为UNORDERED,那它仅用于无序数据源时才可以并行归约
     * UNORDERED - 归约结果不受流中项目的遍历和累积顺序的影响
     * IDENTITY_FINISH - 这边明完成器方法返回的函数是一个恒等函数，可以跳过。
     *                  这种情况下，累加器对象将会直接用作归约过程的最终结果。这也意味着，将累加器A不加检查地转换为结果R是安全的
     * @return
     */
    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH, Characteristics.CONCURRENT));
    }
}
