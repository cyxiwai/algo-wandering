//package com.xiwai.algorithm.augu13;
//
//import java.util.ArrayList;
//import java.util.Deque;
//import java.util.LinkedList;
//import java.util.List;
//
//public class num429 {
//
//}
//
//
//class Solution429 {
//    public List<List<Integer>> levelOrder(Node root) {
//        Deque<Node> deque = new LinkedList<>();
//        List<List<Integer>> resList = new ArrayList<>();
//        Node temp = new Node();
//        int lenth = 0;
//        if (root == null) {
//            return resList;
//        }
//        deque.offer(root);
//        while (!deque.isEmpty()) {
//            lenth = deque.size();
//            List<Integer> listTemp = new ArrayList<>();
//            for (int i = 0; i < lenth; i++) {
//                temp = deque.remove();
//                listTemp.add(temp.val);
//                if (temp.children != null && !temp.children.isEmpty()) {
//
//                    for (Node node : temp.children) {
//                        deque.offer(node);
//                    }
//                }
//            }
//            resList.add(listTemp);
//        }
//        return resList;
//    }
//}
//
//class Node {
//    public int val;
//    public List<Node> children;
//
//    public Node() {
//    }
//
//    public Node(int _val) {
//        val = _val;
//    }
//
//    public Node(int _val, List<Node> _children) {
//        val = _val;
//        children = _children;
//    }
//}
