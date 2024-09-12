package com.xiwai.algorithm.sept.sept12;

public class bingchaji {
    public static void main(String[] args) {
        Solution solution = new Solution(10);
        solution.join(1, 2);
        solution.join(3, 2);
        solution.isSame(1, 3);
    }
}

class Solution {
    public int[] father;

    public Solution(int n) {
        father = new int[n];
        for (int i = 0; i < father.length; i++) {
            father[i] = i;
        }
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


    int find(int u) {
        return u == father[u] ? u : (father[u] = find(father[u]));
    }
}
