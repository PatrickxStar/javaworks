package org.example.PracticingLoops;
import java.util.Scanner;

public class PositiveNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a number:");
            int number = sc.nextInt();

            if (number == 0) {
                break;
            } else if (number > 0) {
                System.out.println("Number is " + number);
            } else {
                System.out.println("Number must be a positive number");
            }
        }

        sc.close();
    }
}