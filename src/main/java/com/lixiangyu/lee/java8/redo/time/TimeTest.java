package com.lixiangyu.lee.java8.redo.time;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-06-19 17:50
 **/
public class TimeTest {

    @Test
    public void test_01() {
        LocalDate date = LocalDate.of(2014, 3, 18);
        int year = date.getYear();

        //获取当前日期
        System.out.println(LocalDate.now());

        System.out.println(date.get(ChronoField.DAY_OF_MONTH));

        //获取当前时间
        LocalDateTime nowTime= LocalDateTime.now();
        //自定义时间
        LocalDateTime endTime = LocalDateTime.of(2017, 10, 22, 10, 10, 10);
        //比较  现在的时间 比 设定的时间 之后  返回的类型是Boolean类型
        System.out.println(nowTime.isAfter(endTime));
        //比较   现在的时间 比 设定的时间 之前  返回的类型是Boolean类型
        System.out.println(nowTime.isBefore(endTime));
        //比较   现在的时间 和 设定的时候  相等  返回类型是Boolean类型
        System.out.println(nowTime.equals(endTime));

        LocalDateTime marketEndTime = DateUtils.timestamToDatetime(1561132799000L);
        System.out.println(marketEndTime);
        System.out.println();
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));

    }



}
