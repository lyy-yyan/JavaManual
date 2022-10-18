package com.lyy.exercise.study;

import java.util.ArrayList;
import java.util.List;

// 元素无重不可复选
public class Subset {
    private static int[] nums = new int[]{1, 2, 3};
    public static void main(String[] args) {
        System.out.println("求nums从start开始的的子集");
        backtrack(nums, 0);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
        res.clear();

        System.out.println("求nums从start开始的k个大小的组合");
        backtrack(nums, 0, 2);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
        res.clear();

        System.out.println("全排列nums");
        backtrack(nums);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
    private static List<Integer> track = new ArrayList<>();
    // 存储最终结果
    private static List<List<Integer>> res = new ArrayList<>();

    // 求nums从start开始的的子集
    private static void backtrack(int[] nums, int start) {
        // 二话不说，直接存储到结果中
        res.add(new ArrayList<>(track));

        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            // 下一层的 i 均为 该层 i+1
            backtrack(nums, i + 1);
            track.remove(track.size() - 1);
        }
    }

    // 求nums从start开始的k大小的组合
    private static void backtrack(int[] nums, int start, int k) {
        // 当 track 大小为 k 时，满足条件
        if (track.size() == k){
            res.add(new ArrayList<>(track));
            return ;
        }

        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(nums, i + 1, 2);
            track.remove(track.size() - 1);
        }
    }

    // 全排列nums
    private static boolean[] used = new boolean[nums.length];
    private static void backtrack(int[] nums) {
        // 当 track 大小为 nums.length 时，满足条件
        if (track.size() == nums.length){
            res.add(new ArrayList<>(track));
            return ;
        }
        // 注意：这里的循环每次都是从 0 开始
        for (int i = 0; i < nums.length; i++) {
            // 如果使用过了，直接跳过
            if (used[i]) continue;
            // 标记使用
            used[i] = true;
            track.add(nums[i]);
            backtrack(nums);
            // 去除使用
            used[i] = false;
            track.remove(track.size() - 1);
        }
    }
}
