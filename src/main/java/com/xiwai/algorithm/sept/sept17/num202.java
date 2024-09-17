package com.xiwai.algorithm.sept.sept17;

import java.util.HashSet;

public class num202 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isHappy(19);
    }
}

class Solution {
    public boolean isHappy(int n) {
        int temp = n;
        HashSet<Integer> set = new HashSet<>();
        while (!set.contains(temp)) {
            set.add(temp);
            temp = getSum(temp);
        }
        if (temp == 1) {
            return true;
        } else {
            return false;
        }

    }

    public int getSum(int n) {
        int res = 0;
        while (n != 0) {
            int temp = (n % 10) * (n % 10);
            res += temp;
            n /= 10;
        }
        return res;
    }
}
