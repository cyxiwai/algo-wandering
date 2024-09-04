package com.xiwai.algorithm.sept.sept3;

import java.util.List;

public class num92 {
}


class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode preL = head;
        ListNode pastR = head;
        ListNode Left = head;
        ListNode Right = head;
        while (--left > 1) {
            preL = preL.next;
        }
        Left = preL.next;
        while (right-- > 1) {
            Right = Right.next;
        }
        pastR = Right.next;
        Right.next = null;
        preL.next = reverseSingle(Left);
        while (preL.next != null) {
            preL = preL.next;
        }
        preL.next = pastR;
        return head;
    }

    public ListNode reverseSingle(ListNode head) {
        ListNode temp = new ListNode();
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}