package com.xiwai.employment.bytedance;

import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        bingchaji bingchaji = new bingchaji(n);

        for (int i = 0; i < n; i++) {
            int u =sc.nextInt();
            int v= sc.nextInt();
            bingchaji.join(u,v);
        }
        //
    }

}

class bingchaji {
    public int[] father;
    public int count=0;
    public bingchaji(int n) {
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