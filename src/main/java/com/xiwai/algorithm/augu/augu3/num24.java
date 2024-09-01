package com.xiwai.algorithm.augu.augu3;

public class num24 {

}

class Solution24{
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
    class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode dummyNode = new ListNode();
            dummyNode.next = head;
            ListNode temp=dummyNode;
            ListNode firstNode =new ListNode();
            ListNode secondNode =new ListNode();
            while (temp.next!=null&&temp.next.next != null) {
                firstNode=temp.next;
                secondNode = temp.next.next;
                firstNode.next=secondNode.next;
                secondNode.next=firstNode;
                temp.next=secondNode;
                temp=firstNode;
            }
            return dummyNode.next;
        }
    }



}


