package com.xiwai.algorithm.augu.augu10;

import java.util.*;

public class num239 {
    public static void main(String[] args) {
        Solution239 solution239 = new Solution239();
        int[] testnums = {1, 3, -1, -3, 5, 1, 3, 6, 7};
        int[] testres = solution239.maxSlidingWindow(testnums, 3);
        for (int i = 0; i < testres.length; i++) {
            System.out.println(testres[i]);
        }
//        Deque<Integer> deque = new LinkedList<>();
//        deque.getLast()

    }
}


//标准解法
class MyQueue {
    Deque<Integer> deque = new LinkedList<>();

    public void poll(int val) {
        if (!deque.isEmpty() && deque.peek() == val) {
            deque.poll();
        }
    }

    public void push(int val) {
        while (!deque.isEmpty() && val > deque.getLast()) {
            deque.removeLast();
        }
        deque.add(val);
    }

    public int peek() {
        return deque.peek();
    }
}

class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
//        List<Integer> res = new ArrayList<>();
        int index = 0;
        MyQueue myQueue = new MyQueue();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            myQueue.push(nums[i]);
        }
        res[index++] = myQueue.peek();
        for (int i = k; i < nums.length; i++) {
            myQueue.poll(nums[i - k]);
            myQueue.push(nums[i]);
            res[index++] = myQueue.peek();
        }
        return res;
    }
}
//
//class Solution239 {
//    public int[] maxSlidingWindow(int[] nums, int k) {
//
//        List<Integer> resList = new ArrayList<>();
//        int[] res = new int[nums.length - k + 1];
//        Queue<Integer> queue = new LinkedList<>();
//        int index = 0;
////        考虑其实没太大问题，就是需要初始化的，问题出在后续输出的显示边界
//        for (int i = 0; i < k; i++) {
//            while (!queue.isEmpty() && nums[i] > queue.peek()) {
//                queue.remove();
//            }
//            queue.offer(nums[i]);
//        }
////      初始化以后开始真正遍历
//        for (int i = k; i < nums.length; i++) {
//            resList.add(queue.peek());
//
//            if (!queue.isEmpty() && nums[i - k] == queue.peek()) {
//                queue.remove();
//            }
//            while (!queue.isEmpty() && nums[i] > queue.peek()) {
//                queue.remove();
//            }
//            queue.offer(nums[i]);
//
//        }
//        resList.add(queue.peek());
//
//        for (Integer i : resList) {
//            res[index++] = i;
//        }
//        return res;
//
//
//    }
//}
//逻辑有问题，考虑的太复杂，其实可以用一个&&语句来解决问题

//        int index = 0;
//
//        for (int i = 0; i < k; i++) {
//            if (i == 0) {
//                queue.offer(nums[i]);
//                continue;
//            }
//            {
//                if (nums[i] > queue.peek()) {
//                    while (!queue.isEmpty()) {
//                        queue.remove();
//                    }
//                    queue.offer(nums[i]);
//                } else {
//                    queue.offer(nums[i]);
//                }
//            }
//        }
//        for (int i = k; i + k < nums.length; i++) {
//            resList.add(queue.peek());
//            if (nums[i - k] == queue.peek()) {
//                queue.remove();
//            }
//
//            {
//                if (nums[i] > queue.peek()) {
//                    while (!queue.isEmpty()) {
//                        queue.remove();
//                    }
//                    queue.offer(nums[i]);
//                } else {
//                    queue.offer(nums[i]);
//                }
//            }
//
//        }
//        return resList.toArray(new Integer[nums.length-k+1]);
//    }
//}