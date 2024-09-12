package com.xiwai.employment;

import java.util.Arrays;
import java.util.Scanner;

public class septtest3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] preX = new int[num];
        int[] preY = new int[num];
        int[] paperX = new int[num];
        int[] paperY = new int[num];

        for (int i = 0; i < num; i++) {
            preX[i] = sc.nextInt();
            preY[i] = sc.nextInt();
            paperX[i] = sc.nextInt();
            paperY[i] = sc.nextInt();
        }
        Arrays.sort(preX);
        Arrays.sort(preY);
        Arrays.sort(paperX);
        Arrays.sort(paperY);
        int k = 1;
        for (int i = num - 1; i >= 0; i--) {
            while (k * paperX[i] < preX[i]) {
                k++;
            }
        }
        for (int i = num - 1; i >= 0; i--) {
            while (k * paperY[i] < preY[i]) {
                k++;
            }
        }
        System.out.println(k);
    }
}
