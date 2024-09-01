package com.xiwai.algorithm.augu.augu4;

public class test80 {
    public static void main(String[] args) {
        Solution80 solution=new Solution80();
        int[] nums={0,1,1,1,1,1,2,3,3};
        System.out.println(solution.removeDuplicates(nums));
    }
}

class Solution80 {
    public int removeDuplicates(int[] nums) {
        int fastindex = 0;
        int slowindex = 0;
        int index1 = 0;
        int index2 = 0;


        for (; fastindex < nums.length; fastindex++) {
            if (index2<2 & nums[fastindex] == nums[slowindex]) {
                    while(nums[fastindex]==nums[slowindex])
                    {
                        if(index1==1)
                        {break;}

                    }
                    index2++;

            } else {
                nums[++slowindex] = nums[fastindex];
            }
        }
        return ++slowindex;
    }
}
