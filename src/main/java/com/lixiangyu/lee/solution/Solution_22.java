package com.lixiangyu.lee.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leecode
 * @description: Generate Parentheses
 * @author: lixiangyu
 * @create: 2019-04-18 10:28
 **/
public class Solution_22 {

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        build(list, "", n, n);
        return list;
    }

    public static void build(List<String> list, String current, int left, int right) {
        if(left > right) {
            return;
        }

        if(left == 0 && right == 0) {
            list.add(current);
            return ;
        }

        if(left > 0) {
            build(list, current+"(", left-1, right);
        }
        if(right > 0) {
            build(list, current+")", left, right-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }

}
