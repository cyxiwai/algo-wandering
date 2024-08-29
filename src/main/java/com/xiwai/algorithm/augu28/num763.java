package com.xiwai.algorithm.augu28;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class num763 {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        Solution763 sa = new Solution763();
        sa.partitionLabels(s);
    }
}

class Solution763 {
    public List<Integer> partitionLabels(String s) {
        int[] alpha = new int[26];
        char[] s_toChar = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            alpha[s_toChar[i] - 'a']++;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put(i, alpha[i]);
        }
        int count = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int flag = 0;
            count++;
            alpha[s_toChar[i] - 'a']--;
            if (alpha[s_toChar[i] - 'a'] == 0) {
                for (int j = 0; j < 26; j++) {
                    if (alpha[j] != map.get(j)) {
                        if (alpha[j] == 0) {
                            continue;
                        } else {
                            flag = 1;
                            break;
                        }
                    }
                }
                if (flag == 0) {
                    ans.add(count);
                    count = 0;
                }
            }
        }
        return ans;
    }
}
