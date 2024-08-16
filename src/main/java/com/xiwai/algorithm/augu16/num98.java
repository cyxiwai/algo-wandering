package com.xiwai.algorithm.augu16;

public class num98 {

    public static void main(String[] args) {
        // 创建一个二叉树
        //        5
        //       / \
        //      3   7
        //     / \   \
        //    2   4   8

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
//            root.left.left = new TreeNode(2);
//            root.left.right = new TreeNode(4);
//            root.right.right = new TreeNode(8);

        // 创建 Solution98 实例
        Solution98 solution = new Solution98();

        // 检查这个树是否是有效的二叉搜索树
        boolean result = solution.isValidBST(root);
        System.out.println("Is valid BST: " + result);  // 应该打印: true

        // 创建一个无效的二叉搜索树
        //        5
        //       / \
        //      3   7
        //     / \   \
        //    2   6   8  <- 6 使得左子树不再是有效的二叉搜索树

        TreeNode rootInvalid = new TreeNode(5);
        rootInvalid.left = new TreeNode(3);
        rootInvalid.right = new TreeNode(7);
        rootInvalid.left.left = new TreeNode(2);
        rootInvalid.left.right = new TreeNode(6);  // 这里应该是个小于5的值
        rootInvalid.right.right = new TreeNode(8);

        // 检查这个树是否是有效的二叉搜索树
        boolean resultInvalid = solution.isValidBST(rootInvalid);
        System.out.println("Is valid BST: " + resultInvalid);  // 应该打印: false
    }
}


class Solution98 {
    public boolean isValidBST(TreeNode root) {
        return DiGui98(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    //    递归思路：
//    验证一个树是否是二叉搜索树，就要验证它的子树是不是二叉搜索树，于是便可以递归
//    首先判断此节点满不满足二叉搜索树特性，若不满足，则返回false
//    若满足，则判断左右子树是否为搜索树，若是，最后return左右子树与语句
//    边界条件？
//    自然递归边界条件/叶子节点条件？
//    感觉是后者，单个节点一定是二叉搜索树，返回true。
    public boolean DiGui98(TreeNode node, long max, long min) {
        if (node == null) {
            return true;
        }
        if (node.val >= max || node.val <= min) {
            return false;
        }

        return DiGui98(node.left, node.val, min) && DiGui98(node.right, max, node.val);
    }
}