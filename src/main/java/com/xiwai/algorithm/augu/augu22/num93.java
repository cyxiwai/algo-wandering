package com.xiwai.algorithm.augu.augu22;

import java.util.ArrayList;
import java.util.List;

public class num93 {
    public static void main(String[] args) {
        Solution93 solution = new Solution93();

        // 测试用例1：标准输入
        System.out.println("Test Case 1: " + solution.restoreIpAddresses("2552"));
        // Expected Output: [255.255.11.135, 255.255.111.35]

        // 测试用例2：最小输入
        System.out.println("Test Case 2: " + solution.restoreIpAddresses("0000"));
        // Expected Output: [0.0.0.0]

        // 测试用例3：包含前导0
        System.out.println("Test Case 3: " + solution.restoreIpAddresses("010010"));
        // Expected Output: [0.10.0.10, 0.100.1.0]

        // 测试用例4：空字符串
        System.out.println("Test Case 4: " + solution.restoreIpAddresses(""));
        // Expected Output: null

        // 测试用例5：长度超过12的输入
        System.out.println("Test Case 5: " + solution.restoreIpAddresses("1111111111111"));
        // Expected Output: []

        // 测试用例6：最小合法长度（4位）
        System.out.println("Test Case 6: " + solution.restoreIpAddresses("1111"));
        // Expected Output: [1.1.1.1]

        // 测试用例7：最大合法长度（12位）
        System.out.println("Test Case 7: " + solution.restoreIpAddresses("111111111111"));
        // Expected Output: [111.111.111.111]
    }
}

class Solution93 {
    List<String> ans = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> restoreIpAddresses(String s) {
        if (s.isEmpty()) {
            return null;
        }
        if (s.length() > 12) {
            return new ArrayList<>();
        }
        backTracing(s, 0, 0);
        return ans;
    }

    public void backTracing(String s, int startIndex, int pointNum) {
        if (pointNum == 3) {
            String lastPart = s.substring(startIndex);
            if (isValid(lastPart)) {
                sb.append(lastPart);
                ans.add(sb.toString());
                sb.delete(sb.length() - lastPart.length(), sb.length());
                return;
            }
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String strTemp = s.substring(startIndex, i + 1);

            if (isValid(strTemp)) {
                sb.append(strTemp).append(".");
                backTracing(s, i + 1, pointNum + 1);
                sb.delete(sb.length() - strTemp.length() - 1, sb.length());
            } else {
                break;
            }
        }

    }

    public boolean isValid(String string) {
        if (string.isEmpty()) {
            return false;
        }
        if (string.length() > 1 && string.charAt(0) == '0') {
            return false;
        }
        int s_ToInt = Integer.parseInt(string);
        if (s_ToInt < 0 || s_ToInt > 255) {
            return false;
        }
        return true;
    }
}
