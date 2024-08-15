package com.xiwai.algorithm.augu15;

import java.util.HashMap;

public class num106 {

    public static void main(String[] args) {
        Solution106 solution = new Solution106();

        // 示例用例
        // 构建的二叉树：
        //       3
        //      / \
        //     9   20
        //        /  \
        //       15   7
        int[] inorder = {8, 4, 2, 9, 5, 1, 6, 3, 10, 7, 11};
        int[] postorder = {8, 4, 9, 5, 2, 6, 10, 11, 7, 3, 1};

        TreeNode root = solution.buildTree(inorder, postorder);

        // 打印重建的二叉树（前序遍历）
        printPreorder(root);
    }

    // 辅助函数：前序遍历打印二叉树
    public static void printPreorder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }
}


//解法二：


class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return DiGui106_2(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);

    }

    public TreeNode DiGui106_2(int[] inorder, int inStart, int inEnd,
                               int[] postorder, int postStart, int postEnd, HashMap<Integer, Integer> map) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        int value = postorder[postEnd];
        TreeNode root = new TreeNode(value);
        int index = map.get(value);
        int leftTreeSize = index - inStart;
        root.left = DiGui106_2(inorder, inStart, index - 1, postorder, postStart, postStart + leftTreeSize - 1, map);
        root.right = DiGui106_2(inorder, index + 1, inEnd, postorder, postStart + leftTreeSize, postEnd - 1, map);
        return root;
    }
}
//
//class Solution106 {
//    public TreeNode buildTree(int[] inorder, int[] postorder) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < inorder.length; i++) {
//            map.put(inorder[i], i);
//        }
//
//        return DiGui106(inorder, postorder,map);
//    }
//
//    public TreeNode DiGui106(int[] inorder, int[] postorder,HashMap<Integer,Integer> map) {
//        if (inorder.length == 0) {
//            return null;
//        }
//        int value = postorder[postorder.length - 1];
//        TreeNode root = new TreeNode(value);
//
//        if (postorder.length == 1) {
//            return root;
//        }
//
//        int index = map.get(postorder[postorder.length - 1]);
//        for (index = 0; index < postorder.length; index++) {
//            if (inorder[index] == postorder[postorder.length - 1]) {
//                break;
//            }
//        }
//        int[] inorderTempLeft = new int[index];
//        int[] postorderTempLeft = new int[index];
//        int[] inorderTempRight = new int[postorder.length - index - 1];
//        int[] postorderTempRight = new int[postorder.length - index - 1];
//        for (int i = 0; i < index; i++) {
//            inorderTempLeft[i] = inorder[i];
//            postorderTempLeft[i] = postorder[i];
//
//        }
//        for (int i = 0; i < postorderTempRight.length; i++) {
//            inorderTempRight[i] = inorder[index + 1 + i];
//            postorderTempRight[i] = postorder[index + i];
//
//        }
//
//        root.left = buildTree(inorderTempLeft, postorderTempLeft);
//        root.right = buildTree(inorderTempRight, postorderTempRight);
//        return root;
//
//    }
//}