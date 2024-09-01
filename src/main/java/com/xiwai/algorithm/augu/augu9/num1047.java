package com.xiwai.algorithm.augu.augu9;

import java.util.Stack;

public class num1047 {
    public static void main(String[] args) {
        String test = "abvvcd";
        Solution1047 solution1047 = new Solution1047();
        System.out.println(solution1047.removeDuplicates(test));
    }
}

class Solution1047 {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        char[] sChar = s.toCharArray();
        for (int i = 0; i < sChar.length; i++) {
            if (!stack.isEmpty() && stack.peek() == sChar[i]) {
//                i++;
                stack.pop();
            } else {
                stack.push(sChar[i]);
            }
        }
        char[] resS = new char[stack.size()];
        int index = 0;
        while (!stack.isEmpty()) {
            resS[index++] = stack.pop();
        }
        int slowindex = 0;
        for (int fastindex = resS.length - 1; slowindex < fastindex; ) {
            char temp = resS[fastindex];
            resS[fastindex] = resS[slowindex];
            resS[slowindex] = temp;
            fastindex--;
            slowindex++;
        }
        return new String(resS);
    }
}
