package com.xiwai.algorithm.sept.sept26;

import java.util.*;

public class kama117 {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] inDegrees = new int[n];
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            list.get(s).add(t);
            inDegrees[t]++;
        }//Initialization
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegrees[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            int cur = q.poll();
            result.add(cur);
            for (int file : list.get(cur)) {
                inDegrees[file]--;
                if (inDegrees[file] == 0) {
                    q.add(file);
                }
            }
        }
        if (result.size() == n) {
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i));
                if (i < result.size() - 1) {
                    System.out.print(" ");
                }
            }
        } else {
            System.out.println(-1);
        }

    }
}
