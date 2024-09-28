package com.xiwai.algorithm.sept.sept26;

public class num24 {
}

class Solution24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode temp = dummy;
        ListNode firstNode = new ListNode();
        ListNode secondNode = new ListNode();
        while (temp.next != null && temp.next.next != null) {
            firstNode = temp.next;
            secondNode = temp.next.next;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            temp.next = secondNode;
            temp = firstNode;
        }
        return head;
    }
}