package com.xiwai.algorithm.augu25;

public class num2 {
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = null;
        ListNode temp = null;
        ans.next = temp;
        int count = 0;
        while (l1.next != null && l2.next != null) {
            int sum = l1.val + l2.val;
            if (sum < 10) {
                temp.next = new ListNode(sum + count);
                temp = temp.next;
                count = 0;
            } else {
                temp.next = new ListNode(sum - 10);
                count++;
            }
        }
        return ans;
    }
}