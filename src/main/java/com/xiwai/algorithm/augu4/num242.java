package com.xiwai.algorithm.augu4;

import java.util.Arrays;

public class num242 {
    public static void main(String[] args) {

        String s="rat";
        String t="car";
        int[] recordAlpha = new int[26];
//        Arrays.fill(recordAlpha,s.length());
        for (int i = 0; i < s.length(); i++) {
            recordAlpha[s.charAt(i) - 'a']++;
        }
        for (int j = 0; j < t.length(); j++) {
            recordAlpha[t.charAt(j) - 'a']--;
        }
        for (int k = 0; k < 26; k++) {
            if (recordAlpha[k] != 0) {
                System.out.println("false");;
            }
        }

    }
}

class Solution242{

}
