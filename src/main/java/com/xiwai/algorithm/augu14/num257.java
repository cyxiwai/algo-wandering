package com.xiwai.algorithm.augu14;

import java.util.ArrayList;
import java.util.List;

public class num257 {
}


class Solution257 {
    List<String> resList = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        DiGUi257(root, path, resList);
        return resList;
    }

    public void DiGUi257(TreeNode node, List<Integer> path, List<String> resList) {
        path.add(node.val);
        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                sb.append(path.get(i)).append("->");
            }
            sb.append(path.get(path.size() - 1));
            resList.add(sb.toString());
            return;
        }

        if (node.left != null) {
            DiGUi257(node.left, path, resList);
            path.remove(path.size() - 1);
        }

        if (node.right != null) {
            DiGUi257(node.right, path, resList);
            path.remove(path.size() - 1);
        }

    }
}