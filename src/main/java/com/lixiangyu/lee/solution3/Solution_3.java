package com.lixiangyu.lee.solution3;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leecode
 * @description: Longest Substring Without Repeating Characters
 * @author: lixiangyu
 * @create: 2018-10-24 20:21
 **/
public class Solution_3 {

    public int lengthOfLongestSubstring(String s) {

        if(s.length() == 0){
            return 0;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>(8);
        int max = 0;
        for (int i=0,j=0; i < s.length() ; i++) {
            if(map.containsKey(s.charAt(i))) {
                /**
                 * 此处不用j = map.get(s.charAt(i)) + 1; 是因为当s=abba时，i=3时 ，
                 * s.charAt(i)取到的位置是第一个a的位置，故需要求与j的最大值
                 */
                j = Math.max(j, s.charAt(i) + 1);
            }
            map.put(s.charAt(i), i);  
            max = Math.max(max, i-j+1);
        }
        return max;

    }

    public static void main(String[] args) {
        Solution_3 solution_3 = new Solution_3();
        System.out.println(solution_3.lengthOfLongestSubstring("abba"));
    }

}
