package com.xiwai.algorithm.augu24;

import java.util.ArrayList;
import java.util.List;

public class num49_need {
}
//
class Solution49 {
    List<List<String>> ans = new ArrayList<>();
    List<String> group = new ArrayList<>();

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return ans;
        }
        int[] index = new int[strs.length];
        for (int i = 0; i < strs.length - 1; i++) {
            if (index[i] != 0) {
                continue;
            }
            String cur = strs[i];
            group.add(cur);
            index[i]++;
            for (int j = i + 1; j < strs.length; j++) {
                if (isAnagrams(cur, strs[j])) {
                    group.add(strs[j]);
                    index[j]++;
                }
            }
            ans.add(new ArrayList<>(group));
            group.clear();
        }
        if (index[strs.length - 1] == 0) {
            group.add(strs[strs.length - 1]);
            ans.add(group);
        }
        return ans;
    }

    public boolean isAnagrams(String a, String b) {
        int[] index = new int[26];
        char[] a_to_char = a.toCharArray();
        char[] b_to_char = b.toCharArray();
        for (char ch : a_to_char) {
            index[ch - 'a']++;
        }
        for (char ch : b_to_char) {
            index[ch - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (index[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
