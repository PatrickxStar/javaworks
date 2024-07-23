package org.example.ConditionalStatements;
import java.util.Scanner;

public class BoilingWater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number greater than 212:");
        int n = sc.nextInt();
        if (n >= 212) {
            System.out.println("Water is boiling!");
        }
    }
}
