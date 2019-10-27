package com.lixiangyu.lee.java8.redo.completablefuture;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-06-10 19:55
 **/
public class CompletableFutureTest {

    public List<Shop> getShopList() {
        List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
                                         new Shop("LetsSaveBig"),
                                          new Shop("MyFavoriteShop"),
                                          new Shop("BugItAll"));

        return shops;

    }

    /**
     * 采用顺序查询所有商店的方式实现findPrice
     */
    private List<String> findPrice1(String product) {
        List<Shop> shops = getShopList();
        List<String> collect = shops.stream().map(x -> String.format("%s price is %.2f", x.getName(), x.getPrice(product))).collect(Collectors.toList());
        return collect;
    }

    /**
     * 采用并行流 顺序查询所有商店的方式实现findPrice
     */
    private List<String> findPrice2(String product) {
        List<Shop> shops = getShopList();
        List<String> collect = shops.parallelStream().map(x -> String.format("%s price is %.2f", x.getName(), x.getPrice(product))).collect(Collectors.toList());
        return collect;
    }

    /**
     * 采用CompletableFuture发起异步请求
     */
    private List<String> findPrice3(String product) {

        List<Shop> shops = getShopList();
        List<CompletableFuture<String>> collect = shops.stream().map(shop -> CompletableFuture.supplyAsync(() -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))).collect(Collectors.toList());
        List<String> collect1 = collect.stream().map(CompletableFuture::join).collect(Collectors.toList());
        return collect1;
    }

    /**
     * 自定义线程执行器
     */
    Executor executor = Executors.newFixedThreadPool(Math.min(getShopList().size(), 100), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        }
    });

    /**
     * 使用自定义线程池执行器
     */
    private List<String> findPrice4(String product) {
        List<Shop> shops = getShopList();

        List<CompletableFuture<String>> collect = shops.stream().map(shop -> CompletableFuture.supplyAsync(() -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)), executor)).collect(Collectors.toList());
        List<String> collect1 = collect.stream().map(CompletableFuture::join).collect(Collectors.toList());
        return collect1;
    }

    /**
     * 调用两个远程接口
     * @param product
     * @return
     */
    private List<String> findPrice5(String product) {

        List<Shop> shops = getShopList();
        List<String> collect = shops.stream().map(shop -> shop.getPrice1(product)).map(Quote::parse).map(Discount::applyDiscount).collect(Collectors.toList());
        return collect;

    }

    /**
     * 调用两个远程接口--使用CompletableFuture
     * @param product
     * @return
     */
    private List<String> findPrice6(String product) {

        List<Shop> shops = getShopList();
        List<CompletableFuture<String>> collect = shops.stream()
            .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice1(product), executor))
            .map(future -> future.thenApply(Quote::parse))
            .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), executor)))
            .collect(Collectors.toList());
        List<String> collect1 = collect.stream().map(CompletableFuture::join).collect(Collectors.toList());
        return collect1;

    }


    @Test
    public void test_02() {
        long start = System.nanoTime();
        System.out.println(findPrice1("myPhone27S"));
        long duration = (System.nanoTime() - start) / 1000000;
        System.out.println("Done in " + duration + " msecs");
    }

    /**
     * 采用并行流
     */
    @Test
    public void test_03() {
        long start = System.nanoTime();
        System.out.println(findPrice2("myPhone27S"));
        long duration = (System.nanoTime() - start) / 1000000;
        System.out.println("Done in " + duration + " msecs");
    }

    /**
     * 采用CompletableFuture发起异步请求
     */
    @Test
    public void test_04() {

        long start = System.nanoTime();
        System.out.println(findPrice3("myPhone27S"));
        long duration = (System.nanoTime() - start) / 1000000;
        System.out.println("Done in " + duration + " msecs");

    }

    /**
     * 使用自定义线程池
     */
    @Test
    public void test_05() {
        long start = System.nanoTime();
        System.out.println(findPrice4("myPhone27S"));
        long duration = (System.nanoTime() - start) / 1000000;
        System.out.println("Done in " + duration + " msecs");
    }


    @Test
    public void test_06() {

        long start = System.nanoTime();
        System.out.println(findPrice5("myPhone27S"));
        long duration = (System.nanoTime() - start) / 1000000;
        System.out.println("Done in " + duration + " msecs");

    }

    /**
     * 调用两个远程接口--使用CompletableFuture
     * @return
     */
    @Test
    public void test_07() {
        long start = System.nanoTime();
        System.out.println(findPrice6("myPhone27S"));
        long duration = (System.nanoTime() - start) / 1000000;
        System.out.println("Done in " + duration + " msecs");
    }


    /**
     * 响应CompletableFuture的completion事件
     * 希望的效果：之前实现的findPrice只有在取得所有的商店返回值时才显示商品的价格，
     *          现在的效果是只要有商店返回价格就第一时间显示返回值，不再等待那些还未返回的商店
     */
    @Test
    public void test_08() throws InterruptedException {
        Stream<CompletableFuture<String>> myPhone27S = findPricesStream("myPhone27S");
        Stream<CompletableFuture<Void>> stream = myPhone27S.map(f -> f.thenAccept(System.out::println));
        CompletableFuture[] futures =  stream.toArray(CompletableFuture[]::new);
        CompletableFuture.allOf(futures).join();
    }

    @Test
    public void test_09() {
        long start = System.nanoTime();
        Stream<CompletableFuture<String>> myPhone27S = findPricesStream("myPhone27S");
        CompletableFuture[] completableFutures = myPhone27S
            .map(f -> f.thenAccept(s -> System.out.println(s + " ( done in " + (System.nanoTime() - start) / 1000000 + "msecs )")))
            .toArray(CompletableFuture[]::new);
        CompletableFuture.allOf(completableFutures).join();
        System.out.println("All shops ave now responded in " + (System.nanoTime() - start) / 1000000 + " msecs");
    }

    private Stream<CompletableFuture<String>> findPricesStream(String product) {
        List<Shop> shops = getShopList();
        Stream<CompletableFuture<String>> completableFutureStream = shops.stream()
            .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPriceWithRandomDelay(product)))
            .map(future -> future.thenApply(Quote::parse))
            .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote))));
        return completableFutureStream;

    }

}
