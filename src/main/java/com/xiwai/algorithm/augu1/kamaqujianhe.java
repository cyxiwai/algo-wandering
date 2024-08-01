package com.xiwai.algorithm.augu1;


import java.util.Scanner;

public class kamaqujianhe {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int elementNum = sc.nextInt();
//        System.out.println("元素个数为 " + elementNum);
        int[] ArrayForTest = new int[elementNum];
        int[] sumArray = new int[elementNum + 1];
//        sumArray[0] = 0;
        for (int i = 0; i < elementNum; i++) {
            ArrayForTest[i] = sc.nextInt();
        }
        for (int j = 0; j < elementNum; j++) {
            sumArray[j+1]=sumArray[j]+ArrayForTest[j];
        }

        int a = 0;
        int b = 0;
//        System.out.println(a + " " + b);
//        System.out.println(cal(sumArray, a, b));
        while (sc.hasNextInt()) {
            a = sc.nextInt();
            b = sc.nextInt();
            System.out.println(cal(sumArray, a, b));
        }
    }


    public static int cal(int[] sum, int a, int b) {
        return sum[b+1] - sum[a];
    }
}

