package com.lyy.base.testStream;

import java.util.function.Consumer;
import java.util.function.Function;

public class TestFunction {
    public static void main(String[] args) {
        Function<Integer, Integer> f1 = integer -> integer + integer;
        Function<Integer, Integer> f2 = integer -> integer * integer;
        Consumer consumer = System.out::println;
        consumer.accept(f1.andThen(f2).apply(2));
    }
}
