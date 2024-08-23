package com.xiwai.algorithm.augu23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//
//public class num47 {
//    public static void main(String[] args) {
//
//
//        Solution solution = new Solution();
//
//        // Test case 1: Example with duplicates
//        int[] nums1 = {1, 1, 2};
//        List<List<Integer>> permutations1 = solution.permuteUnique(nums1);
//        System.out.println("Test case 1: [1, 1, 2]");
//        for (List<Integer> perm : permutations1) {
//            System.out.println(perm);
//        }
//
//        // Test case 2: No duplicates
//        int[] nums2 = {1, 2, 3};
//        List<List<Integer>> permutations2 = solution.permuteUnique(nums2);
//        System.out.println("Test case 2: [1, 2, 3]");
//        for (List<Integer> perm : permutations2) {
//            System.out.println(perm);
//        }
//
//        // Test case 3: All elements are the same
//        int[] nums3 = {2, 2, 2};
//        List<List<Integer>> permutations3 = solution.permuteUnique(nums3);
//        System.out.println("Test case 3: [2, 2, 2]");
//        for (List<Integer> perm : permutations3) {
//            System.out.println(perm);
//        }
//
//        // Test case 4: Larger input with duplicates
//        int[] nums4 = {1, 2, 2, 3};
////        List<List<Integer>> permutations4 = solution.permuteUnique(nums4);
//        System.out.println("Test case 4: [1, 2, 2, 3]");
////        for (List<Integer> perm : permutations4) {
////            System.out.println(perm);
//        }
//    }
//}


class Solution47 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backTracing(nums, used);
        return ans;
    }

    public void backTracing(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            if (!used[i]) {
                used[i] = true;
                path.add(nums[i]);
                backTracing(nums, used);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }

    }
}