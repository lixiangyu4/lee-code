package com.lixiangyu.lee.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: leecode
 * @description: Valid Parentheses
 * @author: lixiangyu
 * @create: 2019-04-12 16:00
 **/
public class Solution_20 {

    /**
     * 情况1：()[]{}
     * 情况2：{[]}
     * 情况3：(([]){})
     * @param s
     * @return
     */
    public static boolean isValid(String s) {

        List<Character> left = new ArrayList<>();
        List<Character> right = new ArrayList<>();
        left.add('(');
        left.add('{');
        left.add('[');
        right.add(')');
        right.add('}');
        right.add(']');

        int size = s.length();
        if(size%2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < size; i++) {
            char c = s.charAt(i);
            if(stack.isEmpty()) {
                stack.push(c);
            } else {
                int position = left.indexOf(c);
                //能在left中找到
                if(position != -1) {
                    stack.push(c);
                } else {
                    int rightPosition = right.indexOf(c);
                    if (stack.peek().equals(left.get(rightPosition))) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }

            }

        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        char[] characters = {'(', ')', '{', '}', '[', ']'};
        System.out.println(isValid("()[]{}"));
    }

}
