package com.xiwai.algorithm.augu27;

public class num160 {
    public static void main(String[] args) {
        Solution160 solution160 = new Solution160();
        ListNode intersection = new ListNode(8);
        intersection.next = new ListNode(4);
        intersection.next.next = new ListNode(5);

        // 创建第一个链表 4 -> 1 -> 8 -> 4 -> 5
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = intersection;  // 接上相交部分

        // 创建第二个链表 5 -> 6 -> 1 -> 8 -> 4 -> 5
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = intersection;  // 接上相交部分
        solution160.getIntersectionNode(headA, headB);
    }
}

class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        int flag = 0;
        while (tempA != null && tempB != null) {
            tempA = tempA.next;
            tempB = tempB.next;
        }
        if (tempA == null) {
            tempA = headB;
            while (tempB != null) {
                tempB = tempB.next;
                tempA = tempA.next;
            }
            tempB = headA;
        }
        if (tempB == null) {
            tempB = headA;
            while (tempA != null) {
                tempA = tempA.next;
                tempB = tempB.next;
            }
            tempA = headB;
        }
        while (tempA != null) {
            if (tempA == tempB) {
                break;
            }
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return tempA;

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(){

    }
    ListNode(int x) {
        val = x;
        next = null;
    }
}