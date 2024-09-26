package com.xiwai.algorithm.sept.sept26;

public class num234 {
    public static void main(String[] args) {
        Solution234 s = new Solution234();
        ListNode test1 = new ListNode(1);
        ListNode test2 = new ListNode(1);
        ListNode test3 = new ListNode(2);
        ListNode test4 = new ListNode(1);
        test1.next = test2;
        test2.next = test3;
        test3.next = test4;
        System.out.println(s.isPalindrome(test1));
    }
}

class Solution234 {
    public boolean isPalindrome(ListNode head) {
        ListNode copiedHead = copyList(head);  // 复制链表
        ListNode reversedCopy = reverse(copiedHead);  // 反转复制的链表

        while (head != null) {
            if (head.val != reversedCopy.val) {
                return false;
            }
            head = head.next;
            reversedCopy = reversedCopy.next;
        }
        return true;
    }

    // 复制链表
    public ListNode copyList(ListNode head) {
        if (head == null) return null;
        ListNode newHead = new ListNode(head.val);
        ListNode current = newHead;
        while (head.next != null) {
            head = head.next;
            current.next = new ListNode(head.val);
            current = current.next;
        }
        return newHead;
    }

    // 反转链表
    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
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

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}