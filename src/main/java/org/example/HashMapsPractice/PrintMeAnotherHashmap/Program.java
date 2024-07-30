package org.example.HashMapsPractice.PrintMeAnotherHashmap;

import java.util.HashMap;

public class Program {

    // Method to print all values in the hashmap using the toString method of Book objects
    public static void printValues(HashMap<String, Book> hashmap) {
        for (Book book : hashmap.values()) {
            System.out.println(book);
        }
    }

    // Method to print only the Books in the hashmap whose name contains the given string
    public static void printValueIfNameContains(HashMap<String, Book> hashmap, String text) {
        for (Book book : hashmap.values()) {
            if (book.getName().contains(text)) {
                System.out.println(book);
            }
        }
    }

    // Main method to demonstrate the functionality
    public static void main(String[] args) {
        // Example usage
        HashMap<String, Book> hashmap = new HashMap<>();
        hashmap.put("sense", new Book("Sense and Sensibility", 1811, "..."));
        hashmap.put("prejudice", new Book("Pride and Prejudice", 1813, "..."));

        // Print all values
        printValues(hashmap);
        System.out.println("---");

        // Print values if name contains "prejud"
        printValueIfNameContains(hashmap, "prejud");
    }
}
