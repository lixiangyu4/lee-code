package com.lixiangyu.lee.solution.book;

/**
 * @author lixiangyu
 * @description 多数元素
 * @create 2021-05-02 20:57:48
 */
public class Subject_02 {

    /**
     *  不相同的相互抵消掉，最后多出来的，就是
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int result =  nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                //前面都消完了，在重新赋值
                result = nums[i];
                count++;
            }
            if (result == nums[i]) {
                //自己人，count就加1
                count++;
            } else {
                //不是自己人就同归于尽，消掉一个
                count--;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] a = new int[]{-1,-1,2147483647};
        System.out.println(majorityElement(a));
    }

}
