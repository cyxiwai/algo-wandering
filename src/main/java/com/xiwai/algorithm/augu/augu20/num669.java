package com.xiwai.algorithm.augu.augu20;

public class num669 {
}

class Solution669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return DiGui669(root, low, high);
    }

    //    递归思路：
//    一 确定参数返回值
//            参数为节点和范围，返回值用节点，用左右去接住。
//    二 确定递归终止条件，这个肯定是要遍历完的，没什么好说，而且有空树，无脑root==Null。
//    三，确定逻辑
//    首先看根节点，
//    1.区间内：区间内就继续处理左右子节点。返回值设置为root，这样就保证不处理，继续往左右子树看。
//    2.左区左：遍历右子树 执行相同逻辑。root=digui(root.right)
//    3.右区右：遍历左子树 执行相同逻辑。
//    回头把情况模拟一遍，1.区间内就继续验证左右区间，一旦遇到2.3两种情况就调用2.3情况的逻辑
//            直接把不在区间内的root用root.right处理完的子树返回作为前者的子节点。
//
    public TreeNode DiGui669(TreeNode root, int low, int high) {
        if (root == null) {
            return root;
        }
        if (root.val < low) {
            root = DiGui669(root.right, low, high);
            return root;
        } else if (root.val > high) {
            root = DiGui669(root.left, low, high);
            return root;
        } else {
            root.left = DiGui669(root.left, low, high);
            root.right = DiGui669(root.right, low, high);
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