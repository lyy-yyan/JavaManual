package com.lyy.base.testCopy;

public class Subject {
    private String name;
    private Integer score;
    Subject(){};
    Subject(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public Integer getScore() {
        return score;
    }
}
