package com.xiwai.algorithm.sept.sept26;

public class num21 {
}

class Solution21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode();
        ListNode temp = ans;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp.next = list1;
                temp = temp.next;
                list1 = list1.next;
            } else {
                temp.next = list2;
                temp = temp.next;
                list2 = list2.next;
            }
        }
        if (list1 == null) {
            temp.next = list2;
        }
        if (list2 == null) {
            temp.next = list1;
        }
        return ans.next;
    }
}
