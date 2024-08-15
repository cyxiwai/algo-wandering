package com.xiwai.algorithm.augu15;

import java.util.HashMap;

public class num105 {
    public static void main(String[] args) {
        Solution105 solution = new Solution105();

        // 示例用例
        // 构建的二叉树：
        //       3
        //      / \
        //     9   20
        //        /  \
        //       15   7
        int[] inorder = {3,9,20,15,7};
        int[] postorder = {9,3,15,20,7};

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

class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return DiGUi105(preorder, inorder, 0, preorder.length
                - 1, 0, inorder.length - 1, map);
    }

    public TreeNode DiGUi105(int[] preorder, int[] inorder, int preStart, int preEnd
            , int inStart, int inEnd, HashMap<Integer, Integer> map) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int value = preorder[preStart];
        TreeNode node = new TreeNode(value);
        int index = map.get(value);
        int rightTreeSize = inEnd - index;
        node.left = DiGUi105(preorder, inorder, preStart + 1, preEnd - rightTreeSize, inStart, inStart + index - 1, map);
        node.right = DiGUi105(preorder, inorder, preEnd - rightTreeSize + 1, preEnd, index + 1, inEnd, map);
        return node;
    }
}