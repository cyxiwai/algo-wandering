package com.xiwai.algorithm.augu13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class num102 {
    public static void main(String[] args) {

        Solution102 solution102 = new Solution102();
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(3, treeNode6, treeNode7);
        TreeNode treeNode2 = new TreeNode(2, treeNode4, treeNode5);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);
        List<List<Integer>> res = solution102.levelOrder(treeNode1);
        for (List<Integer> i : res) {
            for (Integer num : i) {
                System.out.println(num);
            }
        }
    }

}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 * //
 */

//解法二：递归法

class Solution102 {
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
////解法一：队列法
//class Solution102 {
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> res = new ArrayList<>();
//        Queue<TreeNode> queue = new LinkedList<>();
//        TreeNode temp = root;
//        int len = 0;
//        if (temp == null) {
//            return null;
//        }
//        queue.offer(temp);
//        while (!queue.isEmpty()) {
//            List<Integer> ansTemp = new ArrayList<>();
//            len = queue.size();
//            while (len > 0) {
//
//                temp = queue.remove();
//                ansTemp.add(temp.val);
//                if (temp.left != null) {
//                    queue.offer(temp.left);
//                }
//                if (temp.right != null) {
//                    queue.offer(temp.right);
//                }
//                len--;
//            }
//            res.add(ansTemp);
//        }
//        return res;
//    }
//}