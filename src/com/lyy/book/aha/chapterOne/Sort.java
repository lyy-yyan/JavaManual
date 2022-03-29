package com.lyy.book.aha.chapterOne;

import java.util.Scanner;

/*
测试样例：
10
8 100 50 22 15 6 1 1000 22 2
正确结果：
1 2 6 8 15 22 22 50 100 1000
*/

public class Sort {
    public static int MAX = 10;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int count = in.nextInt();
        int[] nums = new int[MAX];

        //导入要排序的数
        for (int i = 0; i < count; i++) {
            nums[i] = in.nextInt();
        }

        //排序前
        System.out.print("before:[ ");
        for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i] + " ");
        }
        System.out.println("]");

        /*此处进行排序测试*/
        System.out.println("桶排序");
        pucketSort(nums);
        System.out.println("冒泡排序");
        bubbleSort(nums);
        System.out.println("快速排序");
        quickSort(nums);

        //排序后
        System.out.print("after:[ ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("]");

        in.close();
    }

    //桶排序
    public static void pucketSort(int[] nums) {
        int[] pucket = new int[1010];
        //初始化桶
        for (int i = 0; i < pucket.length; i++) {
            pucket[i] = 0;
        }
        for (int i = 0; i < nums.length; i++) {
            pucket[nums[i]] ++;
        }
        int rightNums = 0;
        for (int i = 0; i < pucket.length; i++) {
            for ( ; pucket[i] > 0; pucket[i] --) {
                nums[rightNums] = i;
                rightNums ++;
            }
        }
    }

    //冒泡排序
    public static void bubbleSort(int[] nums) {
        boolean flagOfExchange = false;//优化项
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = 0; j < nums.length-1-i; j++) {
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    flagOfExchange = true;
                }
            }
            if (!flagOfExchange) {//若无交换则说明顺序已经正确无需再循环
                break;
            }
        }
    }

    //快速排序
    public static void quickSort(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }

        int standard = nums[left];
        int left_i = left;
        int right_i = right;
        while (left_i != right_i) {
            //因为最后一定得是＜基准的数与基准数交换，所以必须先从右边找
            //从右走找到＜基准数的数
            while (nums[right_i] >= standard && left_i < right_i) {
                right_i --;
            }
            //从左走找到＞基准数的数
            while (nums[left_i] <= standard && left_i < right_i) {
                left_i ++;
            }
            //若没有相遇则交换,若相遇则和基准数交换
            if (left_i < right_i) {
                int temp = nums[left_i];
                nums[left_i] = nums[right_i];
                nums[right_i] = temp;
            }
        }
        //基准数归位
        nums[left] = nums[left_i];
        nums[left_i] = standard;

        //递归实现基准左边和右边的排序
        quickSort(nums, left, left_i-1);
        quickSort(nums, left_i+1, right);
    }

    public static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }
}
