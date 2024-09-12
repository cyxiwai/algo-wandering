package com.xiwai.algorithm.sept.sept9;

import java.util.List;

public class num2181 {
    public static void main(String[] args) {
        Solution2181 s = new Solution2181();
        ListNode head1 = new ListNode(0, new ListNode(3, new ListNode(1,
                new ListNode(0, new ListNode(4, new ListNode(5,
                        new ListNode(2, new ListNode(0))))))));

        // 构建测试用例 2: 0 -> 1 -> 2 -> 0 -> 0 -> 3 -> 4 -> 0
        ListNode head2 = new ListNode(0, new ListNode(1, new ListNode(2,
                new ListNode(0, new ListNode(0, new ListNode(3,
                        new ListNode(4, new ListNode(0))))))));

        // 运行 mergeNodes 并打印结果
        System.out.print("Test Case 1: ");
        ListNode result1 = s.mergeNodes(head1);
        printList(result1);

        System.out.print("Test Case 2: ");
        ListNode result2 = s.mergeNodes(head2);
        printList(result2);
    }

    // 打印链表
    public static void printList(ListNode node) {
        while (node != null) {
            if (node.next != null) {
                System.out.print(node.val + " -> ");
            } else {
                System.out.print(node.val);
            }
            node = node.next;
        }
        System.out.println();
    }
}


class Solution2181{
    protected ListNode ans = new ListNode();

    //快慢指针，双指针法快指针找下一个0，如果到null就直接停下，每次节点遍历都累加一个sum，当快指针停下，sum新建为新的节点，
    //当快指针停下，用慢指针记录快指针，慢指针的下一个就是后面保存的内容，前面的就直接丢弃，通过sum来连接
    public ListNode mergeNodes(ListNode head) {
        ListNode fastNode = head;
        ListNode slowNode = head;
        int sum = 0;
        ListNode temp = ans;
        while (slowNode.next != null) {
            while (fastNode.val == 0 && fastNode.next != null && fastNode.next.val == 0)//寻找下一个节点前的最后一个0
            {
                fastNode = fastNode.next;
            }
            if (fastNode.next == null) {
                break;
            } else {
                fastNode = fastNode.next;
                while (fastNode.val != 0) {
                    sum += fastNode.val;
                    fastNode = fastNode.next;
                }
                temp.next = new ListNode(sum);
                temp = temp.next;
                sum = 0;
                slowNode = fastNode;
            }
        }
        return ans.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}