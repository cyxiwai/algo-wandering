package com.xiwai.algorithm.augu.augu27;

public class num206 {
    public static void main(String[] args) {
        Solution206 solution206 = new Solution206();
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        solution206.reverseList(headB);
    }
}

class Solution206 {
    //    用cur记录当前节点，循环条件使用cur！=null，用temp保存当前节点，用pre记录已经反转的节点。
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode temp = new ListNode();
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;

        }
        return pre;
    }
}