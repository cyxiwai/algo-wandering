package com.xiwai.algorithm.augu.augu2;

//
public class num707 {
    public static void main(String[] args) {
        MyLinkedList mll = new MyLinkedList();
        mll.addAtHead(17);
        mll.addAtHead(13);
        mll.addAtHead(15);
        mll.addAtHead(16);
        mll.addAtTail(22);
        mll.addAtHead(14);
        System.out.println(mll.get(0));
        System.out.println(mll.get(1));
        System.out.println(mll.get(2));
        System.out.println(mll.get(3));
        System.out.println(mll.get(4));
        System.out.println(mll.get(5));
        mll.addAtIndex(4, 40);
        System.out.println(mll.get(0));
        System.out.println(mll.get(1));
        System.out.println(mll.get(2));
        System.out.println(mll.get(3));
        System.out.println(mll.get(4));
        System.out.println(mll.get(5));
        System.out.println(mll.get(6));
        mll.deleteAtIndex(4);
        System.out.println(mll.get(0));
        System.out.println(mll.get(1));
        System.out.println(mll.get(2));

        System.out.println(mll.get(3));
        System.out.println(mll.get(4));
        System.out.println(mll.get(5));
    }
}


class ListNode {
    ListNode next;
    int val;

    ListNode() {

    }

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void insert(ListNode head, ListNode listNode2, int n) {
        for (int i = 0; i < n - 1; i++) {
            head = head.next;
        }
        listNode2.next = head.next;
        head.next = listNode2;
    }

    public void add(ListNode head, ListNode inlistnode) {
        if (head.next == null) {
            head = inlistnode;
        } else {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = inlistnode;
        }
    }

    public void delete(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0, null);
        dummyNode.next = head;
        for (int i = 0; i < n; i++) {
            dummyNode = dummyNode.next;
        }
        ListNode nodeNp = dummyNode.next;
        ListNode temp = dummyNode;
        temp.next = nodeNp.next;
    }
}


class MyLinkedList {
    public int size;
    public ListNode head;

    public MyLinkedList() {
        this.size = 0;
        head = new ListNode(0);
    }

    public int get(int index) {
        //如果index非法，返回-1
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode currentNode = head;
        //包含一个虚拟头节点，所以查找第 index+1 个节点
        for (int i = 0; i <= index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.val;
    }

    void addAtHead(int val) {
        ListNode cur = new ListNode(val);

        cur.next = head.next;
        head.next = cur;
        size++;

    }

    void addAtTail(int val) {
        ListNode cur = new ListNode(val);
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = cur;
        size++;
    }

    void addAtIndex(int index, int val) {
        ListNode cur = new ListNode(val);
        ListNode temp = head;
        if (index < size) {
            size++;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            cur.next = temp.next;
            temp.next = cur;
        } else if (index == size) {
            addAtTail(val);
        }else{return;}

    }

    void deleteAtIndex(int index) {
        System.out.println(head.val);
        System.out.println(head.next.val);
        ListNode temp = head;
        if (index < 0 || index >= size) {
            return;
        }
        if (index <= size) {
            size --;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
    }


}

//你可以选择使用单链表或者双链表，设计并实现自己的链表。
//
//单链表中的节点应该具备两个属性：val 和 next 。val 是当前节点的值，next 是指向下一个节点的指针/引用。
//
//如果是双向链表，则还需要属性 prev 以指示链表中的上一个节点。假设链表中的所有节点下标从 0 开始。
//
//实现 MyLinkedList 类：
//
//MyLinkedList() 初始化 MyLinkedList 对象。
//int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
//void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
//void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
//void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。
//void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。
