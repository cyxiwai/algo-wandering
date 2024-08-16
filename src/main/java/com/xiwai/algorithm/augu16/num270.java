package com.xiwai.algorithm.augu16;

public class num270 {
}


class Solution270 {
    public TreeNode searchBST(TreeNode root, int val) {
        return DiGui270(root, val);
    }

    //    递归思路：对根节点有处理，不需要特定叶子节点，需要所有节点查找，需要返回根节点
//    终止条件是，遍历完成后，若找到，可以直接return，否则return null
//    故使用treenode作为返回值，查找根节点是单层需要做的
//    先考虑终止条件，遍历到叶子节点的空子节点时，直接返回null，若找到，则返回本节点
    public TreeNode DiGui270(TreeNode root, int val) {

//        TreeNode root = new TreeNode(root.val);
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (val > root.val) {
            return DiGui270(root.right, val);
        } else {
            return DiGui270(root.left, val);
        }

    }
}