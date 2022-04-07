package com.lyy.book.aha.chapterFive;

public class DfsFindShortestPath {
    public static void main(String[] args) {
        int[][] map = new int[10][10];
        int[][] book = new int[10][10];
        initArray(map);
        initArray(book);

    }

    public static void initArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = 0;
            }
        }
    }

    public static void dfsFunc(int target, int dis, int[][] map, int[][] book) {

    }
}
