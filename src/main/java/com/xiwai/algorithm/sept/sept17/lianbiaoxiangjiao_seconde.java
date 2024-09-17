package com.xiwai.algorithm.sept.sept17;

public class lianbiaoxiangjiao_seconde {
}

class Solution02 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int countA = 0, countB = 0;

        while (curA != null || curB != null) {
            if (curA != null) {
                countA++;
                curA = curA.next;
            }
            if (curB != null) {
                countB++;
                curB = curB.next;
            }
        }
        curA = headA;
        curB = headB;
        if (countA > countB) {
            for (int i = 0; i < countA - countB; i++) {
                curA = curA.next;
            }
            for (int i = 0; i < countB; i++) {
                if (curA == curB) {

                    return curA;
                }
                curA = curA.next;
                curB = curB.next;
            }
        }
        if (countA <= countB) {
            for (int i = 0; i < countB - countA; i++) {
                curB = curB.next;
            }
            for (int i = 0; i < countA; i++) {
                if (curA == curB) {

                    return curA;
                }
                curA = curA.next;
                curB = curB.next;
            }
        }
        return null;
    }
}