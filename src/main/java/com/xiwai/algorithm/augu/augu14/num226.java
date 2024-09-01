package com.xiwai.algorithm.augu.augu14;

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

//
//class Solution {
//    /**
//     * 递归法
//     */
//    public List<String> binaryTreePaths(TreeNode root) {
//        List<String> res = new ArrayList<>();// 存最终的结果
//        if (root == null) {
//            return res;
//        }
//        List<Integer> paths = new ArrayList<>();// 作为结果中的路径
//        traversal(root, paths, res);
//        return res;
//    }
//
//    private void traversal(TreeNode root, List<Integer> paths, List<String> res) {
//        paths.add(root.val);// 前序遍历，中
//        // 遇到叶子结点
//        if (root.left == null && root.right == null) {
//            // 输出
//            StringBuilder sb = new StringBuilder();// StringBuilder用来拼接字符串，速度更快
//            for (int i = 0; i < paths.size() - 1; i++) {
//                sb.append(paths.get(i)).append("->");
//            }
//            sb.append(paths.get(paths.size() - 1));// 记录最后一个节点
//            res.add(sb.toString());// 收集一个路径
//            return;
//        }
//        // 递归和回溯是同时进行，所以要放在同一个花括号里
//        if (root.left != null) { // 左
//            traversal(root.left, paths, res);
//            paths.remove(paths.size() - 1);// 回溯
//        }
//        if (root.right != null) { // 右
//            traversal(root.right, paths, res);
//            paths.remove(paths.size() - 1);// 回溯
//        }
//    }
//}
