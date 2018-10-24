package com.lixiangyu.lee.solution2;

/**
 * @program: leecode
 * @description: Add Two Numbers
 * @author: lixiangyu
 * @create: 2018-10-22 17:56
 **/
public class Solution_2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode list = new ListNode(0);
        ListNode head = list;
        int sum = 0;
        while (l1 != null || l2 != null || sum != 0) {

            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            list.next = new ListNode(sum % 10);
            sum = sum / 10;
            list = list.next;

        }

        return head.next;


    }

    public static void main(String[] args) {
    }


}
