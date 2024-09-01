package com.xiwai.algorithm.augu.augu13;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class num515 {
    public static void main(String[] args) {
        Solution515 solution515 = new Solution515();
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(3, treeNode6, treeNode7);
        TreeNode treeNode2 = new TreeNode(2, treeNode4, treeNode5);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);
        List<Integer> res = solution515.largestValues(treeNode1);
        for (Integer i : res) {
            System.out.println(i);
        }
    }
}


class Solution515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root == null) {
            return resList;
        }
        TreeNode temp = root;
        deque.offer(temp);
        int lenth = 0;
        while (!deque.isEmpty()) {
            lenth = deque.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < lenth; i++) {
                temp = deque.remove();
                max = Math.max(temp.val, max);
                if (temp.left != null) {
                    deque.offer(temp.left);
                }
                if (temp.right != null) {
                    deque.offer(temp.right);
                }
            }
            resList.add(max);
        }


        return resList;

    }
}
