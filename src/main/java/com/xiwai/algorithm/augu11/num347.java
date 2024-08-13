package com.xiwai.algorithm.augu11;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class num347 {
    public static void main(String[] args) {
        int[] testnums = {1, 1, 1, 2, 2, 3, 4, 4, 4, 4, 6};
        Solution347 solution347 = new Solution347();
        int[] testres = solution347.topKFrequent(testnums, 3);
        for (int i = 0; i < testres.length; i++) {
            System.out.println(testres[i]);
        }

    }
}


class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
//        map.getOrDefault()
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((pair1, pair2) -> pair2[1] - pair1[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            priorityQueue.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = priorityQueue.poll()[0];
        }
        return ans;
    }
}