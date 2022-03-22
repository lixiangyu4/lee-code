package com.lixiangyu.lee.solution.again;

/**
 * @author lixiangyu
 * @description
 * @create 2021-04-29 23:22:33
 */
public class Code_02 {


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list = new ListNode(0);
        ListNode head = list;

        int sum = 0;
        while (l1 !=  null || l2 != null || sum != 0) {
            if (l1 != null) {
                sum = sum + l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum = sum + l2.val;
                l2 =  l2.next;
            }
            list.next = new ListNode(sum % 10);
            sum = sum / 10;
            list = list.next;
        }

        return head.next;

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


}
