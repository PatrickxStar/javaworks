package org.example.ConditionalStatements;
import java.util.Scanner;

public class TestScores {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a word:");
        String word = sc.nextLine();

        System.out.println("Enter another word: ");
        String otherWord = sc.nextLine();

        if (word.equalsIgnoreCase(otherWord)) {
            System.out.println("The words are the same");
        } else {
            System.out.println("The words are different");
        }
    }
}
