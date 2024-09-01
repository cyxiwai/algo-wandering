package com.xiwai.algorithm.augu.augu13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class num107 {
    public static void main(String[] args) {

    }
}

class Solution107 {
    public List<List<Integer>> resList = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        int deep=0;
        DiGui107(root,deep);
        Collections.reverse(resList);
        return resList;
    }
    public void DiGui107(TreeNode root,int deep)
    {
        if(root==null)
        {
            return ;
        }
        deep++;
        if(resList.size()<deep)
        {
            List<Integer> temp = new ArrayList<>();
            resList.add(temp);
        }
        resList.get(deep-1).add(root.val);
        DiGui107(root.left,deep);
        DiGui107(root.right,deep);
    }

}