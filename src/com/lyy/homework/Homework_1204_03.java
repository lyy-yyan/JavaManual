package homework;

/*
测试样例
输入: candidates = [2,3,6,7], target = 7
输出: [[7],[2,2,3]]

输入: candidates = [2,3,5], target = 8
输出: [[2,2,2,2],[2,3,3],[3,5]]
 */

import java.util.ArrayList;
import java.util.List;

public class Homework_1204_03 {
    List<List<Integer>> res = new ArrayList<>(); //记录答案
    List<Integer> path = new ArrayList<>();  //记录路径

    public static void main(String[] args) {
        Homework_1204_03 ob = new Homework_1204_03();
//        int[] candidates = {2, 3, 6, 7};
//        int target = 7;
        int[] candidates = {2, 3, 5};
        int target = 8;
        List<List<Integer>> list = ob.combinationSum(candidates, target);
        System.out.println(list.toString());
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates,0, target);
        return res;
    }
    public void dfs(int[] c, int u, int target) {
        if(target < 0) return ;
        if(target == 0)
        {
            res.add(new ArrayList(path));
            return ;
        }
        for(int i = u; i < c.length; i++){
            if( c[i] <= target)
            {
                path.add(c[i]);
                dfs(c,i,target -  c[i]); // 因为可以重复使用，所以还是i
                path.remove(path.size()-1); //回溯，恢复现场
            }
        }
    }
}


