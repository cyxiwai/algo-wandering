package com.xiwai.algorithm.augu.augu5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class num349 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        int temp = 0;
        int sum=0;
        while((test/10)!=0)
        {
            temp=test/10;
            test%=10;
            sum+=(test*test);
            test=temp;
        }
        sum+=(test*test);
        System.out.println(sum);
    }
}
class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length==0||nums2.length==0)
        {
            return new int [0];
        }
        int[] hash1=new int[1003];
        int[] hash2=new int[1003];
        for(int i:nums1)
        {
            hash1[i]++;
        }
        for(int i:nums2)
        {
            hash2[i]++;
        }
        List<Integer> resultlist = new ArrayList<>();
        for(int i = 0;i<1003;i++)
        {
            if(hash1[i]>0&&hash2[i]>0)
            {
                resultlist.add(i);
            }
        }
        int index=0;
        int[] resArray= new int[resultlist.size()];
        for(int i :resultlist)
        {
            resArray[index++]=i;
        }
        return resArray;
    }
}