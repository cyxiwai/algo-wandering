package com.xiwai.algorithm.augu.augu13;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class num144 {
    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2, null, treeNode3);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, null);
        Solution144 solution144 = new Solution144();
        List<Integer> test = solution144.preorderTraversal(treeNode1);
        for (Integer i : test) {
            System.out.println(i);
        }

    }
}

    //法2迭代：

class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            list.add(temp.val);
            if (temp.right != null) stack.push(temp.right);
            if (temp.left != null) stack.push(temp.left);
        }
        return list;
    }
}

//
//class Solution144 {
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        traverse(root, res);
//        return res;
//    }
//
//    public static void traverse(TreeNode node, List<Integer> res) {
//        if (node == null) {
//            return;
//        }
//        res.add(node.val);
//        traverse(node.left, res);
//        traverse(node.right, res);
//
//
//    }
//}

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

