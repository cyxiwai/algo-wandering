package com.xiwai.algorithm.augu13;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class num145 {
    public static void main(String[] args) {
        Solution145 solution145 = new Solution145();
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(3, treeNode6, treeNode7);
        TreeNode treeNode2 = new TreeNode(2, treeNode4, treeNode5);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);
        List<Integer> res = solution145.postorderTraversal(treeNode1);
        for (Integer i : res) {
            System.out.println(i);
        }
    }
}

class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        if (temp != null) {
            stack.push(temp);
        }
        while (!stack.isEmpty()) {
            temp = stack.pop();
            if (temp != null) {
                stack.push(temp);      // 将当前节点重新压栈
                stack.push(null);      // 压入一个null值作为标记

                // 注意：先压右子节点，再压左子节点
                if (temp.right != null) {
                    stack.push(temp.right);
                }
                if (temp.left != null) {
                    stack.push(temp.left);
                }
            } else {
                temp = stack.pop();  // 弹出栈顶节点（null标记后面的节点）
                res.add(temp.val);   // 将节点值加入结果列表
            }
        }
        return res;
    }
}
//
//class Solution145 {
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode temp = root;
//        if (temp != null) {
//            stack.push(temp);
//        }
//        while (!stack.isEmpty()) {
//            temp = stack.pop();
//            if (temp != null) {
//                stack.push(temp);
//                stack.push(null);
//                if (temp.left != null) {
//                    stack.push(temp.left);
//                }
//                if (temp.right != null) {
//                    stack.push(temp.right);
//                }
//            }
//            else{
//                stack.pop();
//                if(!stack.isEmpty()) {
//                    temp = stack.pop();
//                }
//                if(temp!=null) {
//                    res.add(temp.val);
//                }
//            }
//        }
//        return res;
//    }
//}
