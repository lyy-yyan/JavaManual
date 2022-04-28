package com.test;

public class PrintMultiplication {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                String str = j + "*" + i + "=" + (i * j);
                str = String.format("%-8s", str);
                System.out.print(str);
            }
            System.out.println();
        }
    }
}
