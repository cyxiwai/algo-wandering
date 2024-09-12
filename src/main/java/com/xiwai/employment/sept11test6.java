package com.xiwai.employment;

import java.util.Scanner;

//求是否有三角形，若有是否相似
//求第一条边和三角形二的lmn三边比例得到ijk
//用ijk分别乘三角形一的二/三两边
//用这个数去比较剩下两条边
public class sept11test6 {
    public static int isSimilar(double[] tri1, double[] tri2) {
        double[] temp1 = new double[3];
        for (int i = 0; i < 3; i++) {
            temp1[i] = tri2[i] / tri1[0];
            for (int j = 0; j < 3; j++) {
                if (j == i) {
                    continue;
                } else {
                    long tempF = (long) (tri1[j] * temp1[i]);
                    for (int k = 0; k < 3; k++) {
                        if (k == i) {
                            continue;
                        } else {
                            if (tempF == (long) (tri2[k])) {
                                for (int l = 0; l < 3; l++) {
                                    if (l != k && l != i) {
                                        for (int m = 0; m < 3; m++) {
                                            if (m != 0 && m != j) {
                                                long tempS = (long) (temp1[i] * tri1[m]);
                                                if (tempS == tri2[l]) {
                                                    return 1;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    public static boolean isTri(double[] tri) {
        if (tri[0] >= tri[1] + tri[2]) {
            return false;
        }
        if (tri[1] >= tri[0] + tri[2]) {
            return false;
        }
        if (tri[2] >= tri[1] + tri[0]) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        double[] test1 = {1, 2, 3}, test2 = {6, 4, 2};
        Scanner sc = new Scanner(System.in);
        System.out.println(isTri(test1));
        double[] tri1 = new double[3];
        double[] tri2 = new double[3];
        for (int i = 0; i < 3; i++) {
            tri1[i] = sc.nextInt();
        }
        int num = sc.nextInt();
        int temp = num;
        int[] ans = new int[num];

        while (temp-- > 0) {
            for (int i = 0; i < 3; i++) {
                tri2[i] = sc.nextInt();
            }
            ans[num - 1 - temp] = isTri(tri2) ? isSimilar(tri1, tri2) : 2;
        }
        for (int i = 0; i < num; i++) {
            switch (ans[i]) {
                case 0:
                    System.out.println("Can form a triangle but not similar");
                    break;
                case 1:
                    System.out.println("similar");
                    break;
                case 2:
                    System.out.println("Cannot form a triangle");
                    break;
            }
        }
    }
}
