package com.lyy.exercise.offer.P018;

public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode deleteNode(ListNode head, int val) {
        ListNode lastNode = head;
        ListNode nowNode = head;
        while(nowNode != null) {
            ListNode nextNode = nowNode.next;
            if(nowNode.val == val) {
                if(nowNode == head) {
                    head = nowNode.next;
                    return head;
                }
                lastNode.next = nextNode;
                return head;
            }
            lastNode = nowNode;
            nowNode = nextNode;
        }
        return head;
    }
}
