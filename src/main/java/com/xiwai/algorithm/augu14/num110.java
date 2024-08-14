package com.xiwai.algorithm.augu14;

import static java.lang.Math.abs;
import static java.lang.Math.max;

public class num110 {
    public static void main(String[] args) {

    }
}


class Solution110 {

    public boolean isBalanced(TreeNode root) {
        return DiGui110(root) != -1;

    }


    public int DiGui110(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftheight = DiGui110(node.left);
        if (leftheight == -1) return -1;
        int rightheight = DiGui110(node.right);
        if (rightheight == -1) return -1;

        if (abs(leftheight - rightheight) > 1) {
            return -1;
        } else {
            return 1 + max(leftheight, rightheight);
        }
    }

}