package com.xiwai.algorithm.augu.augu17;

import java.util.*;

public class num501 {
    public static void main(String[] args) {

        // 创建一个深度为4的复杂二叉树
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.left.left = new TreeNode(1);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(7);

        // 创建 Solution 实例
        Solution501 solution = new Solution501();

        // 调用 findMode 方法并打印结果
        int[] modes = solution.findMode(root);
        System.out.print("Modes: ");
        for (int mode : modes) {
            System.out.print(mode + " ");
        }
    }
}


class Solution501 {
    TreeNode tempPre = null;

    public List<Integer> resTemp = new ArrayList<>();
    int count = -1;
    int count_max = Integer.MIN_VALUE;

    public int[] findMode(TreeNode root) {

        DiGui501_2(root);
        int[] ans = new int[resTemp.size()];
        for (int i = 0; i < resTemp.size(); i++) {
            ans[i] = resTemp.get(i);
        }
        return ans;
    }

    public void DiGui501_2(TreeNode root) {

        if (root == null) {
            return;
        }
        DiGui501_2(root.left);
        if (tempPre == null) {
            count = 1;
        } else if (tempPre.val == root.val) {
            count++;
        } else {
            count = 1;
        }
        if (count > count_max) {
            count_max = count;
            resTemp.clear();
            resTemp.add(root.val);
        }
        if (count == count_max && !resTemp.contains(root.val)) {
            resTemp.add(root.val);
        }
        tempPre = root;
        DiGui501_2(root.right);

    }
}
//解法二：利用BST性质解法

//解法一：普通暴力遍历法
//class Solution501 {
//    public int[] findMode(TreeNode root) {
//        int res = Integer.MIN_VALUE;
//        int index = 0;
//        int count = 0;
//        HashMap<Integer, Integer> map = new HashMap<>();
//        DiGui501(root, map);
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            res = Math.max(res, entry.getValue());
//        }
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (entry.getValue() == res) {
//                count++;
//            }
//        }
//
//        int[] resList = new int[count];
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (entry.getValue() == res) {
//                resList[index++] = entry.getKey();
//            }
//        }
//        return resList;
//    }
//
//    //    递归思路，直接遍历，每个节点值为键，归入哈希表
//    public void DiGui501(TreeNode root, HashMap<Integer, Integer> map) {
//        if (root == null) {
//            return;
//        }
//        DiGui501(root.left, map);
//        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
//        DiGui501(root.right, map);
//    }
//}