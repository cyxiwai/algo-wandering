package com.xiwai.algorithm.augu.augu30;

public class num3153 {
    public static void main(String[] args) {
        int[] test = {12, 13, 23};
        Solution solution = new Solution();
        System.out.println(solution.sumDigitDifferences(test));
    }
}

class Solution {
    public long sumDigitDifferences(int[] nums) {
        long res = 0;
        while (nums[0] > 0) {
            int[] temp = new int[10];
            for (int i = 0; i < nums.length; i++) {
                temp[nums[i] % 10]++;
                nums[i] /= 10;
            }
            for (int i = 0; i < 10; i++) {
                res += (long) (nums.length - temp[i]) * temp[i];
            }


        }

        return res;
    }


}

class Solution3153 {
    public long sumDigitDifferences(int[] nums) {
        int totalLength = 0;
        int size = get_bit(nums[0]).length;
        for (int num : nums) {
            totalLength += get_bit(num).length;
        }
        int[] totalNums = new int[totalLength];
        int currentIndex = 0;
        for (int num : nums) {
            int[] bitArray = get_bit(num);
            System.arraycopy(bitArray, 0, totalNums, currentIndex, bitArray.length);
            currentIndex += bitArray.length;
        }
        int ans = 0;
        for (int i = 0; i < totalLength; i++) {
            for (int j = 1; j < nums.length - (i / size); j++) {
                if (totalNums[i] != totalNums[i + j * size]) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public int[] get_bit(int num) {
        int count = 1;
        int temp = num;
        while ((temp /= 10) != 0) {
            count++;
        }
        int[] bit = new int[count];
        while (count != 0) {
            bit[(count--) - 1] = num % 10;
            num /= 10;
        }
        return bit;
    }
}
