package com.xiwai.algorithm.augu1;

public class num209 {
    public static void main(String[] args) {
        int[] numTest1 = {2, 3, 1, 2, 4, 3};
        int[] numTest2 = {1, 4, 4};
        int[] numTest3 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        int numTest1ans;
        Solution solution = new Solution();

        numTest1ans = solution.minSubArrayLen(7, numTest1);

    }

}

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int slowindex = 0;
        int sum = 0;
        int countnum = 100000;
        int countnumtemp = 0;
        for (int fastindex = 0; fastindex < nums.length; fastindex++) {
            sum += nums[fastindex];

            if ((sum >= target)) {
                while (sum >= target) {
                    countnumtemp = fastindex - slowindex + 1;
//                    第一次在这里漏了个+1导致最后结果必须得+1否则错误
                    if (countnumtemp <= countnum) {
                        countnum = countnumtemp;
                    }
                    sum -= nums[slowindex++];

                }
            }
        }
//        return countnum != 100000 ? countnum +1 : 0;
        return countnum != 100000 ? countnum : 0;

    }

}


