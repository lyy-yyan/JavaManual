package homework;

import java.util.*;

/*
测试样例
输入：7
输出：[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
 */

public class Homework_1204_01 {

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {

        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<TreeNode> helper(List<TreeNode> list,int n){
        if(n==1) {//截至条件
            TreeNode t = new TreeNode(0);
            t.left = null;
            t.right = null;
            list.add(t);
            return list;
        }
        for(int i = 1;i<n;i=i+2) {//左右子树的递归
            List<TreeNode> p1 = new ArrayList<TreeNode>();
            List<TreeNode> p2 = new ArrayList<TreeNode>();
            int j = n-i-1;
            p1 = helper(p1,i);
            p2 = helper(p2,j);
            for(TreeNode t1:p1) {//左右子树的整合
                for(TreeNode t2:p2) {
                    TreeNode temp = new TreeNode(0);
                    temp.left = t1;
                    temp.right = t2;
                    list.add(temp);
                }
            }
        }
        return list;
    }
    public List<TreeNode> allPossibleFBT(int N) {
        if(N%2 == 0) {//判断
            return new ArrayList<TreeNode>();
        }
        List<TreeNode> list = new ArrayList<TreeNode>();
        if(N==1) {
            TreeNode t = new TreeNode(0);
            t.left = null;
            t.right = null;
            list.add(t);
            return list;
        }
        helper(list,N);
        return list;
    }
}

