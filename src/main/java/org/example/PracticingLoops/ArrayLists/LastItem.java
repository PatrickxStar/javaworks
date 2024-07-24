package org.example.PracticingLoops.ArrayLists;
import java.util.Scanner;

public class LastItem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String lastItem = "";

        System.out.println("Enter strings one by one. To stop, enter an empty string:");

        while (true) {
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                break;
            }
            lastItem = input;
        }

        System.out.println("The last item in the list is: " + lastItem);
    }
}
