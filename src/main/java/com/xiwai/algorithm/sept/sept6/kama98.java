package com.xiwai.algorithm.sept.sept6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class kama98 {
    public static List<List<Integer>> list = new ArrayList<>();
    public static List<Integer> path = new ArrayList<>();

    public static void dfs(int[][] graph, int m, int n) {
        if (m == n) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (graph[m][i] == 1) {
                path.add(i);
                dfs(graph, i, n);
                path.remove(path.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] graph = new int[m + 1][m + 1];
        for (int i = 0; i < n; i++) {
            int temp1 = sc.nextInt();
            int temp2 = sc.nextInt();
            graph[temp1][temp2] = 1;
        }//图的输入
        path.add(1);
        dfs(graph, 1, graph.length - 1);
        if (list.isEmpty())
            System.out.println(-1);
        for (List<Integer> li : list) {
            for (int i = 0; i < li.size() - 1; i++) {
                System.out.print(li.get(i) + " ");
            }
            System.out.println(li.get(li.size() - 1));
        }

    }
}
