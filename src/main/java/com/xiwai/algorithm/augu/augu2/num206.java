package com.xiwai.algorithm.augu.augu2;

public class num206 {

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
class Solution206 {
    public ListNode reverseList(ListNode head) {
        ListNode cur=head;
        ListNode temp=new ListNode();
        ListNode pre =null;
        if(head==null)
            return null;
        while(cur!=null)
        {
            temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
    }
}