package com.xiwai.algorithm.augu.augu6;

public class num383 {
    public static void main(String[] args) {
        Solution383 solution383 =new Solution383();
        System.out.println(solution383.canConstruct("aa","ab"));
    }
}

class Solution383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] hash = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            hash[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if(--hash[ransomNote.charAt(i)-'a']<0)
            {
                return false;
            }
        }
        return true;

    }
}