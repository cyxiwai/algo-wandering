package com.xiwai.algorithm.augu.augu18;

public class num236 {


    // 创建二叉树节点
    public static void main(String[] args) {
        // 构建二叉树
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        // 创建Solution实例
        Solution236 solution = new Solution236();

        // 定义p和q节点
        TreeNode p = root.left;         // 节点3
        TreeNode q = root.left.left;    // 节点2


        // 创建 Solution 实例
        TreeNode ancestor = solution.lowestCommonAncestor(root, p, q);

        // 打印结果
        if (ancestor != null) {
            System.out.println("Lowest Common Ancestor: " + ancestor.val);
        } else {
            System.out.println("Lowest Common Ancestor not found.");
        }
    }
}

class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return DiGui236(root, p, q);
    }

    public TreeNode DiGui236(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }


        TreeNode leftNode = DiGui236(root.left, p, q);
        TreeNode rightNode = DiGui236(root.right, p, q);
        if (leftNode != null && rightNode != null) {
            return root;
        }
        return leftNode != null ? leftNode : rightNode;
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