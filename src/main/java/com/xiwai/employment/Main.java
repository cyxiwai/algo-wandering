package com.xiwai.employment;


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[n + 1][n + 1];
        for (int i = 0; i < n-1; i++) {
            int m = sc.nextInt();
            int p = sc.nextInt();
            grid[m][p] = 1;
        }
        int[] store = new int[n];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j]--;
                    store[i - 1]++;
                }
            }
        }
        Arrays.sort(store);
        int count = 1;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (store[i] != store[i - 1]) {
                ans += C(count);
                count = 0;
            } else {
                count++;
            }
        }
        ans += C(count);
        System.out.println(ans);
    }

    public static int C(int n) {
        int num = 1;
        for (int i = 2; i <= n; i++) {
            num *= i;
        }
        if (n <= 2) {
            return 1;
        }
        int num2 = 1;

        for (int i = n - 2; i >= 2; i--) {
            num2 *= i;
        }
        return num / (2 * num2);
    }


}
