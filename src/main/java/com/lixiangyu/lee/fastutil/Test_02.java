package com.lixiangyu.lee.fastutil;

import it.unimi.dsi.fastutil.longs.Long2IntAVLTreeMap;
import it.unimi.dsi.fastutil.longs.Long2IntSortedMap;
import it.unimi.dsi.fastutil.longs.LongBidirectionalIterator;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-04-30 10:45
 **/
public class Test_02 {


    public static void main(String[] args) {
        Long2IntSortedMap m = new Long2IntAVLTreeMap();

        m.put(1, 5);
        m.put(2, 6);
        m.put(3, 7);
        m.put(1000000000L, 10);

        System.out.println(m.get(1)); // 5

//当查找不到的时候，默认返回0
        System.out.println(m.get(4)); // 0

//设置默认返回值
        m.defaultReturnValue(-1);
        System.out.println(m.get(4)); // -1

//遍历Map
        LongBidirectionalIterator key1 = m.keySet().iterator();
        long s = 0;
        while (key1.hasNext()) {
            s += key1.nextLong();
        }
        System.out.println(s); // 1000000006

//获取Key值小于4的子Map
        Long2IntSortedMap m1 = m.headMap(4);
        LongBidirectionalIterator key2 = m1.keySet().iterator();
        while (key2.hasNext()) {
            System.out.println(key2.nextLong());
        }
    }


}
