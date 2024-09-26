package com.xiwai.employment.xinye;

import java.util.*;

public class test {
    public static void main(String[] args) {
//        Solution s = new Solution();
        ArrayList<String> test = new ArrayList<>();
        test.add("GM");
        test.add("exp");
//        System.out.println(s.CheckNikeNameIsAllowed(test, "WHOLEGM"));
    }
}

class Solution1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param blocked_words string字符串ArrayList 屏蔽字库列表
     * @param nike_name     string字符串 需要检查的昵称
     * @return bool布尔型
     */
    public boolean CheckNikeNameIsAllowed(ArrayList<String> blocked_words, String nike_name) {
        // write code here
        for (int i = 0; i < blocked_words.size(); i++) {
            if (kmp(blocked_words.get(i), nike_name)) {
                return false;
            }
        }
        return true;
    }

    public boolean kmp(String tests1, String tests2) {

        String test = tests1 + "#" + tests2;
        int[] pi = new int[tests1.length() + tests2.length() + 1];
        for (int i = 1; i < test.length(); i++) {
            int len = pi[i - 1];
            while (len != 0 && test.charAt(len) != test.charAt(i)) {
                len = pi[len - 1];
            }
            if (test.charAt(len) == test.charAt(i)) {
                pi[i] = len + 1;
            }
        }
        for (int i = tests1.length(); i < pi.length; i++) {
            if (pi[i] == tests1.length()) {
                return true;
            }
        }
        return false;
    }

}