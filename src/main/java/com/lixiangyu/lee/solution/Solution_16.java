package com.lixiangyu.lee.solution;

import java.util.Arrays;

/**
 * @program: leecode
 * @description: 3Sum Closest
 * @author: lixiangyu
 * @create: 2019-04-10 16:14
 **/
public class Solution_16 {


    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        if(nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        int result = nums[0] + nums[1] + nums[nums.length-1];

        for (int i = 0; i < nums.length - 2; i++) {
            int lo = i + 1, hi = nums.length -1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if(sum == target){
                    return sum;
                } else if(sum > target) {
                    while (lo < hi && nums[hi] == nums[hi - 1]) {
                        hi--;
                    }
                    hi--;
                } else if(sum < target) {
                    while(lo < hi && nums[lo] == nums[lo + 1]) {
                        lo++;
                    }
                    lo++;
                }
                if (Math.abs(result - target) > Math.abs(sum - target)) {
                    result = sum;
                }
            }
        }
        return result;


    }

    public static void main(String[] args) {
        int [] nums = {1,1,1,1};
        int target = 3;
        System.out.println(threeSumClosest(nums, target));
    }

}
