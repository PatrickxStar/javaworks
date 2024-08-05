package org.example.JavaLambdaExpressions;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class BuiltInFunctionalInterfaces {
    public static void main(String[] args) {
        Predicate<Integer> isEven = x -> x % 2 ==0;
        System.out.println("Is 4 even? " + isEven.test(4));

        Function<String, Integer> stringLength = s -> s.length();
        System.out.println("Length of 'Benevolence': " + stringLength.apply("Benevolence"));

        Consumer<String> print = s -> System.out.println(s);
        print.accept("Hello, everyone!");

        Supplier<Double> randomValue = () -> Math.random();
        System.out.println("Random value: " + randomValue.get());
    }
}
