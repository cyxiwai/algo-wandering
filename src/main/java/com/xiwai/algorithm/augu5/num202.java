package com.xiwai.algorithm.augu5;

import java.util.HashSet;
import java.util.Set;

public class num202 {
    public static void main(String[] args) {
        Solution202 solution202 = new Solution202();
        System.out.println(solution202.isHappy(19));

    }
}

class Solution202 {
    public boolean isHappy(int n) {
        int temp = 0;
        int sum = 0;
        Set<Integer> HashSet = new HashSet<>();
        while (true) {

            while ((n / 10) != 0) {
                temp = n / 10;
                n %= 10;
                sum += (n * n);
                n = temp;
            }
            sum += (n * n);
            n = sum;
            sum = 0;
            if (n == 1) {
                return true;
            }
            if (!(HashSet.contains(n))) {
                HashSet.add(n);
            } else {
                break;
            }
        }
        return false;

    }
}