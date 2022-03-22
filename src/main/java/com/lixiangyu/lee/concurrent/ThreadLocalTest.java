package com.lixiangyu.lee.concurrent;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lixiangyu
 * @description
 * @create 2022-03-22 21:25:20
 */
public class ThreadLocalTest {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public static void main(String[] args) {
        safe();
    }

    private static void notSafe() {
        while (true) {
            new Thread(() -> {
                String dateStr = simpleDateFormat.format(new Date());
                try {
                    Date parse = simpleDateFormat.parse(dateStr);
                    String format = simpleDateFormat.format(parse);
                    boolean check = dateStr.equals(format);
                    if (!check) {
                        System.out.println(check + " " + dateStr + " " + format);
                    } else {
                        System.out.println(check);
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }).start();
        }
    }

    private static void safe() {
        ThreadLocal<SimpleDateFormat> thf = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        while (true) {
            new Thread(() -> {
                String dateStr = thf.get().format(new Date());
                try {
                    Date parse = thf.get().parse(dateStr);
                    String format = thf.get().format(parse);
                    boolean check = dateStr.equals(format);
                    if (!check) {
                        System.out.println(check + " " + dateStr + " " + format);
                    } else {
                        System.out.println(check);
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }).start();
        }
    }

}
