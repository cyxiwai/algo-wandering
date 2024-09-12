package com.xiwai.algorithm.sept.sept12;

import java.util.Scanner;

public class kama108 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = m;
        int[][] vert = new int[m][2];
        bingchaji108 b = new bingchaji108(n + 1);

        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            vert[i][0] = s;
            vert[i][1] = t;
        }
        for (int i = 0; i < m; i++) {
            if (!b.isSame(vert[i][0], vert[i][1])) {
                b.join(vert[i][0], vert[i][1]);
            } else {
                System.out.println(vert[i][0] + " " + vert[i][1]);
            }
        }
    }
}

class bingchaji108 {
    private int[] father;

    public bingchaji108(int n) {
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }

    public int find(int u) {
        return (u == father[u]) ? u : (father[u] = find(father[u]));
    }

    public void join(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) {
            return;
        }
        father[v] = u;
    }

    public boolean isSame(int u, int v) {
        u = find(u);
        v = find(v);
        return u == v;
    }
}
