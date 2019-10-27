package com.lixiangyu.lee.java8.redo.stream;

import lombok.Data;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-05-24 16:34
 **/
@Data
public class Transaction {


    private final Trader trader;
    private final int year;
    private final int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Transaction{" +
            "trader=" + trader +
            ", year=" + year +
            ", value=" + value +
            '}';
    }
}
