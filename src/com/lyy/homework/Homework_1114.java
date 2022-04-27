package homework;

import java.util.Stack;
public class Homework_1114 {
    //初始化邻接矩阵
    static int[][] graph = {
            {0,1,1,0,0},
            {1,0,0,1,1},
            {1,0,0,1,1},
            {0,1,1,0,0},
            {0,1,1,0,0},
    };

    //是否访问
    static boolean[] isVisited = new boolean[5];

    static Stack<Integer> stack = new Stack();

    //利用栈来完成深度优先遍历
    public static void main(String[] args) {
        dfsOfStack();
        isVisited = new boolean[]{false, false, false, false, false};//重置是否访问
        System.out.println("-------分割线-------");
    }

    // 栈深度优先遍历（入栈前不判断是否在栈中，重复入栈，但访问前判断是否访问，注：重复入栈保证了深度优先遍历）
    public static void dfsOfStack() {
        stack.add(0); // 遍历起始点0
        int index = 0; // 存储从栈中出栈的下标
        while(stack.size() != 0) { // 如果栈为空则遍历结束
            index = stack.pop(); // 出栈操作
            if(!isVisited[index]) { //这里判断了是否已访问过，因为后面重复入栈了
                System.out.println("v" + index);
                isVisited[index] = true;
                for(int i = 0; i<isVisited.length; i++) {//遍历每个顶点
                    if(graph[index][i] == 1 && !isVisited[i]) {//==1表示与此顶点有连线，!isVisited[i]表示此顶点还未访问，则进行递归访问
                        stack.add(i); //没有判断是否已在栈中，导致重复入栈
                    }
                }
            }

        }
    }
}