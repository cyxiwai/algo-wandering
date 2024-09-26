package com.xiwai.algorithm.sept.sept18;

public class kmpPrac {
    public static void main(String[] args) {
        String tests1 = "ATAATA";
        String tests2 = "AGCATAATAATTAA";
        String test = tests1 + "#" + tests2;
        int[] pi = new int[tests1.length() + tests2.length() + 1];
        for (int i = 1; i < tests1.length(); i++) {
            int len = pi[i - 1];
            while (len != 0 && tests1.charAt(len) != tests1.charAt(i)) {
                len = pi[len - 1];
            }
            if (tests1.charAt(len) == tests1.charAt(i)) {
                pi[i] = len + 1;
            }
        }
        System.out.println(pi);
    }
}
