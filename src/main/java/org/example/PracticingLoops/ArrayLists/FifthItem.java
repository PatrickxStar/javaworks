package org.example.PracticingLoops.ArrayLists;

import java.util.Scanner;

public class FifthItem {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] items = new String[5];
    int count = 0;

    System.out.println("Enter words, one by one. To stop, enter an empty string.");

    while(true){
        String input = sc.nextLine();
        if(input.isEmpty()) {
            break;
        }
        if (count < 5) {
            items[count] = input;
        }
        count++;
    }
    if (count >= 5) {
        System.out.println("The fifth item in the list is " + items[4]);
        }
    }
}
