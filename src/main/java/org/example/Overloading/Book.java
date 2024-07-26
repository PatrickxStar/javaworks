package org.example.Overloading;

import java.util.ArrayList;
import java.util.Scanner;

public class Book {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        while (true) {
            System.out.print("Title of the book: ");
            String title = scanner.nextLine();
            if (title.isEmpty()) {
                break;
            }

            System.out.print("Number of pages: ");
            int pages = Integer.parseInt(scanner.nextLine());

            System.out.print("Publication year: ");
            int year = Integer.parseInt(scanner.nextLine());

            books.add(new Book(title, pages, year));
        }

        System.out.print("What information will be printed? ");
        String info = scanner.nextLine();

        if (info.equalsIgnoreCase("everything")) {
            for (Book book : books) {
                System.out.println(book);
            }
        } else if (info.equalsIgnoreCase("name")) {
            for (Book book : books) {
                System.out.println(book.getTitle());
            }
        }

        // Creating objects using overloaded constructors
        Book book1 = new Book("To Kill a Mockingbird", 281);
        Book book2 = new Book("A Brief History of Time");
        System.out.println(book1);
        System.out.println(book2);
    }

    private String title;
    private int pages;
    private int year;

    public Book(String title, int pages, int year) {
        this.title = title;
        this.pages = pages;
        this.year = year;
    }

    public Book(String title, int pages) {
        this(title, pages, 0);  // Default year
    }

    public Book(String title) {
        this(title, 0, 0);  // Default values
    }

    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }

    public int getYear() {
        return year;
    }

    public String toString() {
        return title + ", " + pages + " pages, " + year;
    }
}

