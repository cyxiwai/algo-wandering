package com.xiwai.algorithm.augu29;

public class num968 {
}

class Solution968 {
    public int count = 0;

    public int minCameraCover(TreeNode root) {

        if (backTracing(root) == 0) {
            count++;
        }
        return count;
    }

    public int backTracing(TreeNode root) {
        if (root == null) {
            return 2;
        }
        int left = backTracing(root.left);
        int right = backTracing(root.right);
        if (left == 0 || right == 0) {
            count++;
            return 1;

        }
        if (left == 2 && right == 2) {
            return 0;
        }
        if (left == 1 || right == 1) {
            return 2;
        }
        return -1;
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
