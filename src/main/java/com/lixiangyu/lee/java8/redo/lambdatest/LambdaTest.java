package com.lixiangyu.lee.java8.redo.lambdatest;

import org.junit.Assert;
import org.junit.Test;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-06-01 15:52
 **/
public class LambdaTest {

    @Test
    public void test_01() {

        List<Point> points = Arrays.asList(new Point(5,5), new Point(10, 5));
        List<Point> expectedPoints = Arrays.asList(new Point(15,5), new Point(20, 5));

        List<Point> newPoints = moveAllPointsRightBy(points, 10);
        Assert.assertEquals(expectedPoints, newPoints);


    }

    public static List<Point> moveAllPointsRightBy(List<Point> points, int x) {
        List<Point> collect = points.stream().map(p -> new Point(p.getX() + x, p.getY())).collect(Collectors.toList());
        return collect;
    }

    /**
     * lambda表达式调试
     */
    @Test
    public void test_02() {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);

        List<Integer> collect = numbers.stream()
            .peek(x -> System.out.println("from stream " + x))
            .map(x -> x + 17)
            .peek(x -> System.out.println("after map " + x))
            .filter(x -> x % 2 == 0)
            .peek(x -> System.out.println("after filter " + x))
            .limit(3)
            .peek(x -> System.out.println("after limit " + x))
            .collect(Collectors.toList());



    }

    public final static String MD5(byte[] btInput) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Test
    public void test_03() {

//        String str = "&A1=A&A11=B&A2=miya&A3=001&A4=YWTEST001&A5=001&A6=A&A7=1.5&B1=18020917060019749340010701&B2=134632140529029932&B3=TMZF&B4=1";
//        String key = "nbz9ww27sx4ou6dkr61mf63tth3s6e2d";
//        StringBuilder sb = new StringBuilder();
//        String a = sb.append(str).append("&KEY=").append(key).toString();
//        System.out.println(a);
//        //做MD5并全部转换为大写
//        String sign = MD5(a.getBytes()).toUpperCase();
//        System.out.println(sign);
        Random random = new Random();
        System.out.println(random.nextInt(100));

    }


    @Test
    public void test_04() {
        //{"sign":"79268B2818C45D71BBEC3834CEEC704C","nonce":90,"version":"1.0.0","appId":"1552732170089","timestamp":1560589626683,"appsecret":"updateAppSecret"},
        String str = "appId=1552732170089&nonce=90&timestamp=1560589626683&version=1.0.0&appsecret=updateAppSecret";
        //做MD5并全部转换为大写
        String sign = MD5(str.getBytes()).toUpperCase();
        System.out.println(sign);
    }


}
