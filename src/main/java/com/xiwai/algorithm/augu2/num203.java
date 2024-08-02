package com.xiwai.algorithm.augu2;

import java.util.Scanner;

import static java.sql.JDBCType.NULL;

public class num203 {
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode current = head;
        if(current ==null)
        {
            return head;
        }
        while(current.next!=null)
        {
            ListNode temp =current.next;

            if(temp.val == val)
            {
                current.next=temp.next;
            }
            else
                current=current.next;
        }
        if(head.val==val)
        {
            head=head.next;
        }
        return head;
    }
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

//千万别踩坑里，一定要设置临时变量，否则丢头了！！！
//
//
//class Solution {
//    public ListNode removeElements(ListNode head, int val) {
//        // ListNode current = head;
//        ListNode dummyNode = new ListNode();
//        dummyNode.next = head;
//        // ListNode current = dummyNode;
//        while (dummyNode.next != null) {
//            if (dummyNode.next.val == val) {
//                dummyNode.next = dummyNode.next.next;
//            } else {
//                dummyNode = dummyNode.next;
//            }
//        }
//        return dummyNode.next;
//    }
//}