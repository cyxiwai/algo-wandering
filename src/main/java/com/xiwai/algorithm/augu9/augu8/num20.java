package com.xiwai.algorithm.augu9.augu8;

import java.util.Stack;

public class num20 {
    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        String test = "]";
        System.out.println(solution20.isValid(test));
    }
}

class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] sChar = s.toCharArray();
        for (int i = 0; i < sChar.length; i++) {
//            char temp;
            switch (sChar[i]) {
                case '(':
                    stack.push(')');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != ')') {
                        return false;
                    } else {
                        stack.pop();
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != ']') {
                        return false;
                    } else {
                        stack.pop();
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.peek() != '}') {
                        return false;
                    } else {
                        stack.pop();
                    }
                    break;
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else
            return false;
    }
}
