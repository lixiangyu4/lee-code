package com.lixiangyu.lee.java8.redo.stream;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-05-20 10:06
 **/
public class StreamTest {

    @Test
    public void test_01() {

        List<Dish> menu = getDishList();
        List<String> collect = menu.stream()
            //选出400卡路里以下的菜肴
            .filter(d -> d.getCalories() < 400)
            //按照卡路里排序
            .sorted(comparing(Dish::getCalories))
            //提取菜肴名称
            .map(Dish::getName)
            //将所有名称保存在list中
            .collect(Collectors.toList());
        System.out.println(collect.toString());
    }

    @Test
    public void test_02() {
        /**
         * 流只能被消费一次，同一个流消费多次会抛出
         * @see java.lang.IllegalStateException 异常
         */
        List<Dish> menu = getDishList();
        Stream<Dish> stream = menu.stream();
        stream.filter(d -> d.getCalories() > 300).collect(Collectors.toList());
        stream.filter(d -> d.getCalories() > 400).collect(Collectors.toList());
    }

    @Test
    public void test_03() {
        /**
         * 查看流的运行
         */
        List<Dish> menu = getDishList();
        List<String> collect = menu.stream().filter(a -> {
            System.out.println("filtering " + a.getName());
            return a.getCalories() > 300;
        })
            .map(a -> {
                System.out.println("mapping " + a.getName());
                return a.getName();
            })
            .limit(3)
            .collect(Collectors.toList());
        System.out.println(collect.toString());
    }

    /**
     * distinct
     */
    @Test
    public void test_04() {

        List<Dish> menu = getDishList();
        //distinct
        List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4);
        numbers.stream().filter(i -> i%2==0).distinct().forEach(System.out::println);

    }

    /**
     * limit skip
     */
    @Test
    public void test_05() {

        List<Dish> menu = getDishList();
        List<Dish> collect1 = menu.stream().limit(3).filter(d -> d.getCalories() > 300).collect(Collectors.toList());
        System.out.println(collect1);
        List<Dish> collect2 = menu.stream().filter(d -> d.getCalories() > 300).limit(3).collect(Collectors.toList());
        System.out.println(collect2);

        //跳过超过300卡路里的头三道菜
        List<Dish> collect3 = menu.stream().filter(d -> d.getCalories() > 300).skip(3).collect(Collectors.toList());
        System.out.println(collect3);

        //选择前两个荤菜
        List<Dish> collect4 = menu.stream().filter(d -> d.getType().equals(Dish.Type.MEAT)).limit(2).collect(Collectors.toList());
        System.out.println(collect4);
    }

    /**
     * 使用flatMap 进行扁平化流
     */
    @Test
    public void test_06() {
        /**
         * 使用Stream().map()进行映射，可以只选择一列
         */
        List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        List<Integer> collect = words.stream().map(String::length).collect(Collectors.toList());
        System.out.println(collect);

        List<String> words1 = Arrays.asList("Hello", "World");
        List<String[]> collect1 = words1.stream().map(a -> a.split("")).distinct().collect(Collectors.toList());
        System.out.println(collect1);

        /**
         * 使用flatMap 进行扁平化流
         */
        List<String> collect2 = words1.stream().map(d -> d.split(""))
            //将各个生成流扁平化为单个流
            .flatMap(Arrays::stream)
            .distinct().collect(Collectors.toList());
        System.out.println(collect2);

    }

    /**
     * 使用flatMap练习
     */
    @Test
    public void test_07() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        List<Integer> collect = numbers.stream().map(a -> a * a).collect(Collectors.toList());
        System.out.println(collect);

        List<Integer> number1 = Arrays.asList(1,2,3);
        List<Integer> number2 = Arrays.asList(3,4);

        List<int[]> collect1 = number1.stream().flatMap(i -> number2.stream().map(j -> new int[]{i, j})).collect(Collectors.toList());
        System.out.println(collect1.toString());
        List<int[]> collect2 = number1.stream().flatMap(i -> number2.stream().filter(j -> (i + j) % 3 == 0).map(j -> new int[]{i, j})).collect(Collectors.toList());
        System.out.println(collect2.toString());
    }


    /**
     * 查找和匹配
     */
    @Test
    public void test_08() {
        List<Dish> menu = getDishList();
        //检查谓词是否至少匹配一个元素
        if(menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("aaa");
        }
        //检查谓词是否匹配所有元素
        if(menu.stream().allMatch(a -> a.getCalories() < 1000)) {
            System.out.println("bbb");
        }
        System.out.println("------------");
        //finaAny返回当前流中的任意元素
        Optional<Dish> any = menu.stream().filter(Dish::isVegetarian).findAny();

        any.ifPresent(dish -> System.out.println(dish.toString()));

        any.ifPresent(d -> System.out.println("存在元素"));

    }

    /**
     * findFirst Optional使用
     */
    @Test
    public void test_09() {
        //找到第一个平方能被3整除的数
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        Optional<Integer> first = numbers.stream().filter(i -> i * i % 3 == 0).findFirst();
        first.ifPresent(System.out::println);
    }

    /**
     * 归约
     */
    @Test
    public void test_10() {

        System.out.println("=======>>元素求和:");

        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        //一般写法
        System.out.println("------------一般写法-----------");
        Integer reduce1 = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(reduce1);
        //lambda表达式写法
        System.out.println("------------lambda表达式写法-----------");
        Integer reduce2 = numbers.stream().reduce(0, Integer::sum);
        System.out.println(reduce2);
        //使用reduce无初始值的写法,返回optional
        System.out.println("------------使用reduce无初始值的写法,返回optional-----------");
        Optional<Integer> reduce3 = numbers.stream().reduce((a, b) -> a + b);
        reduce3.ifPresent(System.out::println);


        System.out.println("=======>>最大值最小值:");
        System.out.println("------------求最大值");
        Optional<Integer> reduce4 = numbers.stream().reduce(Integer::max);
        reduce4.ifPresent(System.out::println);


        System.out.println("计算流中有多少个菜");
        List<Dish> menu = getDishList();
        menu.stream().map(x -> 1).reduce(Integer::sum).ifPresent(System.out::println);

    }

    /**
     * 练习
     */
    @Test
    public void test_11() {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
                                                        new Transaction(raoul, 2012, 1000),
                                                        new Transaction(raoul, 2011, 400),
                                                        new Transaction(mario, 2012, 710),
                                                        new Transaction(mario, 2012, 700),
                                                        new Transaction(alan, 2012, 950));

        //找出2011年发生的所有交易，并按交易额排序
        final List<Transaction> collect1 = transactions.stream().filter(y -> y.getYear() == 2011).sorted(comparing(Transaction::getValue)).collect(Collectors.toList());
        System.out.println(collect1);
        //交易员都在那些不同的城市工作过
        final List<String> collect2 = transactions.stream().map(a -> a.getTrader().getCity()).distinct().collect(Collectors.toList());
        System.out.println(collect2);
        Set<String> collect = transactions.stream().map(a -> a.getTrader().getCity()).collect(Collectors.toSet());
        System.out.println(collect);
        /**
         * 会有重复，需要使用distinct排重
         */
        //查找所有来自于剑桥的交易员，并按姓名排序
        //会有重复，需要使用distinct排重
        final List<String> collect3 = transactions.stream().filter(a -> "Cambridge".equals(a.getTrader().getCity())).map(a -> a.getTrader().getName()).distinct().sorted(String::compareTo).collect(Collectors.toList());
        System.out.println(collect3);
        //返回所有交易员的姓名字符串，按字母顺序排序
        final List<String> collect4 = transactions.stream().map(a -> a.getTrader().getName()).distinct().sorted(String::compareTo).collect(Collectors.toList());
        System.out.println(collect4);

        System.out.println("======");
        String reduce1 = transactions.stream().map(a -> a.getTrader().getName()).distinct().sorted().reduce("", (a, b) -> a + b);
        System.out.println(reduce1);


        //有没有交易员是在米兰工作的
        boolean b = transactions.stream().anyMatch(a -> "Milan".equals(a.getTrader().getCity()));
        System.out.println(b);
        //打印生活在剑桥的交易员的所有交易额
        System.out.println("===打印生活在剑桥的交易员的所有交易额===");
        transactions.stream().filter(a -> "Cambridge".equals(a.getTrader().getCity())).map(Transaction::getValue).forEach(System.out::println);
        //所有交易中，最高的交易额是多少
        System.out.println("====所有交易中，最高的交易额是多少===");
        Optional<Integer> max = transactions.stream().map(Transaction::getValue).max(comparing(Integer::intValue));
        max.ifPresent(System.out::println);
        //找到交易额最小的交易
        System.out.println("====找到交易额最小的交易===");
        Optional<Integer> min = transactions.stream().map(Transaction::getValue).min(comparing(Integer::intValue));
        min.ifPresent(System.out::println);

    }

    /**
     * 数值流，使用基本数据类型,节省内存空间，提高效率
     */
    @Test
    public void test_12() {
        List<Dish> menu = getDishList();
        //映射到数值流
        int sum = menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println(sum);
        //转换灰对象流
        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> boxed = intStream.boxed();
        //默认值OptionalInt IntStream默认值为0，如果要计算IntStream中的最大元素，无法区分0是最大值还是0
        OptionalInt max = menu.stream().mapToInt(Dish::getCalories).max();
        max.ifPresent(System.out::println);

    }


    /**
     * 数值范围
     */
    @Test
    public void test_13() {
        //前闭后开区间
        System.out.println(IntStream.range(1,100).filter(a -> a%2==0).count());
        //前闭后闭区间
        System.out.println(IntStream.rangeClosed(1,100).filter(a -> a%2==0).count());
    }

    /**
     * 数值流应用 ： 勾股数
     */
    @Test
    public void test_14() {

        Stream<int[]> stream = IntStream.rangeClosed(1, 100).boxed()
            .flatMap(a -> IntStream.rangeClosed(a, 100).filter(b -> Math.sqrt(a * a + b * b) % 1 == 0).mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));
        stream.limit(5).forEach(t -> System.out.println(t[0]+","+t[1]+","+t[2]));

    }

    /**
     * 构建流
     */
    @Test
    public void test_15() {

        /**
         * 由值创建流
         */
        System.out.println("====由值创建流======");
        Stream<String> stringStream = Stream.of("Java8 ", "Lambdas ", "In ", "Action");
        stringStream.map(String::toUpperCase).forEach(System.out::println);
        /**
         * 由数组创建流
         */
        System.out.println("====由数组创建流======");
        int[] numbers = {2,3,5,7,11,13};
        int sum = Arrays.stream(numbers).sum();
        System.out.println(sum);

        /**
         * 由文件生成流
         */
        System.out.println("====由文件生成流======");
        long uniqueWords = 0;
        try(Stream<String>lines = Files.lines(Paths.get("/Users/lixiangyu/work/restartItem.sh"), Charset.defaultCharset())) {

            uniqueWords = lines.flatMap(a -> Arrays.stream(a.split(" "))).distinct().count();
            System.out.println(uniqueWords);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * 由函数生成流
         */
        System.out.println("====由函数生成流======");
        Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);
        System.out.println("斐波那契数列");
        Stream.iterate(new int[]{0,1}, t -> new int[]{t[1], t[0] + t[1]}).map(t -> t[0]).limit(10).forEach(System.out::println);
        System.out.println("====生成generate=====");
        Stream.generate(Math::random).limit(5).forEach(System.out::println);

    }



    public static List<Dish> getDishList() {

        return Arrays.asList(new Dish("pork", false,  800, Dish.Type.MEAT),
                             new Dish("beef", false,  700, Dish.Type.MEAT),
                             new Dish("chicken", false,  400, Dish.Type.MEAT),
                             new Dish("french fries", true,  530, Dish.Type.OTHER),
                             new Dish("rice", true,  350, Dish.Type.OTHER),
                             new Dish("season fruit", true,  120, Dish.Type.OTHER),
                             new Dish("pizza", true,  550, Dish.Type.OTHER),
                             new Dish("prawns", false,  300, Dish.Type.FISH),
                             new Dish("salmon", false,  450, Dish.Type.FISH)    );

    }

}
