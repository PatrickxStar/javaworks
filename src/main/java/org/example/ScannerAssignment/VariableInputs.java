package org.example.ScannerAssignment;

import java.util.Scanner;

public class VariableInputs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string of text: ");
        String text = scanner.nextLine();
        System.out.println("Enter an integer: ");
        int number = scanner.nextInt();
        System.out.println("Enter a double: ");
        double number2 = scanner.nextDouble();
        System.out.println("Enter a boolean value: ");
        boolean bool = scanner.nextBoolean();

        System.out.println("Your string is " + text);
        System.out.println("Your integer is " + number);
        System.out.println("Your double is " + number2);
        System.out.println("Your boolean is " + bool);
    }
}
