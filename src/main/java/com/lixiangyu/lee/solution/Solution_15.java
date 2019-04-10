package com.lixiangyu.lee.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leecode
 * @description: 3Sum
 * @author: lixiangyu
 * @create: 2019-04-09 18:30
 **/
public class Solution_15 {

    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])){
                int lo = i + 1, hi = nums.length -1 , sum = -nums[i];
                while (lo < hi) {
                    if(nums[lo] + nums[hi] == sum) {
                        resultList.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[hi] == nums[hi - 1]) {
                            hi--;
                        }
                        while (lo < hi && nums[lo] == nums[lo + 1]) {
                            lo++;
                        }
                        lo++;
                        hi--;
                    } else if(nums[lo] + nums[hi] < sum) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }

        }
        return resultList;

    }


    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums).toString());
    }

}
