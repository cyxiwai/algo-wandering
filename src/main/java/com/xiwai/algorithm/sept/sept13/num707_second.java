package com.xiwai.algorithm.sept.sept13;

public class num707_second {
}

class MyLinkedList {
    private int val;
    private MyLinkedList next;
    private int size;

    public MyLinkedList() {
        this.size = 0;
    }

    public int get(int index) {
        if (index > size - 1 || index < 0) {
            return -1;
        } else if (index == 0) {
            return this.val;
        } else {
            while (index-- > 0) {
            }
        }
        return 0;
    }

    public void addAtHead(int val) {

    }

    public void addAtTail(int val) {

    }

    public void addAtIndex(int index, int val) {

    }

    public void deleteAtIndex(int index) {

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
