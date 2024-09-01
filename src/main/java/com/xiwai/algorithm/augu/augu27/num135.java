package com.xiwai.algorithm.augu.augu27;

public class num135 {
}

class Solution135 {
    public int candy(int[] ratings) {
        int ans = 0;
        int[] candy = new int[ratings.length];
        candy[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            } else
                candy[i] = 1;
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i + 1] + 1, candy[i]);
            }
        }
        for (int i : candy) {
            ans += i;
        }
        return ans;
    }
}