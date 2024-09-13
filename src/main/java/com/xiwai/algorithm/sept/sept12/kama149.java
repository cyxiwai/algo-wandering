//package com.xiwai.algorithm.sept.sept12;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
//public class kama149 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        HashMap<Integer, Integer> map = new HashMap<>();
//        int maxVNum = 0;
//        int maxKNum = 0;
//        for (int i = 0; i < n; i++) {
//            int temp = sc.nextInt();
//            map.put(temp, map.getOrDefault(temp, 0) + 1);
//        }
//        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
//            maxKNum = Math.max(maxKNum, m.getKey());
//            maxVNum = Math.max(maxVNum, m.getValue());
//        }
//        System.out.println(maxNum >= n / 2 ? n - maxNum : maxNum);
//    }
//}

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class kama149 {

    public static int minOperationsToGoodArray(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        // 统计每个元素出现的次数
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // 找到出现次数最多的元素
        int maxFreq = 0;
        int mostFrequentElement = arr[0];
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                mostFrequentElement = entry.getKey();
            }
        }

        // 计算操作次数：将所有不同的元素转换为 mostFrequentElement
        int minOperations = 0;
        int diffElementCount = 0;
        for (int num : arr) {
            if (num != mostFrequentElement) {
                minOperations += Math.abs(num - mostFrequentElement);
                diffElementCount++;
            }
        }

        // 确保只有一个不同的元素，其他都是相同的

        return minOperations;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = minOperationsToGoodArray(arr);

        System.out.println(result);
    }
}