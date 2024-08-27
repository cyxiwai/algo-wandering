package com.xiwai.algorithm.augu27;

public class num134 {
}

class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] rest = new int[gas.length];
        int curSum = 0;
        int ans = -1;
        int gas_total = 0;
        int cost_total = 0;
        for (int i = 0; i < gas.length; i++) {
            rest[i] = gas[i] - cost[i];
            gas_total += gas[i];
            cost_total += cost[i];
        }
        for (int i = 0; i < rest.length; i++) {
            curSum += rest[i];
            if (curSum < 0) {
                curSum = 0;
                ans = i + 1 >= rest.length ? i + 1 - rest.length : i + 1;
            }
        }

        return cost_total > gas_total ? -1 : ans;
    }
}