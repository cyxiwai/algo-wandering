package com.xiwai.algorithm.sept.sept17;

public class num383 {
}

class Solution383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] alpha = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            alpha[ransomNote.charAt(i) - 'a']++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            alpha[magazine.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (alpha[i] < 0) {
                return false;
            }
        }
        return true;
    }
}
