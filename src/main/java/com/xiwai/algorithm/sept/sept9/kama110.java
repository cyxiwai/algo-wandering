package com.xiwai.algorithm.sept.sept9;

import jdk.nashorn.internal.runtime.ListAdapter;

import java.util.*;

public class kama110 {
    //    public static int[][] dir= {{0,1},{1,0},{0,-1},{-1,0}};
    public static int bfs(List<String> dic, String startStr, String endStr) {
        HashSet<String> set = new HashSet<>(dic);

        Queue<String> queue = new LinkedList<String>();

        HashMap<String, Integer> map = new HashMap<>();
        queue.add(startStr);
        map.put(startStr, 1);
        while (!queue.isEmpty()) {
            String curWord = queue.poll();
            int path = map.get(curWord);
            for (int i = 0; i < curWord.length(); i++) {
                char[] ch = curWord.toCharArray();
                for (char k = 'a'; k <= 'z'; k++) {
                    ch[i] = k;
                    String newWord = new String(ch);
                    if (newWord.equals(endStr)) {
                        return path + 1;
                    }
                    if (!map.containsKey(newWord) && set.contains(newWord)) {
                        map.put(newWord, path + 1);
                        queue.add(newWord);
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] strs = sc.nextLine().split(" ");
        List<String> dic = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            dic.add(sc.nextLine());
        }
        int ans = bfs(dic, strs[0], strs[1]);
        System.out.println(ans);
    }
}
