package com.lixiangyu.lee.java8.redo.completablefuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import lombok.Data;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-06-10 19:26
 **/
@Data
public class Shop {

    private String name;

    public Shop(String name) {
        this.name = name;
    }

    public double getPrice(String product) {
        return calculatePrice(product);
    }

    public String getPrice1(String product) {
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[new Random().nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s", name, price, code);
    }

    public String getPriceWithRandomDelay(String product) {
        double price = calculatePriceWithRandom(product);
        Discount.Code code = Discount.Code.values()[new Random().nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s", name, price, code);
    }

    private double calculatePrice(String product) {
        delay();
        Random random = new Random();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    private double calculatePriceWithRandom(String product) {
        randomDelay();
        Random random = new Random();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public Future<Double> getPriceAsync1(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();

        new Thread(() -> {
            try {
                double price = calculatePrice(product);
                futurePrice.complete(price);
            } catch (Exception e) {
                futurePrice.completeExceptionally(e);
            }

        }).start();

        return futurePrice;

    }

    public Future<Double> getPriceAsync2(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    private static final Random random = new Random();
    public static void randomDelay() {
        int delay = 500 + random.nextInt(3000);
        try {
            Thread.sleep(delay);
        } catch (Exception e) {

        }
    }

    public static void delay() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
    }


}
