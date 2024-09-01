package com.xiwai.algorithm.augu.augu13;

import java.util.Deque;
import java.util.LinkedList;

public class num111 {
}

class Solution111 {
    public int minDepth(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        int depth = 0;
        if (root == null) {
            return depth;
        }
        TreeNode temp = root;
        deque.offer(temp);
        int levelLength = 0;
        while (!deque.isEmpty()) {
            depth++;
            levelLength = deque.size();
            for (int i = 0; i < levelLength; i++) {
                temp = deque.remove();
                if (temp.left == null && temp.right == null) {
                    return depth;
                }
                if (temp.left != null) {
                    deque.offer(temp.left);
                }
                if (temp.right != null) {
                    deque.offer(temp.right);
                }
            }
        }
        return depth;
    }
}
