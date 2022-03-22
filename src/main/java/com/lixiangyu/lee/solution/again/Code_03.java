package com.lixiangyu.lee.solution.again;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lixiangyu
 * @description
 * @create 2021-04-29 23:42:11
 */
public class Code_03 {

    public static int lengthOfLongestSubstring(String s) {
        if (null == s) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }
        int max = 0;
        //key 是字符   value是字符的位置
        Map<Character,Integer> map = new HashMap<>();
        for (int end = 0 ,start = 0; end < s.length(); end++)  {
            if (map.containsKey(s.charAt(end))) {
                //start是当前重复字符串在前面开始出现时的位置
                start = Math.max(map.get(s.charAt(end)) + 1, start);
            }
            map.put(s.charAt(end), end);
            max = Math.max(max, end - start + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("au"));
    }

}
