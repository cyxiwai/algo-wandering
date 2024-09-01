package com.xiwai.algorithm.augu.augu14;

public class num101 {
    public static void main(String[] args) {
        TreeNode treeNode7 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(2, treeNode6, treeNode7);
        TreeNode treeNode2 = new TreeNode(2, treeNode4, treeNode5);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);
        Solution101 solution101 = new Solution101();
        System.out.println(solution101.isSymmetric(treeNode1));
    }
}

class Solution101 {
    public boolean DiGui101(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            return false;
        } else if (right == null && left != null) {
            return false;
        } else if (right == null && left == null) {
            return true;
        } else if (left.val != right.val) {
            return false;
        }
        boolean outside = DiGui101(left.left, right.right);
        boolean inside = DiGui101(left.right, right.left);
        boolean isSame = outside && inside;
        return isSame;
    }


    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return DiGui101(root.left, root.right);
    }


}