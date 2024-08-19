package com.xiwai.algorithm.augu19;

public class num235 {
}

class Solution235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return DiGui235(root, p, q);
    }

    public TreeNode DiGui235(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return DiGui235(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return DiGui235(root.right, p, q);
        } else {
            return root;
        }
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