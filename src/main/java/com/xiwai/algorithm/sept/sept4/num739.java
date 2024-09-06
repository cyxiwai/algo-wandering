package com.xiwai.algorithm.sept.sept4;

import java.util.Stack;

public class num739 {
    public static void main(String[] args) {
        Solution739 s = new Solution739();
        int[] tes = {73, 74, 75, 71, 69, 72, 76, 73};
        s.dailyTemperatures(tes);
    }
}

class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];
        stack.add(0);
        for (int i = 1; i < temperatures.length; i++) {
            if (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    ans[stack.peek()] = i - stack.pop();
                }
            }
            stack.add(i);
        }
        return ans;
    }
}

