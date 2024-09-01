package com.xiwai.algorithm.augu.augu9;

import java.util.Stack;

public class num232 {
    public static void main(String[] args) {
//        Stack<Integer> stack=new Stack<>();
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty());
    }
}


class MyQueue {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();


    public MyQueue() {

    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if (!empty()) {
            if (!stack2.empty()) {
                return stack2.peek();
            } else {
                while (!stack1.empty()) {
                    stack2.push(stack1.pop());
                }
                return stack2.peek();
            }

        }
        return 0;
    }

    public boolean empty() {
        return stack2.empty() && stack1.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
