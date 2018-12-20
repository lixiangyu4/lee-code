package com.lixiangyu.lee.arithmetic;

/**
 * @program: leecode
 * @description: 二分法排序
 * @author: lixiangyu
 * @create: 2018-12-20 23:06
 **/
public class BinaryOrder {

    private static int rank(int i, int[] a) {

        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(i < a[mid]) {
                hi = mid - 1;
            } else if(i > a[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,8};
        System.out.println(rank(4, a));
    }

}
