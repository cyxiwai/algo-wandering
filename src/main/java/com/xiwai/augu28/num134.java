package com.xiwai.augu28;

public class num134 {
    public static void main(String[] args) {
        int[] test1= {5,1,2,3,4};
        int[] test2={4,4,1,5,1};
        Solution134 solution134 = new Solution134();
        solution134.canCompleteCircuit(test1,test2);
    }
}

class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] res = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            res[i] = gas[i] - cost[i];
        }
        int sum = 0;
        int ans = 0;
        int judgeRes = 0;
        for (int i = 0; i < res.length; i++) {
            sum += res[i];
            judgeRes += res[i];
            if (sum < 0) {
                ans = i + 1 < res.length ? i + 1 : i + 1 - res.length;
                sum = 0;
            }
        }
        return judgeRes < 0 ? -1 : ans;
    }
}