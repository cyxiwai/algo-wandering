package com.xiwai.algorithm.augu25;

import java.util.HashSet;
import java.util.Set;

public class num141_need {
}


class Solution141 {
    public boolean hasCycle(ListNode head) {
        boolean ans = false;
        if (head.next == null) {
            return ans;
        }
        Set<ListNode> set = new HashSet<>();
        ListNode temp = head;
        while (true) {
            if (set.contains(temp)) {
                ans = true;
                break;
            }
            if (temp.next == null) {
                break;
            }
            set.add(temp);
            temp = temp.next;
        }
        return ans;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}