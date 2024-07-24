package org.example.PracticingLoops.ArrayLists;

import java.util.Scanner;

public class HowLarge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;

        System.out.println("Enter strings one by one. To stop, enter an empty string: ");

        while(true) {
            String input = sc.nextLine();
            if (input.isEmpty()) {
                break;
            }
            count++;
        }
        System.out.println("The total amount of items in the list was: " + count);
    }
}
