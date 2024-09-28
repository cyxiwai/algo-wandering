package com.xiwai.employment.huawei;

import java.util.Scanner;

import java.util.*;

public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> input = new ArrayList<>();
        HashMap<List<Integer>, Integer> map = new HashMap<>();
        int n = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 0; i < n / k; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < k; j++) {
                temp.add(sc.nextInt());
            }
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            input.add(new ArrayList<>(temp));
        }
        Set<List<Integer>> visited = new HashSet<>();
        for (int i = 0; i < n / k - 1; i++) {
            if (!visited.contains(input.get(i))) {
                for (int j = 0; j < k; j++) {
                    System.out.print(input.get(i).get(j) + " ");
                }
                System.out.print(map.get(input.get(i)) + " ");
                visited.add(input.get(i));
            }
        }
        if (!visited.contains(input.get(n / k - 1))) {
            for (int j = 0; j < k; j++) {
                System.out.print(input.get(n / k - 1).get(j) + " ");
            }
            System.out.print(map.get(input.get(n / k - 1)));
        }
    }
}
