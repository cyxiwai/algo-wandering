package com.xiwai.augu28;

import java.util.Arrays;

public class num406need {
    public static void main(String[] args) {
        Solution406 solution406 = new Solution406();
        int[][] test = {{4, 2}, {2, 2}};
        solution406.reconstructQueue(test);
    }
}

class Solution406 {
    public int[][] reconstructQueue(int[][] people) {
        int[][] ans = new int[people.length][];
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return b[0] - a[0];
            }
        });
        for(int[] row : people)
        {

        }
        return ans;
    }
}