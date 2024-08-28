package com.xiwai.augu28;

public class num13 {
}

//
//例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27
// 写做  XXVII, 即为 XX + V + II 。
//
//通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不
// 写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
//
//I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
//X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
//C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
class Solution13 {
    public int romanToInt(String s) {
        char[] s_toCh = s.toCharArray();
        int ans = 0;
        int[] used = new int[s.length()];
        for (int i = s_toCh.length - 1; i >= 0; i--) {
            if (used[i] == 1) {
                continue;
            }
            if (s_toCh[i] == 'I') {
                ans += 1;
            }
            if (s_toCh[i] == 'V') {
                if (i > 0 && s_toCh[i - 1] == 'I') {
                    ans += 4;
                    used[i - 1] = 1;
                } else
                    ans += 5;
            }
            if (s_toCh[i] == 'X') {
                if (i > 0 && s_toCh[i - 1] == 'I') {
                    ans += 9;
                    used[i - 1] = 1;

                } else
                    ans += 10;
            }
            if (s_toCh[i] == 'L') {
                if (i > 0 && s_toCh[i - 1] == 'X') {
                    ans += 40;
                    used[i - 1] = 1;
                } else
                    ans += 50;
            }
            if (s_toCh[i] == 'C') {
                if (i > 0 && s_toCh[i - 1] == 'X') {
                    ans += 90;
                    used[i - 1] = 1;

                } else
                    ans += 100;
            }
            if (s_toCh[i] == 'D') {
                if (i > 0 && s_toCh[i - 1] == 'C') {
                    ans += 400;
                    used[i - 1] = 1;
                } else
                    ans += 500;
            }
            if (s_toCh[i] == 'M') {
                if (i > 0 && s_toCh[i - 1] == 'C') {
                    ans += 900;
                    used[i - 1] = 1;

                } else
                    ans += 1000;
            }

        }
        return ans;
    }
}