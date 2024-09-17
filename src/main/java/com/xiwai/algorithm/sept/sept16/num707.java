package com.xiwai.algorithm.sept.sept16;

import java.util.List;

public class num707 {
    public static void main(String[] args) {

    }

}

class MyLinkedList {
    private int size;
    private ListNode head;

    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    public int get(int index) {
        if (index < 0 || index > size - 1) {
            return -1;
        } else {
            ListNode cur = head;
            for (int i = 0; i <= index; i++) {
                cur = cur.next;
            }
            return cur.val;
        }
    }

    public void addAtHead(int val) {
        size++;
        head.next = new ListNode(val, head.next);
        return;
    }

    public void addAtTail(int val) {
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new ListNode(val);
        return;
    }

    //index=0，头插，index=size尾插，比size大越界返回空，正常范围，for循环移动index-1次
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        } else {
            size++;
            ListNode temp = new ListNode(val);
            ListNode cur = head;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            if (index == size) {
                cur.next = temp;
            } else {
                temp.next = cur.next;
                cur.next = temp;
            }
            return;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        //因为有虚拟头节点，所以不用对Index=0的情况进行特殊处理
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        pred.next = pred.next.next;
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
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */