# 剑指 Offer 06. 从尾到头打印链表
## 题目描述
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。<br />

来源：力扣（LeetCode）<br />
链接：https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof <br />
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。<br />
## 题目要求
- 0 <= 链表长度 <= 10000
## 测试样例
输入：head = [1,3,2]<br />
输出：[2,3,1]
# 可优化之处
利用栈完成倒置。
# 官方题解
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;
    }
}
```
