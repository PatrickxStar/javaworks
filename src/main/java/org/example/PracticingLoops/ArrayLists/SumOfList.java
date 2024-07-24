package org.example.PracticingLoops.ArrayLists;

import java.util.ArrayList;
import java.util.Scanner;

public class SumOfList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("Enter integers one by one. To stop, enter 0:");

        while (true) {
            int input = scanner.nextInt();
            if (input == 0) {
                break;
            }
            numbers.add(input);
        }

        int sum = calculateSum(numbers);

        System.out.print(numbers.get(0));
        for (int i = 1; i < numbers.size(); i++) {
            System.out.print(", " + numbers.get(i));
        }
        System.out.println(" were the items in the list. The sum of that list is: " + sum);
    }

    public static int calculateSum(ArrayList<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
