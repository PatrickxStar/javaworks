package org.example.PracticingLoops.ArrayLists;

import java.util.ArrayList;
import java.util.Scanner;

public class IndexOfInteger {
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

        System.out.println("Done entering integers into the list.");
        System.out.println("What number are you looking for in the list?");
        int target = scanner.nextInt();

        boolean found = false;
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == target) {
                System.out.println(target + " is at index " + i);
                found = true;
            }
        }

        if (!found) {
            System.out.println(target + " is not in the list.");
        }
    }
}
