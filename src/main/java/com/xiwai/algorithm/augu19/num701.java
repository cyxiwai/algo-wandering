package com.xiwai.algorithm.augu19;

public class num701 {
}
//解法二：找到空节点，直接父指子：
class Solution701 {
    private TreeNode pre;

    public TreeNode insertIntoBST(TreeNode root, int val) {
        insertIntoBST_DIGUI(root, val);
        return root;
    }

    public void insertIntoBST_DIGUI(TreeNode root, int val) {
        if (root == null) {
            TreeNode temp = new TreeNode(val);
            if (val < pre.val) {
                pre.left = temp;

            }
            if (val > pre.val) {
                pre.right = temp;
            }
            return;
        }
        pre = root;
        if (val < root.val) {
            insertIntoBST_DIGUI(root.left, val);
        }
        if (val > root.val) {
            insertIntoBST_DIGUI(root.right, val);
        }
    }
}
//解法一：利用题目性质直接插空
//class Solution701 {
//    public TreeNode insertIntoBST(TreeNode root, int val) {
//        if (root == null) {
//            TreeNode nodeTemp = new TreeNode(val);
//            return nodeTemp;
//        }
//        if (val > root.val) {
//            root.right = insertIntoBST(root.right, val);
//            return root;
//        } else if (val < root.val) {
//
//            root.left = insertIntoBST(root.left, val);
//            return root;
//        } else {
//            return root;
//        }
//    }
//}