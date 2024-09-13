package com.xiwai.algorithm.sept.sept12;

import java.util.*;

public class huawei2301 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int portNumA = sc.nextInt();
        List<Integer> vlanNumA = new ArrayList<>();
        for (int i = 0; i < portNumA; i++) {
            vlanNumA.add(sc.nextInt());
        }
        int pointNum = sc.nextInt();

        HashSet<Long> set = new HashSet<>();
        for (int i = 0; i < pointNum; i++) {
            long portNumP = sc.nextLong();
            int portNums = sc.nextInt();
            for (int j = 0; j < portNums; j++) {
                int temp = sc.nextInt();
                if (vlanNumA.contains(temp)) {
                    set.add(portNumP);
                }
            }
        }
        System.out.println(set.size());
        if (!set.isEmpty()) {
            long[] tb = new long[set.size()];
            int index = 0;
            for (long portNum : set) {
                tb[index++] = portNum;
            }
            Arrays.sort(tb);
            for (int i = 0; i < tb.length - 1; i++) {
                System.out.print(tb[i] + " ");
            }
            System.out.println(tb[tb.length - 1]);
        }
    }
}
