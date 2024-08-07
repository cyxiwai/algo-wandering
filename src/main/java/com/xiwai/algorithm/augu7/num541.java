package com.xiwai.algorithm.augu7;

public class num541 {
    public static void main(String[] args) {
        Solution541 solution541 = new Solution541();
        String s = "abcdefg";
        System.out.println(solution541.reverseStr(s, 2));
    }

}

class Solution541 {
    public String reverseStr(String s, int k) {
        char[] sToChar = s.toCharArray();
        for (int i = 0; i < sToChar.length; i += (2 * k)) {
            int start = i;
            int end = Math.min(sToChar.length - 1, start + k - 1);
            while (start < end) {
                char temp = sToChar[end];
                sToChar[end] = sToChar[start];
                sToChar[start] = temp;
                start++;
                end--;
            }
        }
        return new String(sToChar);
    }
}

//
//class Solution541 {
//    public String reverseStr(String s, int k) {
//
//        char[] sCharArray = s.toCharArray();
//        int slowIndex = 0;
//
//        for (int i = 0; i < sCharArray.length; i += 2 * k) {
//            slowIndex=i;
//            if(sCharArray.length-i-1<2*k)
//            {
//                break;
//            }
//            for (int fastIndex = i + k - 1 ; fastIndex > i+(k-1)/2; fastIndex--) {
//                char temp;
//                temp=sCharArray[fastIndex];
//                sCharArray[fastIndex]=sCharArray[slowIndex];
//                sCharArray[slowIndex]=temp;
//            }
//        }
//
//        return new String(sCharArray);
//    }

    //写的不太好