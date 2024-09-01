package com.xiwai.algorithm.augu.augu13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class num199 {
}


class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int len = 0;
        if (root == null) {
            return list;
        }
        TreeNode temp = root;
        queue.offer(temp);
        while (!queue.isEmpty()) {
            len = queue.size();
            while (len > 0) {
                temp = queue.remove();
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
                len--;
            }
            list.add(temp.val);
        }
        return list;
    }
}