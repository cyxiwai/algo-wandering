package com.xiwai.algorithm.sept.sept12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class kama109{
    static int n;
    static int[] father = new int[1001]; // 并查集数组

    // 并查集初始化
    public static void init() {
        for (int i = 1; i <= n; ++i) {
            father[i] = i;
        }
    }

    // 并查集里寻根的过程
    public static int find(int u) {
        if (u == father[u]) return u;
        return father[u] = find(father[u]); // 路径压缩
    }

    // 将 v->u 这条边加入并查集
    public static void join(int u, int v) {
        u = find(u);
        v = find(v);
        if (u != v) {
            father[v] = u; // 合并两棵树
        }
    }

    // 判断 u 和 v 是否有同一个根
    public static boolean same(int u, int v) {
        return find(u) == find(v);
    }

    // 在有向图里找到删除的那条边，使其变成树
    public static void getRemoveEdge(List<int[]> edges) {
        init(); // 初始化并查集
        for (int i = 0; i < n; i++) { // 遍历所有的边
            if (same(edges.get(i)[0], edges.get(i)[1])) { // 如果构成有向环了，就是要删除的边
                System.out.println(edges.get(i)[0] + " " + edges.get(i)[1]);
                return;
            } else {
                join(edges.get(i)[0], edges.get(i)[1]);
            }
        }
    }

    // 删一条边之后判断是不是树
    public static boolean isTreeAfterRemoveEdge(List<int[]> edges, int deleteEdge) {
        init(); // 初始化并查集
        for (int i = 0; i < n; i++) {
            if (i == deleteEdge) continue;
            if (same(edges.get(i)[0], edges.get(i)[1])) { // 如果构成有向环了，一定不是树
                return false;
            }
            join(edges.get(i)[0], edges.get(i)[1]);
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<int[]> edges = new ArrayList<>(); // 存储所有的边

        n = sc.nextInt(); // 顶点数
        int[] inDegree = new int[n + 1]; // 记录每个节点的入度
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt(); // 边的起点
            int t = sc.nextInt(); // 边的终点
            inDegree[t]++;
            edges.add(new int[]{s, t}); // 将边加入列表
        }

        List<Integer> vec = new ArrayList<>(); // 记录入度为2的边（如果有的话就两条边）
        // 找入度为2的节点所对应的边，注意要倒序，因为优先删除最后出现的一条边
        for (int i = n - 1; i >= 0; i--) {
            if (inDegree[edges.get(i)[1]] == 2) {
                vec.add(i);
            }
        }

        // 情况一、情况二
        if (vec.size() > 0) {
            // vec里的边已经按照倒叙放的，所以优先删 vec.get(0) 这条边
            if (isTreeAfterRemoveEdge(edges, vec.get(0))) {
                System.out.println(edges.get(vec.get(0))[0] + " " + edges.get(vec.get(0))[1]);
            } else {
                System.out.println(edges.get(vec.get(1))[0] + " " + edges.get(vec.get(1))[1]);
            }
            return;
        }

        // 处理情况三：明确没有入度为2的情况，一定有有向环，找到构成环的边返回即可
        getRemoveEdge(edges);
    }
}