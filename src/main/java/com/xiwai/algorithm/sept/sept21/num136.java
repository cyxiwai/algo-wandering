package com.xiwai.algorithm.sept.sept21;

public class num136 {
}
class Solution136 {
    public int singleNumber(int[] nums) {
        int single = 0;
        for(int num : nums)
        {
            single^=num;
        }
        return single;
    }
}