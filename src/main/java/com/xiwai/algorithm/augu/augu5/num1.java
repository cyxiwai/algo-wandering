package com.xiwai.algorithm.augu.augu5;

import java.util.HashMap;
import java.util.Map;

public class num1 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] testnums = {3,4,2};
        int[] nums = solution1.twoSum(testnums, 6);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}



//有点太过于弱了
//class Solution1 {
//    public int[] twoSum(int[] nums, int target) {
//        Map<Integer, Integer> hashMap = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            hashMap.put(i,nums[i]);
//        }
//        for (int i = 0; i < nums.length; i++) {
//            int temp = target - nums[i];
//            hashMap.remove(i);
//            if (hashMap.containsValue(temp)) {
//                int[] resnums = {i, getKeyByValue(hashMap,temp)};
//                return resnums;
//            }
//            hashMap.put(i,nums[i]);
//        }
//        return null;
//    }
//    public static Integer getKeyByValue(Map<Integer,Integer> map,Integer value)
//    {
//        for(Integer key:map.keySet())
//        {
//            if(map.get(key).equals(value))
//            {
//                return key;
//            }
//        }
//        return null;
//    }
//}
//标准解法，根本不需要进行一次遍历赋值
class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
//        map.getOrDefault()
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                int[] res=new int[2];
                res[0]=i;
                res[1]=map.get(target-nums[i]);
                return res;
            }
            map.put(nums[i],i);
        }
        return null;
    }
}