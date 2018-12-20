package com.lixiangyu.lee.java8.base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2018-11-08 14:31
 **/
public class Java8Test1 {

    public static void main(String[] args) {
        String s = Base64.getMimeEncoder().encodeToString("aaaadasdwferferfe".getBytes());
        System.out.println(s);
        try (FileInputStream inputStream = new FileInputStream(new File("test"))) {
            System.out.println(inputStream.read());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

}
