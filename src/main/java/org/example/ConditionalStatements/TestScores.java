package org.example.ConditionalStatements;
import java.util.Scanner;

public class TestScores {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompt the user to enter a number between 0 and 100
        System.out.println("Name a number between 0 and 100");
        int score = sc.nextInt();

        // Determine the grade based on the score
        String grade;
        if (score >= 90) {
            grade = "A";
        } else if (score >= 80) {
            grade = "B";
        } else if (score >= 70) {
            grade = "C";
        } else if (score >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        // Print the grade
        System.out.println("Your grade is a " + grade);

        // Optionally, add an emoticon for an F grade
        if (grade.equals("F")) {
            System.out.println("Your grade is an F :(");
        }

        sc.close();
    }
}