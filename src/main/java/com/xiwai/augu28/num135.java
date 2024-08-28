package com.xiwai.augu28;

import java.util.Arrays;

public class num135 {
//    public static void main(String[] args) {
//        Solution s = new Solution();
//        int[] test = {1, 0, 2};
//        s.candy(test);
//    }
}

class Solution135 {
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        candy[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            } else {
                candy[i] = 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i + 1] + 1, candy[i]);
            }
        }
        int ans = 0;
        for (int i : candy) {
            ans += i;
        }
        return ans;
    }
}
