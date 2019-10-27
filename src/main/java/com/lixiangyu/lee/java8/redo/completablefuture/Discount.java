package com.lixiangyu.lee.java8.redo.completablefuture;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-06-11 11:27
 **/
public class Discount {

    public enum Code {
        NONE(0), SLIVER(5), GOLD(10), PLATINUM(15), DIAMOND(20);

        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }
    }

    public static String applyDiscount(Quote quote) {
        return quote.getShopName() + "price is " + Discount.apply(quote.getPrice(), quote.getDiscountCode());
    }

    private static double apply(double price, Code code) {
        delay();
        return price * (100 - code.percentage) / 100;
    }
    public static void delay() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
    }

}
