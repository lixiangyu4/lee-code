package com.lixiangyu.lee.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leecode
 * @description: VM Args : -XX:PermSize=10M -XX:MaxPermSize=10M jdk7 jdk8已移除
 * @author: lixiangyu
 * @create: 2019-02-12 14:31
 **/
public class RuntimeConstantPoolOOM1 {

    public static void main(String[] args) {
        List<String> list  = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }

}
