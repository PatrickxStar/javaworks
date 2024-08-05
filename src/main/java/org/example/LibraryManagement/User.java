package org.example.LibraryManagement;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String libraryCardNumber;
    private List<Book> borrowedBooks;
    private double lateFees;

    public User(String name, String libraryCardNumber) {
        this.name = name;
        this.libraryCardNumber = libraryCardNumber;
        this.borrowedBooks = new ArrayList<>();
        this.lateFees = 0.0;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public String getLibraryCardNumber() {
        return libraryCardNumber;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public double getLateFees() {
        return lateFees;
    }

    public void addLateFees(double fee) {
        this.lateFees += fee;
    }
}
