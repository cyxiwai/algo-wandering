package com.xiwai.algorithm.sept.sept26;

public class num19 {
}

class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode();
        ListNode pre = null;
        ListNode cur = head;
        while (n-- > 0) {
            cur = cur.next;
        }
        temp = head;
        while (cur != null) {
            cur = cur.next;
            pre = temp;
            temp = temp.next;
        }
        if (temp == head) {
            return temp.next;
        } else {
            pre.next = temp.next;
            return head;
        }
    }
}
