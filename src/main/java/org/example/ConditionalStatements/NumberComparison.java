package org.example.ConditionalStatements;
import java.util.Scanner;

public class NumberComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int a = sc.nextInt();

        System.out.println("Enter another number: ");
        int b = sc.nextInt();

        if (a > b) {
            System.out.println("The first number was larger than the second.");
        } else if (a < b) {
            System.out.println("The second number was larger than the first.");
        } else {
            System.out.println("Numbers are the same.");
        }
        sc.close();
    }
}
