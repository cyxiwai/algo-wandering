package com.xiwai.employment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class JDtest2 {
    public static void main(String[] args) {
        //使用哈希表来存放字母优先级，通过取value比较字符
        //使用判断相同字符函数，返回值为int，数值代表相同字符，判断前缀在主函数中判断，若相等于短字符串，则排前
        //如何维护排序字符串顺序呢？需要特定一个插入的函数啊复杂度好高
        Scanner sc = new Scanner(System.in);
        HashMap<Character, Integer> map = new HashMap<>();
        String s = sc.nextLine();
        char[] s_toChar = s.toCharArray();
        for (int i = 0; i < 26; i++) {
            map.put(s_toChar[i], i);
        }
        int n = sc.nextInt();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i]=sc.nextLine();
        }
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            int index=0;
            for (int j = 0; j < ans.length; j++) {
                int index2=0;
                if(strings[i].charAt(0)==ans[j].charAt(0)){

                }
                    else if(map.get(strings[i].charAt(0))<map.get(ans[j].charAt(0)))
                {
                    index=j-1;
                }
            }
            ans[index]=new String(strings[i]);
        }
    }
}
