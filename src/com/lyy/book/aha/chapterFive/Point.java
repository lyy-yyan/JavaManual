package com.lyy.book.aha.chapterFive;

public class Point {
    private int nowCity;
    private int transferNum;

    Point() {
        this.nowCity = 0;
        this.transferNum = 0;
    }

    Point(int nowCity, int transferNum) {
        this.nowCity = nowCity;
        this.transferNum = transferNum;
    }

    public void setNowCity(int nowCity) {
        this.nowCity = nowCity;
    }

    public void setTransferNum(int transferNum) {
        this.transferNum = transferNum;
    }

    public int getNowCity() {
        return nowCity;
    }

    public int getTransferNum() {
        return transferNum;
    }
}