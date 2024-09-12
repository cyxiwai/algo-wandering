package com.xiwai.algorithm.sept.sept12;

import java.util.Scanner;

public class kama107 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        bingchaji107 b = new bingchaji107(m);

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            b.join(y, x);
        }
        int source = sc.nextInt();
        int destination = sc.nextInt();
        System.out.println(b.isSame(source, destination) ? 1 : 0);

    }

}

class bingchaji107 {
    public int[] father;

    public bingchaji107(int n) {
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