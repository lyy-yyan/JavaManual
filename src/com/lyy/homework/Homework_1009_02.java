package homework;

import java.util.Stack;

public class Homework_1009_02 {

    public ListNodeTest checkIntersectionNode(ListNodeTest headA, ListNodeTest headB) {
        Stack<ListNodeTest> stackA = new Stack<ListNodeTest>();
        Stack<ListNodeTest> stackB = new Stack<ListNodeTest>();

        ListNodeTest nowA = headA;
        ListNodeTest nowB = headB;

        while(nowA.next != null && nowB.next != null){
            stackA.push(nowA);
            stackB.push(nowB);
            nowA = nowA.next;
            nowB = nowB.next;
        }

        ListNodeTest ans = null;
        while (stackA.pop().equals(stackB.pop())) {
            ans = stackA.pop();
        }

        return ans;
    }
}
