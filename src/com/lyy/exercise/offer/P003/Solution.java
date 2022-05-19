package com.lyy.exercise.offer.P003;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[100010];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        Solution ob = new Solution();
        System.out.println(ob.findRepeatNumber(nums));

        in.close();
    }

    // 优化后
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int repeat = -1;
        for (int num : nums) {
            /*
            如果成功加入集合就说明集合中没有该元素，!true则不进入if
            如果未能加入集合就说明集合中已有该元素，进入if
            当遇到要求和重复元素相关时，记得想到Set
             */
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }

    // 首次提交
//    public int findRepeatNumber(int[] nums) {
//        int[] everyNum = new int[100010];
//        for (int i = 0; i < everyNum.length; i++) {
//            everyNum[i] = 0;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            everyNum[nums[i]] ++;
//            if (everyNum[nums[i]] >= 2) {
//                return nums[i];
//            }
//        }
//        return -1;
//    }
}
