package com.xiwai.algorithm.augu15;

public class num404 {
    public static void main(String[] args) {
        Solution404 solution = new Solution404();

        // 测试用例1: 树结构如下:
        //       3
        //      / \
        //     9   20
        //        /  \
        //       15   7
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));

        int result1 = solution.sumOfLeftLeaves(root1);
        System.out.println("测试用例1结果: " + result1); // 输出应为24

        // 测试用例2: 空树
        TreeNode root2 = null;
        int result2 = solution.sumOfLeftLeaves(root2);
        System.out.println("测试用例2结果: " + result2); // 输出应为0

        // 测试用例3: 只有右子树
        //    1
        //     \
        //      3
        TreeNode root3 = new TreeNode(1);
        root3.right = new TreeNode(3);

        int result3 = solution.sumOfLeftLeaves(root3);
        System.out.println("测试用例3结果: " + result3); // 输出应为0

        // 测试用例4: 只有一个左叶子节点
        //    1
        //   /
        //  2
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);

        int result4 = solution.sumOfLeftLeaves(root4);
        System.out.println("测试用例4结果: " + result4); // 输出应为2
    }
}


class Solution404 {
    public int res = 0;

    public int sumOfLeftLeaves(TreeNode root) {

        return DiGui404(root);
    }


    public static int DiGui404(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.right == null && node.left == null) {
            return 0;
        }
        int leftValue = DiGui404(node.left);
        if (node.left != null && node.left.left == null && node.left.right == null) {
            leftValue = node.left.val;
        }
        int rightValue = DiGui404(node.right);
        int sum = leftValue + rightValue;
        return sum;

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