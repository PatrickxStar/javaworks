package org.example.LibraryManagement;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    // Add a book to the library
    public void addBook(Supplier<Book> bookSupplier) {
        books.add(bookSupplier.get());
    }

    // Remove a book by title
    public void removeBook(String title) {
        books.removeIf(book -> book.getTitle().equals(title));
    }

    // Find all books published in a specific year
    public List<Book> findBooksByYear(int year) {
        return books.stream().filter(book -> book.getPublicationYear() == year).collect(Collectors.toList());
    }

    // Find all books by a specific author
    public List<Book> findBooksByAuthor(String author) {
        return books.stream().filter(book -> book.getAuthor().equals(author)).collect(Collectors.toList());
    }

    // Find the book with the most pages
    public Book findBookWithMostPages() {
        return books.stream().max(Comparator.comparingInt(Book::getPages)).orElse(null);
    }

    // Find all books with more than n pages
    public List<Book> findBooksWithMoreThanNPages(int pages) {
        return books.stream().filter(book -> book.getPages() > pages).collect(Collectors.toList());
    }

    // Print all book titles sorted alphabetically
    public void printBookTitles() {
        books.stream().map(Book::getTitle).sorted().forEach(System.out::println);
    }

    // Find all books in a specific category
    public List<Book> findBooksByCategory(String category) {
        return books.stream().filter(book -> book.getCategory().equals(category)).collect(Collectors.toList());
    }

    // Loan out a book to a user
// Loan out a book to a user
    public void loanBook(String title, User user) {
        Optional<Book> bookOpt = books.stream().filter(book -> book.getTitle().equals(title) && !book.isOnLoan()).findFirst();
        if (bookOpt.isPresent()) {
            Book book = bookOpt.get();
            book.setOnLoan(true);
            book.setLoanDate(LocalDate.now());
            user.getBorrowedBooks().add(book);
            System.out.println("Book loaned out: " + book.getTitle() + " on " + book.getLoanDate());
            System.out.println("Due date: " + book.getLoanDate().plusWeeks(2));
        } else {
            System.out.println("Book is not available.");
        }
    }



    // Return a book from a user
    public void returnBook(String title, User user) {
        Optional<Book> bookOpt = user.getBorrowedBooks().stream().filter(book -> book.getTitle().equals(title)).findFirst();
        if (bookOpt.isPresent()) {
            Book book = bookOpt.get();
            book.setOnLoan(false);
            calculateLateFees(user, book);
            user.getBorrowedBooks().remove(book);
        } else {
            System.out.println("Book not found in user's borrowed books.");
        }
    }

    // Register a new user
    public void registerUser(Supplier<User> userSupplier) {
        users.add(userSupplier.get());
    }

    // Calculate late fees for a returned book
    public void calculateLateFees(User user, Book book) {
        if (book.getLoanDate() != null) {
            long daysBetween = ChronoUnit.DAYS.between(book.getLoanDate(), LocalDate.now());
            if (daysBetween > 14) {
                double lateFee = (daysBetween - 14) * 1.0; // $1 per day after 2 weeks
                user.addLateFees(lateFee);
            }
        }
    }

    // Calculate and return detailed late fee information for a user
// Calculate and return detailed late fee information for a user
    public List<String> calculateLateFees(User user) {
        List<String> lateFeeDetails = new ArrayList<>();
        double totalLateFees = 0.0;
        for (Book book : user.getBorrowedBooks()) {
            if (book.getLoanDate() != null) {
                LocalDate loanDate = book.getLoanDate();
                LocalDate dueDate = loanDate.plusWeeks(2);
                long daysBetween = ChronoUnit.DAYS.between(dueDate, LocalDate.now());
                if (daysBetween > 0) {
                    double lateFee = daysBetween * 1.0; // $1 per day after 2 weeks
                    totalLateFees += lateFee;
                    String detail = "Book: " + book.getTitle() +
                            ", Loan Date: " + loanDate +
                            ", Due Date: " + dueDate +
                            ", Days Late: " + daysBetween +
                            ", Late Fee: $" + lateFee;
                    lateFeeDetails.add(detail);
                    System.out.println(detail); // Debug print statement
                }
            }
        }
        user.addLateFees(totalLateFees);
        return lateFeeDetails;
    }



    // Example usage of Predicate
    public List<Book> filterBooks(Predicate<Book> predicate) {
        return books.stream().filter(predicate).collect(Collectors.toList());
    }

    // Example usage of Function
    public List<String> transformBooks(Function<Book, String> function) {
        return books.stream().map(function).collect(Collectors.toList());
    }

    // Example usage of Consumer
    public void processBooks(Consumer<Book> consumer) {
        books.forEach(consumer);
    }

    // Method to get user by library card number
    public User getUserByLibraryCardNumber(String libraryCardNumber) {
        return users.stream().filter(user -> user.getLibraryCardNumber().equals(libraryCardNumber)).findFirst().orElse(null);
    }
}
