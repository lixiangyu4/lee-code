package com.lixiangyu.lee.arithmetic.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author lixiangyu
 * @description
 * @create 2021-04-27 11:43:12
 */
public class TestMap extends LinkedHashMap<String, String> {

    private int max_size = 4;


    public TestMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor, true);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
        return size() > max_size;
    }

}
