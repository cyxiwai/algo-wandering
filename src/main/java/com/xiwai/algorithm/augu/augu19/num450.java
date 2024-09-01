package com.xiwai.algorithm.augu.augu19;

public class num450 {
}

class Solution450 {
//    private TreeNode pre;

    public TreeNode deleteNode(TreeNode root, int key) {
        return DiGui450(root, key);
    }

    public TreeNode DiGui450(TreeNode root, int key) {
        TreeNode cur = root;

        if (root == null) {
            return root;
        }
        if (cur.val == key) {
            if (cur.left == null && cur.right == null) {
                return null;
            } else if (cur.left != null && cur.right == null) {
                return cur.left;
            } else if (cur.right != null && cur.left == null) {
                return cur.right;
            } else {
                TreeNode temp = cur.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                temp.left = cur.left;
                cur = cur.right;
                return cur;
            }
        }
        if (key < root.val) {
            root.left = DiGui450(root.left, key);
        }
        if (key > root.val) {
            root.right = DiGui450(root.right, key);
        }
        return root;
    }
}