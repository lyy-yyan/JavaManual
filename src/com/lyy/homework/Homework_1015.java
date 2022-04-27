package homework;

import java.util.*;

public class Homework_1015 {
    public static void main(String[] args) {

        System.out.println("请输入要判断是否为回文的字符串，以@结束");
        Scanner in = new Scanner(System.in);
        String now_str = in.next();
        Stack<Character> stack = new Stack<Character>();
        Queue<Character> queue = new LinkedList<Character>();
        boolean flag = true;//判断是否为回文的标志

        for (int i = 0; i < now_str.length(); i++) {
            Character now_char = now_str.charAt(i);
            if(now_char != '@'){
                stack.push(now_char);
                queue.offer(now_char);
            }
        }

        while (!stack.isEmpty()){
            if(stack.pop() != queue.poll()){
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println("Y");
        }else {
            System.out.println("N");
        }

        in.close();
    }
}
