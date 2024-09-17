package com.xiwai.algorithm.sept.sept17;

public class num19_second {
}

class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode cur = dummyNode;
        ListNode pre = dummyNode;
        //节点12345 倒数第四个就是2 前驱是1 相当于dummy走四步
        for (int i = 0; i < n; i++) {
            cur = cur.next;
        }
        while (cur.next != null) {
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return dummyNode.next;
    }

}
