package com.xiwai.algorithm.augu.augu9;

import java.util.LinkedList;
import java.util.Queue;

public class num225 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1); // queue is: [1]
        myStack.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myStack.top()); // return 1
        System.out.println(myStack.pop()); // return 1, queue is [2]
        System.out.println(myStack.pop()); // return 1, queue is [2]
        System.out.println(myStack.empty());
    }
}

class MyStack {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    public MyStack() {

    }

    public void push(int x) {

//        解法一
//        queue2.offer(x);
//        while(!queue1.isEmpty())
//        {
//            queue2.offer(queue1.remove());
//        }
//        Queue<Integer>temp =queue1;
//        queue1=queue2;
//        queue2=temp;
//        解法二
//        queue2.offer(x);
//        while(!queue1.isEmpty())
//        {
//            queue2.offer(queue1.remove());
//
//        }
//        while(!queue2.isEmpty())
//        {
//            queue1.offer(queue2.remove());
//        }
//        解法三
        queue1.offer(x);
        int size = queue1.size();
        while (size-- > 1)//重新排列除最后一个元素以外的元素，也就是逻辑上实现栈
        {
            queue1.offer(queue1.remove());//很重要就是这句话！！
        }


    }

    public int pop() {
        if (!queue1.isEmpty()) {
            return queue1.remove();
        } else
            return -1;
    }

    public int top() {
        if (!queue1.isEmpty()) {
            return queue1.peek();
        } else {
            return -1;
        }
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
