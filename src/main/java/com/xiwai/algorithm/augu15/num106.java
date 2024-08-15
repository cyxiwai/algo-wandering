package com.xiwai.algorithm.augu15;

import java.util.HashMap;

public class num106 {
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