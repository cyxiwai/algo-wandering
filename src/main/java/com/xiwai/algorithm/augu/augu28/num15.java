package com.xiwai.algorithm.augu.augu28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class num15 {

}

class Solution15 {
    //    两件事儿：1.取左端点数字，此处有判断逻辑左数>0的话直接左剪枝，去重直接用continue就好
//    2.求和，两数求和，排序数组用双指针法，可以提高效率剪枝，同样剪枝
    public List<List<Integer>> threeSum(int[] nums) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum + nums[i] < 0) {
                    left++;
                } else if (sum + nums[i] > 0) {
                    right--;
                } else {

                    path.add(nums[left]);
                    path.add(nums[right]);
                    ans.add(new ArrayList<>(path));
                    path.remove(path.size() - 1);
                    path.remove(path.size() - 1);
                    while (left < nums.length - 1 && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (right > 0 && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }

            }
            path.clear();
        }
        return ans;
    }
}
