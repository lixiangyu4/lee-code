package com.lixiangyu.lee.sort;

import java.util.Arrays;

/**
 * @program: leecode
 * @description: 排序算法
 * @author: lixiangyu
 * @create: 2019-07-03 16:08
 **/
public class AllSortTest {

    /**
     * 冒泡排序
     * @param array
     */
    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            boolean swapped = false;
            for (int j = 0; j < array.length-1; j++) {
                //这里若改成 >= 则为不稳定排序
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    swapped = true;
                }
            }
            //优化，若内循环没有发生交互，则表示排序完成
            if(!swapped) {
                break;
            }
        }
    }

    /**
     * 插入排序
     * @param array
     */
    private static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i;
            while (j > 0 && array[j - 1] > array[j]) {
                int temp = array[j - 1];
                array[j - 1] = array[j];
                array[j] = temp;
                j--;
            }
        }
    }


    public static void main(String[] args) {
        int[] array = {3,2,1,5,6,2,1,7};
//        bubbleSort(array);
        insertionSort(array);
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
    }

}
