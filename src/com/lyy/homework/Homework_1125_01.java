package homework;

import java.util.Scanner;

/*
测试样例
输入：
13
1 2 4 7 10 11 7 12 6 7 16 18 19
输出：
[3, 9]

输入：
13
1 2 4 8 10 11 7 12 6 7 16 18 19
输出：
[3, 9]

输入：
13
1 2 4 6 10 11 7 12 6 7 16 18 19
输出：
[4, 9]

输入：
13
1 2 4 7 10 11 7 12 6 12 16 18 19
输出：
[3, 8]

输入：
10
1 2 3 4 5 6 7 8 9 10
输出：
[-1, -1]
 */

public class Homework_1125_01 {
    
    public static int MAX = 30;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int count = 0;
        int[] nums = new int[MAX];

        count = in.nextInt();
        for (int i = 0; i < count; i++) {
            nums[i] = in.nextInt();
        }

        findIndexOfDisorder(nums, count);

        in.close();
    }

    public static void findIndexOfDisorder(int[] nums, int count) {
        int index_m = -1;
        int index_n = -1;
        int index_numDisorder = 0;

        //寻找m
        for (int i = 0; i < count-1; i++) {//从小到大找到第一个无序数
            if(nums[i+1] < nums[i]) {
                index_numDisorder = i+1;
                break;
            }
        }
        for (int i = index_numDisorder; i > 0; i--) {
            if (nums[index_numDisorder] > nums[i-1]) {
                index_m = i;
                break;
            }
        }

        //寻找n
        index_numDisorder = count-1;//初始化index_numDisorder
        for (int i = count-1; i > 0; i--) {//从大到小寻找无序数
            if (nums[i-1] > nums[i]) {
                index_numDisorder = i-1;
                break;
            }
        }
        for (int i = index_numDisorder; i < count-1; i++) {
            if (nums[index_numDisorder] <= nums[i+1]) {
                index_n = i;
                break;
            }
        }

        System.out.println("[" + index_m + ", " + index_n + "]");
    }
}


