package com.lixiangyu.lee.solution;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-03-20 17:18
 **/
public class Solution_7 {

    public int reverse(int x) {
        int result=0, pre = 0;
        while (x != 0) {
            pre = result;
            result = result * 10 + x % 10;
            if(result / 10 != pre) {
                return 0;
            }
            x = x / 10;
        }
        return result;
    }


    public static void main(String[] args) {
        Solution_7 solution_7 = new Solution_7();
        System.out.println(solution_7.reverse(123));
    }

}
