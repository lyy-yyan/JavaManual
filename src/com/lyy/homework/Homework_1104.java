package homework;

/*测试样例
输入：
7
3 9 20 null null 15 7
输出：
[[3], [20, 9], [15, 7]]
*/

import java.util.Scanner;
import java.lang.Math;

public class Homework_1104 {
    public static int MAX = 10;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer[] arrayData = new Integer[MAX];

        int count = in.nextInt();
        for (int i = 0; i < count; i++) {
            String tempV = in.next();
            if (!tempV.equals("null")) {
                arrayData[i] = Integer.parseInt(tempV);
            }
        }

        int laryer = (int)(Math.log(count) / Math.log(2) + 1);
        Integer[][] myBinaryTree = new Integer[laryer][(int)Math.pow(2, laryer)-1];
        putInBinaryTree(myBinaryTree, arrayData, count);

        System.out.println();

        sawtoothTraverBinaryTree(myBinaryTree);

        in.close();
    }

    public static void putInBinaryTree(Integer[][] myBinaryTree, Integer[] arrayData, int count) {
        int laryer = (int)(Math.log(count) / Math.log(2) + 1);
        for (int nowData = 0; nowData < count;) {
            int n = 0;
            for (int i = 0; i < laryer; i++) {
                for (int j = 0; j < (int)Math.pow(2, n); j++) {
                    myBinaryTree[i][j] = arrayData[nowData];
                    nowData ++;
                }
                n ++;
            }
        }
    }

    public static void sawtoothTraverBinaryTree(Integer[][] myBinaryTree) {
        System.out.println("[");
        for (int i = 0; i < myBinaryTree.length; i++) {
            if (i%2 == 0) {
                System.out.print("[");
                for (int j = 0; j < myBinaryTree[i].length; j++) {
                    if (myBinaryTree[i][j] != null) {
                        System.out.print(myBinaryTree[i][j]);
                        System.out.print(",");
                    }
                }
                System.out.println("],");
            }else {
                System.out.print("[");
                for (int j = myBinaryTree[i].length-1; j >= 0; j--) {
                    if (myBinaryTree[i][j] != null) {
                        if (myBinaryTree[i][j] != null) System.out.print(myBinaryTree[i][j]);
                        System.out.print(",");
                    }
                }
                System.out.println("],");
            }
        }
        System.out.println("]");
    }
}
