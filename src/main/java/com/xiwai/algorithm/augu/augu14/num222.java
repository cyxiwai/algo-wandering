package com.xiwai.algorithm.augu.augu14;

public class num222 {
    public static void main(String[] args) {
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(3, treeNode6, treeNode7);
        TreeNode treeNode2 = new TreeNode(2, treeNode4, treeNode5);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);
        Solution222 solution222 = new Solution222();
        System.out.println(solution222.countNodes(treeNode1));
    }
}

class Solution222 {
    //    方法一：使用类变量
//    private int count=0;
    public int countNodes(TreeNode root) {
//        count = 0;
//        DiGui222(root);
        return DiGui222(root);
    }

    //方法二：返回count值，在返回值中每次累加1
    public int DiGui222(TreeNode node) {
        if (node == null) {
            return 0;
        }
//        count++;

        return 1 + DiGui222(node.left) + DiGui222(node.right);
    }
}