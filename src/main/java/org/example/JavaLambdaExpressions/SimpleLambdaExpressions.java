package org.example.JavaLambdaExpressions;

import java.util.function.BinaryOperator;

public class SimpleLambdaExpressions {
    public static void main(String[] args) {
        BinaryOperator<Integer> addition = (a, b) -> a + b;
        System.out.println("Addition: " + addition.apply(10, 15));

        BinaryOperator<Integer> subtraction = (a, b) -> a - b;
        System.out.println("Subtraction: " + subtraction.apply(25, 10));

        BinaryOperator<Integer> multiplication = (a, b) -> a * b;
        System.out.println("Multiplication: " + multiplication.apply(5, 3));

        BinaryOperator<Integer> division = (a, b) -> a / b;
        System.out.println("Division: " + division.apply(10, 5));
    }
}
