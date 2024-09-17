package com.xiwai.algorithm.sept.sept13;

import java.util.List;

public class num203_second {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.removeElements(new ListNode(1), 1);
    }
}


class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode temp = dummy;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;//持续操作后一个节点，否则会有访问null.next问题
            } else {
                temp = temp.next;
            }
        }

        return dummy.next;
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