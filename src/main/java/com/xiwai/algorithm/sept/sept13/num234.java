package com.xiwai.algorithm.sept.sept13;

public class num234 {
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution234 {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }
        ListNode slowIndex = head;
        ListNode fastIndex = head;
        ListNode pre = new ListNode();
        pre.next = slowIndex;
        while (fastIndex.next.next != null) {
            ListNode temp = slowIndex.next;
            slowIndex.next = pre;
            pre = slowIndex;
            slowIndex = temp;
            fastIndex = fastIndex.next.next;
        }
        while (slowIndex != null) {
            if (head.val != slowIndex.val) {
                return false;
            }
            head = head.next;
            slowIndex = slowIndex.next;
        }
        return true;
    }
}