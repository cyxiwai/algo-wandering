package com.xiwai.algorithm.sept.sept3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class num438 {
    public static void main(String[] args) {
        Solution so = new Solution();
        String s = "cbaebabacd";
        String p = "abc";
        so.findAnagrams("abab", "ab");
    }
}

class Solution {
    private int size = 0;
    private List<Integer> ans = new ArrayList<>();

    public List<Integer> findAnagrams(String s, String p) {
        int[] alpha = Anagrams_fix(p);
        int[] alpha_temp = Arrays.copyOf(alpha, alpha.length);
        int size_temp = size;
        boolean flag = true;
        for (int i = 0; i <= s.length() - size; i++) {
            int index = i;
            while (size_temp-- > 0) {
                alpha_temp[s.charAt(index++) - 'a']--;
            }
            for (int j = 0; j < 26; j++) {
                if (alpha_temp[j] != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans.add(i);
            }
            size_temp = size;
            alpha_temp = Arrays.copyOf(alpha, alpha.length);
            flag = true;
        }
        return ans;
    }

    public int[] Anagrams_fix(String s) {
        size = s.length();
        char[] s_toChar = s.toCharArray();
        int[] temp = new int[26];
        for (int i = 0; i < s.length(); i++) {
            temp[s_toChar[i] - 'a']++;
        }
        return temp;

    }
}
