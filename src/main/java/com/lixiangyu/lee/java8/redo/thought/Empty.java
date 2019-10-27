package com.lixiangyu.lee.java8.redo.thought;

import java.util.function.Predicate;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-06-26 15:03
 **/
public class Empty<T> implements MyList<T> {
    @Override
    public T head() {
        throw new UnsupportedOperationException();
    }

    @Override
    public MyList<T> tail() {
        throw new UnsupportedOperationException();
    }

    @Override
    public MyList<T> filter(Predicate<T> p) {
        return null;
    }
}
