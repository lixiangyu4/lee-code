package com.lixiangyu.lee.java8.redo.completablefuture;

import java.util.concurrent.CompletableFuture;

/**
 * @author lixiangyu
 * @description
 * @create 2022-01-28 15:32:49
 */
public class TestMain {

    public static void main(String[] args) {
        CompletableFuture<String> rice = CompletableFuture.supplyAsync(() -> {
            System.out.println("开始制作米饭，并获得煮熟的米饭");
            return "煮熟的米饭";
        });
        CompletableFuture<String> milk = CompletableFuture.supplyAsync(() -> {
            System.out.println("开始加热牛奶 ，并获得热牛奶");
            return "热牛奶";
        });

        milk.thenCombine(rice, (m, r) -> {
            System.out.println("我收货了早饭:"+m + r);
            return m+r;
        });


    }


}
