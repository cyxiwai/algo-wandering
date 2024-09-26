package com.xiwai.algorithm.sept.sept26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class kama94 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Edge> list = new ArrayList<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] minDist = new int[n + 1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            int val = sc.nextInt();
            list.add(new Edge(s, t, val));
        }
        minDist[1] = 0;
        for (int i = 1; i < n; i++) {
            for (Edge edge : list) {
                if (minDist[edge.from] != Integer.MAX_VALUE && minDist[edge.to] > minDist[edge.from] + edge.val) {
                    minDist[edge.to] = minDist[edge.from] + edge.val;
                }
            }
        }
        if (minDist[n] == Integer.MAX_VALUE) {
            System.out.println("unconnected");
        } else {
            System.out.println(minDist[n]);
        }
    }
}

class Edge {
    public int from;
    public int to;
    public int val;

    public Edge(int from, int to, int val) {
        this.from = from;
        this.to = to;
        this.val = val;
    }
}