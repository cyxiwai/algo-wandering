package com.xiwai.algorithm.augu.augu3;

public class num19 {
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
//双反转链表法，很傻
class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre= null;
        ListNode temp=null;
        ListNode cur = head;
        while(cur!=null)
        {
            temp= cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        ListNode dummyNode= new ListNode(-1);
        dummyNode.next=pre;
        if(dummyNode.next==null||dummyNode.next.next==null)
        {
            return null;
        }
        ListNode temp2=dummyNode;
        while((n--)>1)
        {
            temp2=temp2.next;
        }
        temp2.next=temp2.next.next;

        pre= null;
        temp=null;
        cur = dummyNode.next;
        while(cur!=null)
        {
            temp= cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
    }
}

//双指针法
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
class Solution19_2 {
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

