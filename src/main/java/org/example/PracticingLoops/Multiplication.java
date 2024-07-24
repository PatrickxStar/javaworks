package org.example.PracticingLoops;

import java.util.Scanner;

public class Multiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input a number:");
        int number = sc.nextInt();

        // Print the multiplication table up to 10
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
        }

        sc.close();
    }
}
