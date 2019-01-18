package com.lixiangyu.lee.java8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2018-12-29 14:12
 **/
public class Main {

    private  static List<File> fileList = new ArrayList<>();

    private static void test(String dir) throws IOException {
        File file = new File(dir);
        File[] files = file.listFiles();

        if (files == null) {// 如果目录为空，直接退出
            return;
        }
        // 遍历，目录下的所有文件
        for (File f : files) {
            if (f.isFile()) {
                fileList.add(f);
            } else if (f.isDirectory()) {
                System.out.println(f.getAbsolutePath());
                test(f.getAbsolutePath());
            }
        }

    }

    public static void main(String[] args) throws IOException {
        test("E:\\NWP\\property");
        StringBuilder sb = new StringBuilder();
        File file = new File("E:\\NWP\\sb.txt");
        FileWriter fileWritter = new FileWriter(file.getName(),true);
        fileWritter.write(sb.toString());
        fileWritter.close();
        for (File f1 : fileList) {
            if(f1.getName().endsWith("php")) {
                InputStream inputStream = new FileInputStream(f1);
                byte[] b = new byte[1024];
                int i = 0;
                while ((i = inputStream.read(b)) != -1) {
                    sb.append(new String(b, "utf-8"));
                }
                System.out.println(new String(b, "GBK"));
            }
        }
    }

}
