package com.xiwai.algorithm.sept.sept21;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class num225_second {
    public static void main(String[] args) {
         MyStack stack = new MyStack();
        stack.add(1);
        stack.add(2);
        stack.remove();
        stack.top();
    }
}

class MyStack {
    private Queue<Integer> deque1;
    private Queue<Integer> deque2;

    public MyStack() {
        deque1 = new LinkedList<>();
        deque2 = new LinkedList<>();
    }

    public void add(int x) {
        deque1.add(x);
    }

    public int remove() {
        while (deque1.size() > 1) {
            deque2.add(deque1.remove());
        }
        int fin = deque1.remove();
        while (!deque2.isEmpty()) {
            deque1.add(deque2.remove());
        }
        return fin;
    }

    public int top() {
        while (deque1.size() > 1) {
            deque2.add(deque1.remove());
        }
        int fin = deque1.isEmpty() ? -1 : deque1.peek();
        deque2.add(deque1.remove());
        while (!deque2.isEmpty()) {
            deque1.add(deque2.remove());
        }
        return fin;
    }

    public boolean empty() {
        return deque1.isEmpty() && deque2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.add(x);
 * int param_2 = obj.remove();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
