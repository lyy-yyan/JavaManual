package com.lyy.book.aha.chapterFour;

public class Point {//使用类暂时没法很方便的处理路径，暂且改用为数组
    private int x;//横坐标
    private int y;//纵坐标
    private int father;//记录路径所用，记录该点的父亲在队列中的编号
    private int step;//步数

    Point() {

    }

    Point(int x, int y, int father, int step) {
        this.x = x;
        this.y = y;
        this.father = father;
        this.step = step;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setFather(int father) {
        this.father = father;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getFather() {
        return father;
    }

    public int getStep() {
        return step;
    }
}