package com.xiwai.algorithm.augu.augu16;

public class num617 {
}

class Solution617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        return DiGui617(root1, root2);
    }


//    递归思路：对根节点进行累加，左子树递归处理左根和他的左右子树，右子树处理右根和它的左右子树
//    处理根就是单层递归的逻辑，即node1.val+node2.val
//    遍历到null，每个节点都要求到，所以用if（node==null）条件 ps：若叶子，则是left=right=null


    public TreeNode DiGui617(TreeNode node1, TreeNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        TreeNode temp = new TreeNode(node1.val + node2.val);
        temp.left = DiGui617(node1.left, node2.left);
        temp.right = DiGui617(node1.right, node2.right);
        return temp;
    }
}