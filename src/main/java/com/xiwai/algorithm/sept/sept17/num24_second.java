package com.xiwai.algorithm.sept.sept17;

public class num24_second {
}

class Solution24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode cur = dummyNode;
        ListNode temp = new ListNode();
        ListNode first = new ListNode();
        ListNode second = new ListNode();
        while (cur.next != null && cur.next.next != null) {
            temp = cur.next.next.next;
            first = cur.next;
            second = cur.next.next;
            cur.next = second;
            second.next = first;
            first.next = temp;
            cur = first;
        }
        return dummyNode.next;
    }
}