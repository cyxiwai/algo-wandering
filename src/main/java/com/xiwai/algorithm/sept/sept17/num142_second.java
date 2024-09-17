package com.xiwai.algorithm.sept.sept17;

public class num142_second {
}

//【游蛙泳前热身动作，避免抽筋-哔哩哔哩】 https://b23.tv/x43nh5B
class Solution142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode index1 = head;
                ListNode index2 = fast;
                while (index2 != index1) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
