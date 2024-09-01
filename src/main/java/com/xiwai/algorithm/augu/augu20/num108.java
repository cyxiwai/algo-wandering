package com.xiwai.algorithm.augu.augu20;

import java.util.Arrays;

public class num108 {
    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[] nums = new int[3];
//        int index = 0;
//        for (int i : nums) {
//            nums[i] = i;
//        }
//        solution.DiGui108(nums);
    }
}

class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return DiGui108(nums);
    }

    //    递归思路；
//    1.确定参数返回值
//    此题涉及树的构造，则有左右的赋值环节，那么将节点作为返回值比较好，参数则是数组，根节点实质上是数组的中点
//    2.确定终止条件，java自带库函数，nums.length==-1，遍历到没有时，用null值赋给上个节点。
//    3.单层逻辑
//    找中点，偶终点就会出现两个树，区间用左闭右闭好了，比较熟悉。
//    找中点流程：n个元素，0～n-1的索引，奇数中点就是n-1/2，偶数就是n-1/2和n+1/2
//    题意只要找一棵树，所以偶数也按照n-1/2的逻辑进行处理
//    左区间[0,n-1/2-1],右区间[n-1/2+1,n-1]
//    nums.length--,nums.length/2
//    这里是不是可以更改终止逻辑判断了？
//    开写
    public TreeNode DiGui108(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int mid = (nums.length - 1) / 2;
        TreeNode node = new TreeNode(nums[mid]);


        node.left = DiGui108(Arrays.copyOfRange(nums, 0, mid));
        node.right = DiGui108(Arrays.copyOfRange(nums, mid + 1, nums.length));

        return node;
    }


}