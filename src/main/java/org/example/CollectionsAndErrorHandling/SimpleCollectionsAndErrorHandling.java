package org.example.CollectionsAndErrorHandling;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SimpleCollectionsAndErrorHandling {

    public static void main(String[] args) {
        // Creating and adding integers to the list
        List<Integer> numbers = new ArrayList<>();
        numbers.add(75);
        numbers.add(50);
        numbers.add(20);
        numbers.add(20);
        numbers.add(15);
        numbers.add(30);

        // Removing duplicates using Set
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        // Calculating the sum and average of the integers
        int sum = 0;
        double average = 0.0;
        try {
            for (int number : numbers) {
                sum += number;
            }
            if (numbers.size() > 0) {
                average = (double) sum / numbers.size();
            } else {
                throw new ArithmeticException("Cannot divide by zero");
            }
        } catch (ArithmeticException e) {
            System.out.println("An error occurred while calculating the average: " + e.getMessage());
        }

        // Printing the results
        System.out.println("List of integers: " + numbers);
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
        System.out.println("List of integers without duplicates: " + uniqueNumbers);

        // Handling exceptions using try-catch-finally and multi-catch blocks
        try {
            // Simulating an exception
            int index = 10;
            System.out.println(numbers.get(index)); // This will throw IndexOutOfBoundsException
        } catch (IndexOutOfBoundsException e) {
            System.out.println("An error occurred while accessing the list: " + e.getMessage());
        } finally {
            System.out.println("Program execution completed.");
        }
    }
}
