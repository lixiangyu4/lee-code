package com.lixiangyu.lee.arithmetic;

/**
 * @program: leecode
 * @description: 二分法排序
 * @author: lixiangyu
 * @create: 2018-12-20 23:06
 **/
public class BinaryOrder {

    /**
     * 二分查找普通实现
     * @param i
     * @param a 有序数组
     * @return
     */
    private static int rank(int[] a, int i) {

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

    /**
     * 二分法查找 递归实现
     * @param a 有序数组
     * @param start
     * @param end
     * @param i
     * @return
     */
    private static int recursion(int[] a, int start, int end, int i) {

        int mid = (start + end) / 2 + start;

        if(a[mid] == i) {
            return mid;
        }

        if(start <= end ) {
            return -1;
        } else if (i > a[mid]) {
            recursion(a, mid+1, end,  i);
        } else if (i < a[mid]) {
            recursion(a, start, mid,  i);
        }
        return -1;

    }

    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,8};
//        System.out.println(rank(a, 4));
        System.out.println(recursion(a, 0, a.length, 4));
    }

}
