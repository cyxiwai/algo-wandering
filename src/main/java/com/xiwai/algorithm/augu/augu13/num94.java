package com.xiwai.algorithm.augu.augu13;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class num94 {
    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2, null, treeNode3);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, null);
        Solution94 solution94 = new Solution94();
        List<Integer> test = solution94.postorderTraversal(treeNode1);
        for (Integer i : test) {
            System.out.println(i);
        }

    }
}

class Solution94 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode temp = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                list.add(temp.val);
                temp = temp.right;
            }
        }
        return list;
    }
}
//
//class TreeNode{
//    int val;
//    TreeNode left;
//    TreeNode right;
//    public TreeNode(){};
//    public TreeNode(int i)
//    {
//        this.val=i;
//    }
//    public TreeNode(int i,TreeNode left,TreeNode right)
//    {
//        this.val=i;
//        this.left=left;
//        this.right=right;
//    }
//}