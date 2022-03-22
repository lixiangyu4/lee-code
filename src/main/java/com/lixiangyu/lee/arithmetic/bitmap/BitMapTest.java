package com.lixiangyu.lee.arithmetic.bitmap;

/**
 * @author lixiangyu
 * @description
 * @create 2021-03-23 19:55:27
 */
public class BitMapTest {


    /**
     * num为bitmap需要保存数据的数量，如10亿
     * @param num
     * @return
     */
    private byte[] create(int num) {
//        BitMap
        byte[] bits = new byte[getIndex(num) + 1];
        return bits;
    }

    /**
     * 计算数字在byte[]中的位置
     * @param num
     * @return
     */
    private int getIndex(int num) {
        return num >> 3;
    }

    /**
     * 获取num在byte[index]中的位置(一个byte有8位)
     * @param num
     * @return
     */
    private int getPosition(int num) {
        return num % 8;
    }

    /**
     * 把num保存到byte数组中
     * @param bits
     * @param num
     */
    private void add(byte[] bits, int num) {
        bits[getIndex(num) + 1] |= 1 << getPosition(num);
    }







}
