package com.lyy.base.testStream;

import java.util.function.Consumer;

public class TestConsumer {
    public static void main(String[] args) {
        //我认知中的
        System.out.println("hello world");
        System.out.println("hello condesheep");
        System.out.println("bilibili cheers");

        //函数式
        Consumer consumer = System.out::println;
        consumer.accept("hello world");
        consumer.accept("hello condesheep");
        consumer.accept("bilibili cheers");
        consumer.andThen(consumer).andThen(consumer).accept("hello world");
    }
}
