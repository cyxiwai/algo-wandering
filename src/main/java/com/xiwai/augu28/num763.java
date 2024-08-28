package com.xiwai.augu28;

import java.util.List;

public class num763 {
}

class Solution763 {
    public List<Integer> partitionLabels(String s) {
        int[] alpha = new int [26];
        for (int i = 0; i < s.length(); i++) {
            char[] s_toChar = s.toCharArray();
            alpha[s_toChar[i]-'a']++;
        }
        return null;
    }
}
