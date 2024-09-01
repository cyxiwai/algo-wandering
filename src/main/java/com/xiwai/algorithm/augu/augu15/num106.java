package com.xiwai.algorithm.augu.augu15;

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

    public TreeNode DiGui106_2(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, HashMap<Integer, Integer> map) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        int value = postorder[postEnd];
        TreeNode root = new TreeNode(value);
        int index = map.get(value);

//        假设一个数组总长为10，则end为9，start为0，若中间第四个为index（3），
//        首先，左闭右闭区间内的元素个数 = 右区间点索引 - 左区间点索引 + 1
//        index左（不包含自己）共有（index - 1 - start + 1）=3 - 1 - 0 + 1 个元素
//                区间点为start = 0 和index - 1 = 2
//        左闭右闭不计index本身，则左区间为0，1，2，即start，index - 1
//        index右共有end - index=9 - 3 个元素
//        右区间为456789，即index + 1，end
//        同样的index，前序左区间要去掉根节点，而左右区间大小与中序一致，
//        即大小要满足index - instart和inend - index
//        左子树：
//        而前序左区间是每一次迭代往后走一个，左区间大小需要一致，则有
//        左区间点prestart + 1，右区间点 = 区间大小 + 左区间点 - 1
//        则有右 = index - instart + prestart，
//        即prestart + 左子树大小
//        又因为左子树 = 总和 - 右子树，即preend - prestart -（inend - index）
//        故右 = preend - 右子树大小
//        右子树：
//        同理可得右子树推导关系，右子树右区间点为preend，右区间大小为inend - index
//        则右子树左区间点有关系：inend - index = preend - 左 + 1
//        则左区间点 = preend - 右子树 + 1
//        又有preend - prestart=除index外元素个数总和，因此右子树 = 总和 - 左子树
//        即preend -（preend - prestart - （index - instart））+1 =
//                prestart + index - instart + 1
//        又即prestart + 左子树大小 + 1
//
//
//        由以上基础，继续推导后序区间点问题
//        后序不影响中序左右子树的大小划分，故依旧有左子树 = index - inStart
//        右子树 = inend - instart
//        后序左子树左区间点为poststart，左子树大小为index - instart，
//        又有右 - 左 + 1 = size
//        故右区间点 = poststart + 左子树 - 1
//        又因为左子树 + 右子树 = preend - poststart
//        故左子树 = preend - poststart - 右子树
//        则有右区间点 = preend - 1 - 右子树
//        右子树：右区间点为preend - 1，右子树大小为inend - instart
//        又有右 - 左 + 1 = size
//        则有preend - 1 - 左 + 1 = 右子树，即左 = preend - 右子树
//        又有preend - poststart = 左子树 + 右子树
//        则 = preend - preend + poststart + 左子树 = poststart + 左子树
//
//
//        综上所述，本题的区间范围一共可以划分四个，依次是
//        前序中序：
//        1. 前序左：prestart + 1，prestart + 左子树
//        prestart + 1，preend - 右子树
//        2. 前序右：preend - 右子树 + 1，preend
//        prestart + 左子树 + 1，preend
//        后序中序：
//        1. 后序左：poststart，poststart + 左子树 - 1
//        poststart，postend - 右子树 - 1
//        2. 后序右：poststart + 左子树，postend - 1
//        postend-右子树，postend - 1

        int leftTreeSize = index - inStart;
        int rightTreeSize = inEnd-index;
        root.left = DiGui106_2(inorder, inStart, index - 1, postorder, postStart, postEnd-rightTreeSize-1, map);
        root.right = DiGui106_2(inorder, index + 1, inEnd, postorder, postEnd-rightTreeSize, postEnd - 1, map);
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