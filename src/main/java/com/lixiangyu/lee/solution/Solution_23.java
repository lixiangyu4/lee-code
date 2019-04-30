package com.lixiangyu.lee.solution;

/**
 * @program: leecode
 * @description: Merge k Sorted Lists
 * @author: lixiangyu
 * @create: 2019-04-18 13:57
 **/
public class Solution_23 {


    public static ListNode mergeKLists(ListNode[] lists) {
        if(null == lists || lists.length == 0) {
            return null;
        }
        if(lists.length == 1) {
            return lists[0];
        }

        ListNode head = null;

        for (ListNode list : lists) {
            head = mergeTwoLists(head, list);
        }

        return head;
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null && l2 != null) {
            return l2;
        }
        if(l1 != null && l2 == null) {
            return l1;
        }
        if(l1 == null) {
            return null;
        }

        if(l1.val > l2.val) {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        } else {
            l1.next = mergeTwoLists(l2, l1.next);
            return l1;
        }

    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode head1 = listNode1;
        for (int i = 0; i < 3; i++) {
            listNode1.next = new ListNode(i+2);
            listNode1 = listNode1.next;
        }
        ListNode listNode2 = new ListNode(1);
        ListNode head2 = listNode2;
        for (int i = 0; i < 3; i++) {
            listNode2.next = new ListNode(i+3);
            listNode2 = listNode2.next;
        }
        ListNode listNode3 = new ListNode(1);
        ListNode head3 = listNode3;
        for (int i = 0; i < 2; i++) {
            listNode3.next = new ListNode(i+2);
            listNode3 = listNode3.next;
        }
        ListNode[] node = {head1, head2, head3};
//        ListNode[] node = {null, new ListNode(1)};
//        System.out.println(Arrays.toString(node));
        System.out.println(mergeKLists(node));
    }

    public static class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
        }
    }

}
