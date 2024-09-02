package com.xiwai.algorithm.sept.sept2;

public class num337 {
}

class Solution337 {
    public int rob(TreeNode root) {
        int[] ans = traverse(root);
        return Math.max(ans[0], ans[1]);
    }

    public int[] traverse(TreeNode treeNode) {
        int[] dp = new int[2];
        if (treeNode == null) {
            return dp;
        }
        int[] left = traverse(treeNode.left);
        int[] right = traverse(treeNode.right);
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        dp[1] = treeNode.val + left[0] + right[0];

        return dp;
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
