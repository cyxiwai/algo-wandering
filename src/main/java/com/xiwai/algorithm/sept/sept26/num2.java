package com.xiwai.algorithm.sept.sept26;

import java.util.ArrayList;
import java.util.List;

public class num2 {
}

class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 2;
            int sum = a + b + carry;
            carry = sum >= 10 ? 1 : 0;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return dummy.next;
    }
}
