package com.lixiangyu.lee.fastutil;

import it.unimi.dsi.fastutil.ints.Int2BooleanArrayMap;
import it.unimi.dsi.fastutil.ints.Int2BooleanMap;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntBigArrayBigList;
import it.unimi.dsi.fastutil.ints.IntBigList;
import it.unimi.dsi.fastutil.ints.IntLinkedOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntList;
import it.unimi.dsi.fastutil.ints.IntListIterator;
import it.unimi.dsi.fastutil.ints.IntSortedSet;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-04-30 10:41
 **/
public class Test_01 {


    public static void main(String[] args) {
        //===========IntList
        IntList list = new IntArrayList();

        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }

        //取值
        int value = list.getInt(0);
        System.out.println(value);// 0

        //转成数组
        int[] values = list.toIntArray();
        System.out.println(values.length);// 1000

        //遍历
        IntListIterator i = list.iterator();
        while (i.hasNext()) {
            System.out.println(i.nextInt());
        }

        //===========Int2BooleanMap
        Int2BooleanMap map = new Int2BooleanArrayMap();

        map.put(1, true);
        map.put(2, false);

        //取值
        boolean value1 = map.get(1);
        boolean value2 = map.get(2);

        System.out.println(value1);// true
        System.out.println(value2);// false

        //===========IntBigList
        IntBigList biglist = new IntBigArrayBigList();

        biglist.add(0);
        biglist.add(1);
        biglist.add(2);

        long size = biglist.size64();

        //取值
        for (long index = 0; index < size; index++) {
            System.out.println(biglist.getInt(index));
        }

        //===========IntSortedSet
        IntSortedSet s = new IntLinkedOpenHashSet(new int[]{4, 3, 2, 1});
        //获取第一个元素
        System.out.println(s.firstInt()); // 4
        //获取最后一个元素
        System.out.println(s.lastInt()); // 1
        //判断是否包含一个元素
        System.out.println(s.contains(5)); // false
    }

}
