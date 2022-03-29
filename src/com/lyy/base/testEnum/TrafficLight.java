package com.lyy.base.testEnum;

//一般switch可以和enum一起连用，来构造一个小型的状态转换机

enum Signal {
    GREEN,
    YELLOW,
    RED
}

public class TrafficLight {
    Signal color = Signal.RED;

    public void change() {
        switch (color) {
            case RED:
                color = Signal.GREEN;
                break;
            case YELLOW:
                color = Signal.RED;
                break;
            case GREEN:
                color = Signal.YELLOW;
                break;
        }
    }
}
