package com.asiainfo.java8.lambda;

import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaDemo {

    public static void main(String[] args) {
        Function<Integer, Integer> f1 = i -> i + 1;
        Function<Integer, Integer> f2 = i -> i;
        Integer result1 = f1.apply(5);
        Integer result2 = f2.apply(5);
        System.out.println(result1);
        System.out.println(result2);
        int a = 1;
        int b = 2;
        Supplier<Integer> supplier = () -> a + b;
        System.out.println(supplier.get());
    }
}
