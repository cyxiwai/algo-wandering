package com.xiwai.algorithm.augu3;

public class num160 {
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int sizeA = 0;
        int sizeB = 0;
        while (curA != null) {
            sizeA++;
            curA = curA.next;
        }
        while (curB != null) {
            sizeB++;
            curB = curB.next;
        }
        curA=headA;
        curB=headB;
        if (sizeA < sizeB) {
            int temp = sizeA;
//            temp = sizeA;
            sizeA = sizeB;
            sizeB = temp;
            ListNode listnodetemp=curA;
//            listnodetemp=curA;
            curA=curB;
            curB=listnodetemp;
        }
        int length = sizeA - sizeB;
        while (length-- > 0) {
            curA = curA.next;
        }
        while (curA!= curB) {
//            if(curA==curB)
//            {
//                return curA;
//            }
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }
}