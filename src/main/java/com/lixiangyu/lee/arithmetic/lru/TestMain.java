package com.lixiangyu.lee.arithmetic.lru;

import com.alibaba.fastjson.JSON;

/**
 * @author lixiangyu
 * @description
 * @create 2021-04-27 14:54:30
 */
public class TestMain {

    public static void main(String[] args) {
        TestMap linkedHashMap = new TestMap(4, 0.75F);
        linkedHashMap.put("a", "a");
        linkedHashMap.put("b", "b");
        linkedHashMap.put("c", "c");
        linkedHashMap.put("d", "d");
        linkedHashMap.put("e", "e");

        linkedHashMap.get("a");
        linkedHashMap.get("a");
        linkedHashMap.get("e");
        linkedHashMap.get("c");
        linkedHashMap.get("b");

        System.out.println(JSON.toJSONString(linkedHashMap));
    }

}
