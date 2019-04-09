package com.lixiangyu.lee.solution;

/**
 * @program: leecode
 * @description: Container With Most Water
 * @author: lixiangyu
 * @create: 2019-03-29 14:32
 **/
public class Solution_11 {


    public static int maxArea(int[] height) {

        if(null == height || height.length == 0 || height.length == 1) {
            return 0;
        }
        int maxnum = 0;
        for (int i = 0; i < height.length-1; i++) {
            for (int j = i+1; j < height.length; j++) {
                if(height[i] >= height[j]) {
                    int curnum = (j - i) * height[j];
                    if(curnum > maxnum) {
                        maxnum = curnum;
                    }
                } else {
                    int curnum = (j - i) * height[i];
                    if(curnum > maxnum) {
                        maxnum = curnum;
                    }
                }
            }
        }

        return maxnum;

    }


    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

}
