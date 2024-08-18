package com.xiwai.algorithm.augu17;

public class num530 {
}


class Solution530 {
    TreeNode pre;
    public int result = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        DiGui530(root);
        return result;
    }

    public void DiGui530(TreeNode node)
    {
        if(node==null)
        {
            return;
        }
        DiGui530(node.left);
        if(pre!=null)
        {
            result=Math.min(result,Math.abs(node.val-pre.val));
        }
        pre=node;
        DiGui530(node.right);

    }
}





class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}