# 剑指 Offer 18. 删除链表的节点
## 题目描述
给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。<br />
返回删除后的链表的头节点。<br />

来源：力扣（LeetCode） <br />
链接：https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof <br />
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。<br />
## 题目要求
- 题目保证链表中节点的值互不相同
- 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
## 测试样例
输入: head = [4,5,1,9], val = 5 <br />
输出: [4,1,9] <br />
解释: 给定你链表中值为5的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9. <br />

输入: head = [4,5,1,9], val = 1 <br />
输出: [4,5,9] <br />
解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9. <br />

# 我的思路
存储上一个节点和下一个节点，删除该节点直接把上个节点的next指向下个节点即可，非常简单。
# 官方题解
```java
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val == val) return head.next;
        ListNode pre = head, cur = head.next;
        while(cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if(cur != null) pre.next = cur.next;
        return head;
    }
}
```