package com.xiwai.algorithm.augu15;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class num113 {
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

        Solution113 solution = new Solution113();
        List<List<Integer>>test = solution.pathSum(root,22);
        for(List<Integer> list:test)
        {
            for(Integer i : list)
            {
                System.out.println(i);
            }
        }
        // 测试用例1：目标和为22
    }
}

class Solution113 {
    public List<List<Integer>> resList = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return resList;
        }
        List<Integer> paths = new ArrayList<>();
        DiGui113(root, targetSum- root.val, paths, resList);

        return resList;
    }

    public void DiGui113(TreeNode node, int sum, List<Integer> paths, List<List<Integer>> res) {
        paths.add(node.val);
        if (node.left == null && node.right == null && sum == 0) {
            res.add(new ArrayList<>(paths));
            return;
        }
        if (node.left != null) {
            DiGui113(node.left, sum - node.left.val, paths, res);
            paths.remove(paths.size() - 1);

        }
        if (node.right != null) {
            DiGui113(node.right, sum - node.right.val, paths, res);
            paths.remove(paths.size() - 1);

        }

    }
}
