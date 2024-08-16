package com.xiwai.algorithm.augu16;

import java.util.Arrays;
import java.util.TreeMap;

public class num654 {
}

class Solution654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return DiGui654(nums);
        
    }

    
    public TreeNode DiGui654(int[] nums)
    {
        TreeNode node = new TreeNode(nums[findMax(nums)]);

        if(nums.length==1)
        {
            node.val=nums[0];
            return node;
        }
        int maxIndex = findMax(nums);
        if(maxIndex>0) {
            node.left = DiGui654(Arrays.copyOfRange(nums, 0, maxIndex));
        }
        if(maxIndex<nums.length-1)
        {
            node.right= DiGui654(Arrays.copyOfRange(nums,maxIndex+1,nums.length));
        }


        return node;
    }
    public int findMax(int[] nums) {
        int res = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[index]) {
                index = i;
            }
        }
        return index;
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