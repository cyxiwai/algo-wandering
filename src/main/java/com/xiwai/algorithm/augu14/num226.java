package com.xiwai.algorithm.augu14;

import java.util.ArrayList;
import java.util.List;

public class num226 {
    public static void main(String[] args) {
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(3, treeNode6, treeNode7);
        TreeNode treeNode2 = new TreeNode(2, treeNode4, treeNode5);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);
        Solution226 solution226 = new Solution226();
        solution226.DiGui226(treeNode1);
        traversal traversal = new traversal();
        List<List<Integer>> lists = traversal.levelOrder(treeNode1);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.println(i);
            }
        }
    }
}

class Solution226 {
    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return root;

        }
        DiGui226(root);

        return root;
    }

    public void DiGui226(TreeNode root) {

        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if (root.left != null) {
            DiGui226(root.left);
        }
        if (root.right != null) {
            DiGui226(root.right);
        }

    }
}


class traversal {
    public List<List<Integer>> resList = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        int deep = 0;
        levelDiGUi(root, deep);
//        TreeNode temp = root;


        return resList;
    }

    public void levelDiGUi(TreeNode root, int deep) {
        if (root == null) return;
        deep++;
        if (resList.size() < deep) {
            List<Integer> temp = new ArrayList<>();
            resList.add(temp);
        }

        resList.get(deep - 1).add(root.val);
        levelDiGUi(root.left, deep);
        levelDiGUi(root.right, deep);
    }
}

//Definition for a binary tree node.
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
