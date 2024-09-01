package com.xiwai.algorithm.augu.augu21;

import java.util.ArrayList;
import java.util.List;

public class num17 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.letterCombinations("23");
    }
}

class Solution {
    List<String> ans = new ArrayList<>();
    String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits == "" || digits.length() == 0) {
            return new ArrayList<>();
        }
        backTracing17(digits, numString, 0);
        return ans;
    }

    public void backTracing17(String digits, String[] numString, int index) {
        if (index == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        String strTemp = numString[digits.charAt(index) - '0'];
        for (int i = 0; i < strTemp.length(); i++) {
            sb.append(strTemp.charAt(i));
            backTracing17(digits, numString, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}