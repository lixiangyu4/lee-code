package com.lixiangyu.lee.solution;

/**
 * @program: leecode
 * @description: Merge Two Sorted Lists
 * @author: lixiangyu
 * @create: 2019-04-12 18:38
 **/
public class Solution_21 {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null && l2 != null) {
            return l2;
        }
        if(l1 != null && l2 == null) {
            return l1;
        }
        if(l1 == null) {
            return null;
        }

        ListNode head = null;
        ListNode current = null;

        if(l1.val > l2.val) {
            head = l2;
            current = head;
            l2 = l2.next;
        } else {
            head = l1;
            current = head;
            l1 = l1.next;
        }

        while (l1 != null && l2 != null) {
            if(l1.val > l2.val) {
                current.next = l2;
                l2 = l2.next;
            } else {
                current.next = l1;
                l1 = l1.next;
            }
            current = current.next;
        }

        while (l1 != null) {
            current.next = l1;
            current = current.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            current.next = l2;
            current = current.next;
            l2 = l2.next;
        }


        return head;

    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(0);
        ListNode head1 = listNode1;
        ListNode listNode2 = new ListNode(0);
        ListNode head2 = listNode2;
        int size = 3;
        for (int i = 0; i < size; i++){
            listNode1.val = i+1;
            if(i != size-1) {
                ListNode node = new ListNode(0);
                listNode1.next = node;
            }
            listNode1 = listNode1.next;
        }
        for (int i = 0; i < size; i++){
            listNode2.val = i+1;
            if(i != size-1) {
                ListNode node = new ListNode(0);
                listNode2.next = node;
            }
            listNode2 = listNode2.next;
        }
        System.out.println(mergeTwoLists(head1, head2));
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
