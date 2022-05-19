package com.lyy.exercise.offer.P006;

import java.util.Scanner;
import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/*
测试样例
输入：
3
1 3 2
输出：
2 3 1
 */

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        ListNode head = new ListNode();
        ListNode nowNode =head;
        nowNode.val = in.nextInt();
        for (int i = 1; i < count; i++) {
            nowNode.next = new ListNode();
            nowNode = nowNode.next;
            nowNode.val = in.nextInt();
        }
//        for (nowNode = head; nowNode != null; nowNode = nowNode.next) {
//            System.out.print(nowNode.val + " ");
//        }
//        System.out.println();
        Solution ob = new Solution();
        int[] nums = ob.reversePrint(head);
        for (int i = 0; i < count; i++) {
            System.out.print(nums[i] + " ");
        }
        in.close();
    }

    //本人写的
    public int[] reversePrint(ListNode head) {
        int count = 0;
        for (ListNode nowNode = head; nowNode != null; nowNode = nowNode.next) {
            count ++;
        }
        int[] nums = new int[count];
        ListNode nowNode = head;
        for (int i = count-1; i >= 0; i--) {
            nums[i] = nowNode.val;
            nowNode = nowNode.next;
        }
        return nums;
    }

}
