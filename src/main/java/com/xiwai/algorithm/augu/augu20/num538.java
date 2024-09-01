package com.xiwai.algorithm.augu.augu20;

public class num538 {
}

class Solution {
    int pre;

    public TreeNode convertBST(TreeNode root) {
        DiGui538(root);
        return root;
    }

    public void DiGui538(TreeNode root) {
        if (root == null) {
            return;

        }
        DiGui538(root.right);
        root.val += pre;
        pre = root.val;
        DiGui538(root.left);
    }
}