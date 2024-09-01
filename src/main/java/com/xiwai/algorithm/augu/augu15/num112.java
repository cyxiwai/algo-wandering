package com.xiwai.algorithm.augu.augu15;

public class num112 {
    public static void main(String[] args) {
        // 构建测试用例二叉树
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        Solution112 solution = new Solution112();

        // 测试用例1：目标和为22
        int targetSum1 = 22;
        boolean result1 = solution.hasPathSum(root, targetSum1);
        System.out.println("Test case 1: " + result1); // 输出应为 true

        // 测试用例2：目标和为26
        int targetSum2 = 26;
        boolean result2 = solution.hasPathSum(root, targetSum2);
        System.out.println("Test case 2: " + result2); // 输出应为 true

        // 测试用例3：目标和为18
        int targetSum3 = 18;
        boolean result3 = solution.hasPathSum(root, targetSum3);
        System.out.println("Test case 3: " + result3); // 输出应为 false

        // 测试用例4：目标和为5（仅根节点）
        int targetSum4 = 5;
        boolean result4 = solution.hasPathSum(root, targetSum4);
        System.out.println("Test case 4: " + result4); // 输出应为 false

        // 测试用例5：空树的情况
        TreeNode emptyRoot = null;
        int targetSum5 = 0;
        boolean result5 = solution.hasPathSum(emptyRoot, targetSum5);
        System.out.println("Test case 5: " + result5); // 输出应为 false
    }
}

class Solution112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return DiGui112(root, targetSum- root.val);

    }

    public boolean DiGui112(TreeNode node, int sum) {
        if (node.left == null && node.right == null && sum == 0) {
            return true;
        }
        if (node.left == null && node.right == null) {
            return false;
        }
        if (node.left != null) {
            if (DiGui112(node.left, sum - node.left.val)) {
                return true;
            }
        }
        if (node.right != null) {
            if (DiGui112(node.right, sum - node.right.val)) {
                return true;
            }
        }
        return false;
    }
}