package com.xiwai.algorithm.sept.sept21.num239;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class second {
    public static void main(String[] args) {
        int[] test = {1, 3, -1, -3, 5, 3, 6, 7};
        Solution s = new Solution();
        s.maxSlidingWindow(test, 3);
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length <= k) {
            int max = Integer.MIN_VALUE;
            for (int num : nums) {
                max = Math.max(max, num);
            }
            int[] ans = new int[1];
            ans[0] = max;
            return ans;
        }
        List<Integer> ans = new ArrayList<>();
        //初始化
        MyPriQueue myPriQueue = new MyPriQueue();
        for (int i = 0; i < k; i++) {
            myPriQueue.push(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            ans.add(myPriQueue.peek());
            if (myPriQueue.peek() == nums[i - k]) {
                myPriQueue.pop();
            }
            myPriQueue.push(nums[i]);
        }
        ans.add(myPriQueue.peek());
        int index = 0;
        int[] res = new int[nums.length - k + 1];
        for (int num : ans) {
            res[index++] = num;
        }
        return res;
    }

}

class MyPriQueue {
    private Deque<Integer> deque;

    public MyPriQueue() {
        deque = new LinkedList<>();
    }

    public void push(int x) {
        if (deque.isEmpty()) {
            deque.push(x);
        } else {
            while (!deque.isEmpty() && deque.peekLast() <= x) {
                deque.removeLast();
            }
            deque.addLast(x);
        }
    }

    public void pop() {
        deque.pollFirst();
    }

    public int peek() {
        if (!deque.isEmpty()) {
            return deque.peekFirst();
        } else {
            return -1;
        }
    }
}