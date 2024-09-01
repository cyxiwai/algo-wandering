package com.xiwai.algorithm.augu.augu13;

public class num104 {
    public static void main(String[] args) {

        Solution104 solution104 = new Solution104();
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(3, treeNode6, treeNode7);
        TreeNode treeNode2 = new TreeNode(2, treeNode4, treeNode5);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);
        System.out.println(solution104.maxDepth(treeNode1));

    }
}

class Solution104 {
    int deep = 0;

    public int maxDepth(TreeNode root) {
//        maxDepth(root, deep);
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;

    }
}