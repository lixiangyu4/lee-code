package com.lixiangyu.lee.arithmetic.reverseList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author lixiangyu
 * @description 反转链表
 * @create 2021-03-15 20:26:22
 */
public class ReverseList {

    public static void main(String[] args) {
        Node nodeList = initNodeList(6);
//        reverseList1(nodeList, 0, 3);
        Node node = reverseList2(nodeList);
        print(node);
    }



    /**
     * 遍历反转
     * 从m开始反转n位
     * @param head
     */
    private static void reverseList1(Node head, int m, int n) {
        if (head == null) {
            return;
        }
        int num = 0;
        Node startNode = head;
        Node pre = null;
        while (num != m) {
            pre = startNode;
            startNode = startNode.getNext();
            num+=1;
        }

        Node cur = startNode;
        Node preNode = null;
        int j = 0;
        while (j < n) {
            Node nextNode = cur.getNext();

            cur.setNext(preNode);
            preNode = cur;
            cur = nextNode;
            j+=1;
        }

        if (pre != null) {
            pre.setNext(preNode);
        } else {
            head = preNode;
        }
        print(head);
    }


    /**
     * 递归反转
     * 从m开始反转n位
     * @param head
     */
    private static void reverseList2(Node head, int m, int n) {
        if (head == null) {
            return;
        }
        int num = 0;
        Node startNode = head;
        while (num != m) {
            startNode = head.getNext();
            num+=1;
        }

    }

    private static Node reverseList2(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        Node reHead = reverseList2(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return reHead;
    }

    private static void print(Node head) {
        Node node = head;
        while (node != null) {
            System.out.print(node.getValue());
            System.out.print(",");
            node = node.getNext();
        }
    }


    private static Node initNodeList(int initNum) {
        Node head = null;
        Node last = null;
        for (int i = 0; i< initNum; i++) {
            if (last == null) {
                last = Node.builder().value(i).build();
            } else {
                last.setNext(Node.builder().value(i).build());
                last = last.getNext();
            }
            if (i == 0) {
                head = last;
            }
        }
        return head;
    }


    @Data
    @Builder
    @AllArgsConstructor
    public static class Node {
        private int value;
        private Node next;
    }

}
