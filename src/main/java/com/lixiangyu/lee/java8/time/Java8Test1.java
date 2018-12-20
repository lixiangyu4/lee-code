package com.lixiangyu.lee.java8.time;

import java.time.*;

/**
 * @program: leecode
 * @description: test
 * @author: lixiangyu
 * @create: 2018-11-08 13:58
 **/
public class Java8Test1 {

    public static void main(String[] args) {
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println(currentTime);
        LocalDate localDate = currentTime.toLocalDate();
        LocalTime localTime = currentTime.toLocalTime();
        System.out.println(localDate);
        System.out.println(localTime);
        int year = currentTime.getYear();
        Month month = currentTime.getMonth();
        int dayOfMonth = currentTime.getDayOfMonth();
        System.out.println("年:"+year + "月:" + month + "日:" + dayOfMonth);

        LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
        System.out.println("date2: " + date2);

        LocalDate date3 = LocalDate.of(2010, Month.JULY, 1);
        System.out.println(date3);

        // 解析字符串
        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date5: " + date5);

        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println(currentZone);

    }

}
