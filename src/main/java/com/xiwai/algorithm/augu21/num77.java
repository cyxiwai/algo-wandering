package com.xiwai.algorithm.augu21;

import java.util.ArrayList;
import java.util.List;

public class num77 {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.combine(4,1);
    }
}

class Solution77 {
    public List<Integer> path = new ArrayList<>();
    public List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
//        List<Integer> listIni = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            listIni.add(i+1);
//        } //初始化[1,n]
        backTracing77(n, k, 1);
        return ans;
    }

    public void backTracing77(int n, int k, int startIndex) {
        if (path.size() == k) {
            ans.add(new ArrayList<>(path));//又忘记这样的ans path问题要new一个静态的列表而不是引用类型
            return;
        }
//        剪枝分析：需要k个元素，已经取了path.size个元素，当前区间内有边界-startIndex+1个元素，求边界。
//        边界=startIndex-1+k-path.size 边界右边还有n-边界个元素，则平移可得左边界最大移动范围。
//        即n-startIndex+1-k+path,size
        for (int i = startIndex; i <= n - k + 1 + path.size(); i++) {
            path.add(i);
            backTracing77(n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }
}