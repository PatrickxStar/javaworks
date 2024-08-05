package org.example.Debugging;

public class AverageCalculator {

    // Correct method for calculating the average
    public static double calculateAverage(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return (double) sum / numbers.length;
    }

    // Method that introduces a null pointer exception and array index out of bounds exception
    public static double calculateAverageWithExceptions(int[] numbers) {
        if (numbers == null) {
            throw new NullPointerException("Array is null");
        }
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return (double) sum / numbers.length;
    }

    // Method that introduces a logic error
    public static double calculateAverageWithLogicError(int[] numbers) {
        int sum = 0;
        for (int i = 0; i <= numbers.length; i++) { // Logic error here
            sum += numbers[i];
        }
        return (double) sum / numbers.length;
    }

    public static void main(String[] args) {
        // Test the correct method
        int[] numbers1 = {1, 2, 3, 4, 5};
        System.out.println("Average: " + calculateAverage(numbers1)); // Should print 3.0

        // Test method with exceptions
        try {
            int[] numbers2 = null;
            System.out.println("Average: " + calculateAverageWithExceptions(numbers2)); // Null pointer exception here
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        try {
            int[] numbers3 = {1, 2, 3};
            System.out.println("Out of bounds: " + numbers3[5]); // Array index out of bounds here
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds exception: " + e.getMessage());
        }

        // Test method with logic error
        try {
            int[] numbers4 = {1, 2, 3, 4, 5};
            System.out.println("Average: " + calculateAverageWithLogicError(numbers4)); // Should print incorrect result
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Logic error caused array index out of bounds: " + e.getMessage());
        }
    }
}



