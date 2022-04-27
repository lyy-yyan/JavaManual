package homework;

import java.util.Scanner;

public class Homework_1031 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = new String();
        str = in.nextLine();
        int location = findNoRepetitiveStr(str);
        System.out.println(location);
        in.close();
    }

    public static int findNoRepetitiveStr(String str) {
        Character firstRepetitiveStr;
        firstRepetitiveStr = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != firstRepetitiveStr) {
                return i;
            }
        }
        return -1;
    }
}
