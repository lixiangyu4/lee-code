package com.lixiangyu.lee.solution;

/**
 * @program: leecode
 * @description: Remove Nth Node From End of List
 * @author: lixiangyu
 * @create: 2019-04-12 14:58
 **/
public class Solution_19 {

    /**
     * 先求出链表长度，然后计算出正向查找时的位置，进行删除后返回
     * eg: list: 1->2->3->4->5, and n = 2.
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        int size = 1;
        while (node.next != null) {
            node = node.next;
            size++;
        }
        if(size == 1 && n == 1) {
            return null;
        }
        //如果移出的是头结点
        if (n == size) {
            return head.next;
            //如果移出的是尾节点
        } else if (n == 1) {
            ListNode listNode = new ListNode(0);
            ListNode tempHead = listNode;
            for (int i = 0; i < size - 1; i++) {
                listNode.val = head.val;
                if(i != size - 2) {
                    listNode.next = new ListNode(0);
                }
                listNode = listNode.next;
                head = head.next;
            }
            return tempHead;
            //如果移出的是中间节点
        } else {
            ListNode listNode = new ListNode(0);
            ListNode tempHead = listNode;
            for (int i = 0; i < size; i++) {
                if(i == size - n) {
                    listNode.val = head.next.val;
                    head = head.next;
                    i++;
                } else {
                    listNode.val = head.val;
                }
                //最后一个节点不能默认为0，应该为空，加此判断
                if(i != size - 1) {
                    listNode.next = new ListNode(0);
                }
                listNode = listNode.next;
                head = head.next;
            }
            return tempHead;
        }

    }

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        ListNode head = node;
        int size = 2;
        for (int i = 0; i < size; i++) {
            node.val = i+1;
            if(i != size-1) {
                node.next = new ListNode(0);
                node = node.next;
            }
        }
        ListNode listNode = removeNthFromEnd(head, 1);
        System.out.println(listNode.toString());
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


