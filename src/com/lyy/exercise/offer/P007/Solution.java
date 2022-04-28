package exercise.leetcode.offer.P007;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
题目限制：0 <= 节点个数 <= 5000
测试样例
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]

Input: preorder = [-1], inorder = [-1]
Output: [-1]
 */

public class Solution {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        Solution ob = new Solution();
        TreeNode head = ob.buildTree(preorder, inorder);

        TreeNode father = head;
//        head.left = new TreeNode();
//        head.right = new TreeNode();
//        TreeNode leftSon = head.left;
//        TreeNode rightSon = head.right;

        //一段仅用于测试的赋值
        father.val = 3;
        father.left = new TreeNode(9);
        father.right = new TreeNode(20);
        father.right.left = new TreeNode(15);
        father.right.right = new TreeNode(7);

        //二叉树的层序遍历：使用队列，将节点压入队列判断队列是否为空
        //前序遍历、中序遍历以及后序遍历，递归实现，只需在前输出val，中间输出val，最后输出val
        //JAVA中使用Queue，要使用LinkedList，Queue并没直接实现队列的接口，但是LinkedList有实现，Stack并不用
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (father != null) {
            queue.offer(father);
        }
        while (!queue.isEmpty()) {
            TreeNode nowNode = queue.peek();
            System.out.print(nowNode.val + " ");

            if (nowNode.left != null) {
                queue.offer(nowNode.left);
            }
            if (nowNode.right != null) {
                queue.offer(nowNode.right);
            }
            queue.poll();
        }
    }


    //重写题解中的递归思路
    //建立一个哈希表使得在中序遍历中寻找根节点的速度更快
    private Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //一个便于思考的例子，前序遍历：3 9 15 7 20，中序遍历：15 9 7 3 20

        //得到节点长度
        int n = preorder.length;
        //构造中序遍历的哈希映射
        map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return myRecursionBuildTree(preorder, inorder, 0, n-1, 0, n-1);
    }

    public TreeNode myRecursionBuildTree(int[] preorder, int[] inorder, int pre_left, int pre_right, int in_left, int in_right) {
        if (pre_left > pre_right) {
            return null;
        }

        int pre_root = pre_left;
        //在中序遍历中找到根节点
        int in_root = map.get(preorder[pre_root]);
        TreeNode root = new TreeNode(preorder[pre_root]);
        //构造左子树
        int size_left = in_root - in_left;
        root.left = myRecursionBuildTree(preorder, inorder, pre_left+1, pre_left+size_left, in_left, in_root-1);
        //构造右子树
        root.right = myRecursionBuildTree(preorder, inorder, pre_left+size_left+1, pre_right, in_root+1, in_right);
        return root;
    }

    //递归法
//    private Map<Integer, Integer> indexMap;
//
//    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
//        if (preorder_left > preorder_right) {
//            return null;
//        }
//
//        // 前序遍历中的第一个节点就是根节点
//        int preorder_root = preorder_left;
//        // 在中序遍历中定位根节点
//        int inorder_root = indexMap.get(preorder[preorder_root]);
//
//        // 先把根节点建立出来
//        TreeNode root = new TreeNode(preorder[preorder_root]);
//        // 得到左子树中的节点数目
//        int size_left_subtree = inorder_root - inorder_left;
//        // 递归地构造左子树，并连接到根节点
//        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
//        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
//        // 递归地构造右子树，并连接到根节点
//        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
//        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
//        return root;
//    }
//
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        int n = preorder.length;
//        // 构造哈希映射，帮助我们快速定位根节点
//        indexMap = new HashMap<Integer, Integer>();
//        for (int i = 0; i < n; i++) {
//            indexMap.put(inorder[i], i);
//        }
//        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
//    }

    //迭代法
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        if (preorder == null || preorder.length == 0) {
//            return null;
//        }
//        TreeNode root = new TreeNode(preorder[0]);
//        Deque<TreeNode> stack = new LinkedList<TreeNode>();
//        stack.push(root);
//        int inorderIndex = 0;
//        for (int i = 1; i < preorder.length; i++) {
//            int preorderVal = preorder[i];
//            TreeNode node = stack.peek();
//            if (node.val != inorder[inorderIndex]) {
//                node.left = new TreeNode(preorderVal);
//                stack.push(node.left);
//            } else {
//                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
//                    node = stack.pop();
//                    inorderIndex++;
//                }
//                node.right = new TreeNode(preorderVal);
//                stack.push(node.right);
//            }
//        }
//        return root;
//    }
}
