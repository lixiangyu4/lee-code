package com.lixiangyu.lee.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leecode
 * @description: 4Sum
 * @author: lixiangyu
 * @create: 2019-04-11 14:53
 **/
public class Solution_18 {


    public static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        if(length < 4) {
            return result;
        }
        if(nums[0] * 4 > target || nums[length] * 4 < target) {
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            int sum = target-nums[i];
            if(nums.length - (i+1) >= 3 && (i==0 || (i>0 && nums[i] != nums[i-1]))) {
                List<List<Integer>> lists = threeSum(Arrays.copyOfRange(nums, i + 1, nums.length), sum);
                for (List<Integer> l : lists) {
                    List<Integer> tempList = new ArrayList<>(l);
                    tempList.add(0, nums[i]);
                    result.add(tempList);
                }
            }

        }

        return result;
    }

    private static List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) {
            int lo = i+1, hi = nums.length - 1, sum = target-nums[i];
            if(i == 0 || (i>0 && nums[i] != nums[i-1])) {
                while (lo < hi) {
                    if ((nums[lo] + nums[hi]) == sum) {
                        result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && (nums[lo] == nums[lo+1])) {
                            lo++;
                        }
                        while (lo < hi && (nums[hi] == nums[hi-1])) {
                            hi--;
                        }
                        lo++;
                        hi--;
                    } else if((nums[lo] + nums[hi]) > sum) {
                        hi--;
                    } else {
                        lo++;
                    }
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-3,-2,-1,0,0,1,2,3};
        int target = 0;
        System.out.println(fourSum(nums, target).toString());
    }

}
