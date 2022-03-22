package com.lixiangyu.lee.solution.book;

/**
 * @author lixiangyu
 * @description 搜索二维矩阵
 * @create 2021-05-02 22:13:50
 */
public class Subject_03 {

    public static boolean searchMatrix(int[][] matrix, int target) {

        //行
        int row = matrix.length - 1;
        //列
        int col = 0;

        //从左下角开始查找
        while (row >=0 &&  col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(searchMatrix(nums, 20));
    }

}
