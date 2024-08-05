package org.example.LibraryManagement;

import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary System Menu:");
            System.out.println("1. Add a book");
            System.out.println("2. Remove a book");
            System.out.println("3. Find books by year");
            System.out.println("4. Find books by author");
            System.out.println("5. Find book with most pages");
            System.out.println("6. Find books with more than N pages");
            System.out.println("7. Print all book titles");
            System.out.println("8. Find books by category");
            System.out.println("9. Loan a book");
            System.out.println("10. Return a book");
            System.out.println("11. Register a user");
            System.out.println("12. Calculate late fees");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter publication year: ");
                    int year = scanner.nextInt();
                    System.out.print("Enter number of pages: ");
                    int pages = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    Supplier<Book> bookSupplier = () -> new Book(title, author, year, pages, category);
                    library.addBook(bookSupplier);
                    break;
                case 2:
                    System.out.print("Enter book title to remove: ");
                    title = scanner.nextLine();
                    library.removeBook(title);
                    break;
                case 3:
                    System.out.print("Enter publication year: ");
                    year = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    library.findBooksByYear(year).forEach(book -> System.out.println(book.getTitle()));
                    break;
                case 4:
                    System.out.print("Enter author name: ");
                    author = scanner.nextLine();
                    library.findBooksByAuthor(author).forEach(book -> System.out.println(book.getTitle()));
                    break;
                case 5:
                    Book bookWithMostPages = library.findBookWithMostPages();
                    System.out.println("Book with most pages: " + (bookWithMostPages != null ? bookWithMostPages.getTitle() : "None"));
                    break;
                case 6:
                    System.out.print("Enter minimum number of pages: ");
                    pages = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    library.findBooksWithMoreThanNPages(pages).forEach(book -> System.out.println(book.getTitle()));
                    break;
                case 7:
                    library.printBookTitles();
                    break;
                case 8:
                    System.out.print("Enter category: ");
                    category = scanner.nextLine();
                    library.findBooksByCategory(category).forEach(book -> System.out.println(book.getTitle()));
                    break;
                case 9:
                    System.out.print("Enter book title to loan: ");
                    title = scanner.nextLine();
                    System.out.print("Enter user library card number: ");
                    String libraryCardNumber = scanner.nextLine();
                    User user = library.getUserByLibraryCardNumber(libraryCardNumber);
                    if (user != null) {
                        library.loanBook(title, user);
                    } else {
                        System.out.println("User not found.");
                    }
                    break;
                case 10:
                    System.out.print("Enter book title to return: ");
                    title = scanner.nextLine();
                    System.out.print("Enter user library card number: ");
                    libraryCardNumber = scanner.nextLine();
                    user = library.getUserByLibraryCardNumber(libraryCardNumber);
                    if (user != null) {
                        library.returnBook(title, user);
                    } else {
                        System.out.println("User not found.");
                    }
                    break;
                case 11:
                    System.out.print("Enter user name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter library card number: ");
                    libraryCardNumber = scanner.nextLine();
                    Supplier<User> userSupplier = () -> new User(name, libraryCardNumber);
                    library.registerUser(userSupplier);
                    break;
                case 12:
                    System.out.print("Enter user library card number: ");
                    libraryCardNumber = scanner.nextLine();
                    user = library.getUserByLibraryCardNumber(libraryCardNumber);
                    if (user != null) {
                        List<String> lateFeesDetails = library.calculateLateFees(user);
                        lateFeesDetails.forEach(System.out::println);
                        System.out.println("Total late fees for " + user.getName() + ": $" + user.getLateFees());
                    } else {
                        System.out.println("User not found.");
                    }
                    break;
                case 0:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
