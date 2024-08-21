package com.xiwai.algorithm.augu22;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class num131 {
}

class Solution131 {
    List<String> path = new ArrayList<>();
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backTracing(s, 0);
        return ans;

    }

    public void backTracing(String s, int startIndex) {
        if (startIndex >= s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String strTemp = s.substring(startIndex, i + 1);
            if (judgeHuiWen(strTemp)) {
                path.add(strTemp);
            } else {
                continue;
            }
            backTracing(s, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public boolean judgeHuiWen(String s) {
        char[] s_toChar = s.toCharArray();
        int j = s.length() - 1;
        for (int i = 0; i < j; i++, j--) {
            if (s_toChar[i] != s_toChar[j]) {
                return false;
            }
        }
        return true;
    }
}