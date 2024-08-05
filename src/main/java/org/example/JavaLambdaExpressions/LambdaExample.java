package org.example.JavaLambdaExpressions;

public class LambdaExample {
    public static void main(String[] args) {

        MathOperation addition = (a, b) -> a + b;
        MathOperation subtraction = (a, b) -> a - b;

        System.out.println("Addition: " + addition.operate(15, 5));
        System.out.println("Subtraction: " + subtraction.operate(15, 5));
    }
}
