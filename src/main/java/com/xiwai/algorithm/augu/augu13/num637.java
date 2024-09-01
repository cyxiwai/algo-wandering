package com.xiwai.algorithm.augu.augu13;

import java.util.ArrayList;
import java.util.List;

public class num637 {
    public static void main(String[] args) {
        Solution637 solution637 = new Solution637();
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(3, treeNode6, treeNode7);
        TreeNode treeNode2 = new TreeNode(2, treeNode4, treeNode5);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);
        List<Double> res = solution637.averageOfLevels(treeNode1);
        for (Double i : res) {
            System.out.println(i);
        }
    }
}

class Solution637 {
    public List<Double> resList = new ArrayList<>();
    public List<List<Integer>> resTemp = new ArrayList<>();

    public List<Double> averageOfLevels(TreeNode root) {
        int deep = 0;
        DiGui637(root, deep);
        long sum = 0;
        int index = 0;
        for (List<Integer> list : resTemp) {
            for (int i : list) {
                sum += i;
                index++;
            }
            double temp = (double) sum / index;
            sum = 0;
            index = 0;
            resList.add(temp);
//            resList.add((Double) (sum/index));

        }
        return resList;
//        TreeNode temp = root;
    }

    public void DiGui637(TreeNode root, int deep) {
        if (root == null) {
            return;
        }
        deep++;
        if (resTemp.size() < deep) {
            List<Integer> listTemp = new ArrayList<>();
            resTemp.add(listTemp);
        }
//        listTemp.add(root.val);
        resTemp.get(deep - 1).add(root.val);
        DiGui637(root.left, deep);

        DiGui637(root.right, deep);
    }
}