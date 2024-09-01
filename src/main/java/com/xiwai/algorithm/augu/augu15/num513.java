package com.xiwai.algorithm.augu.augu15;

public class num513 {
}

//解法二：递归法

class Solution513_2 {
    public int firstEle = 0;
    public int depthRecord = -1;
    public int findBottomLeftValue(TreeNode root) {


        DiGui513(root, 0);
        return firstEle;
    }

    public void DiGui513(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (depth > depthRecord) {
            firstEle = root.val;
            depthRecord = depth;
        }
        DiGui513(root.left, 1 + depth);
        DiGui513(root.right, 1 + depth);
    }
}
////解法一：迭代法
//class Solution513_1 {
//    public int findBottomLeftValue(TreeNode root) {
//        Deque<TreeNode> deque = new LinkedList<>();
////        HashMap<Integer,Integer> map = new HashMap<>();
//        TreeNode node = root;
//        if (node == null) {
//            return 0;
//        }
//        int levelLength = 0;
//        int firstEle = 0;
////        int depth=0;
//        deque.offer(node);
//        while (!deque.isEmpty()) {
////            if(deque.peek().left==null&& deque.peek().right==null)
//            levelLength = deque.size();
////            node = deque.remove();
//            firstEle = deque.peek().val;
//            for (int i = 0; i < levelLength; i++) {
//                node = deque.remove();
//                if (node.left != null) {
//                    deque.offer(node.left);
//                }
//                if (node.right != null) {
//                    deque.offer(node.right);
//                }
//
//            }
////            depth++;
////            map.put(depth, node.val);
//        }
////        return map.get(depth);
//        return firstEle;
//    }
//
//
//}