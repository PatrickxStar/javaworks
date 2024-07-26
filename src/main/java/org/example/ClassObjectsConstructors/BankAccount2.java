package org.example.ClassObjectsConstructors;

import java.util.ArrayList;
import java.util.Scanner;

public class BankAccount2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<BankAccount2> accounts = new ArrayList<>();

        System.out.println("Hello world! Welcome to the Bank of Matt!");
        while (true) {
            System.out.print("Are you an existing customer? (-1 to exit)\n1. Yes\n2. No\n");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == -1) {
                break;
            } else if (choice == 1) {
                System.out.print("Enter your account number: ");
                int accountNumber = Integer.parseInt(scanner.nextLine());
                BankAccount2 account = findAccountByNumber(accounts, accountNumber);
                if (account != null) {
                    mainMenu(account, accounts);
                } else {
                    System.out.println("Account not found.");
                }
            } else if (choice == 2) {
                BankAccount2 newAccount = new BankAccount2();
                accounts.add(newAccount);
                System.out.println("New account created:");
                newAccount.printAccountDetails();
                mainMenu(newAccount, accounts);
            }
        }
        scanner.close();
    }

    private static BankAccount2 findAccountByNumber(ArrayList<BankAccount2> accounts, int accountNumber) {
        for (BankAccount2 account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    private static void mainMenu(BankAccount2 account, ArrayList<BankAccount2> accounts) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nHello " + account.getAccountHolderName() + "!");
            System.out.print("Welcome to the Main Menu, what would you like to do today?\n"
                    + "1. To check account balance\n"
                    + "2. To make a withdraw\n"
                    + "3. To make a deposit\n"
                    + "4. To make a transfer to another account\n"
                    + "0. To exit.\n");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 0) {
                break;
            } else if (choice == 1) {
                account.printAccountDetails();
            } else if (choice == 2) {
                System.out.print("Enter the amount to withdraw: ");
                double amount = Double.parseDouble(scanner.nextLine());
                account.withdraw(amount);
            } else if (choice == 3) {
                System.out.print("Enter the amount to deposit: ");
                double amount = Double.parseDouble(scanner.nextLine());
                account.deposit(amount);
            } else if (choice == 4) {
                System.out.print("Enter the account number to transfer to: ");
                int transferAccountNumber = Integer.parseInt(scanner.nextLine());
                BankAccount2 transferAccount = findAccountByNumber(accounts, transferAccountNumber);
                if (transferAccount != null) {
                    System.out.print("Enter the amount to transfer: ");
                    double amount = Double.parseDouble(scanner.nextLine());
                    if (amount <= account.getBalance()) {
                        transfer(account, transferAccount, amount);
                        System.out.println("Transfer successful.");
                        account.printTransferDetails();
                        transferAccount.printTransferDetails();
                    } else {
                        System.out.println("Insufficient funds for the transfer.");
                    }
                } else {
                    System.out.println("Account not found.");
                }
            }
            account.printAccountDetails();
        }
    }

    private static void transfer(BankAccount2 fromAccount, BankAccount2 toAccount, double amount) {
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }

    private double balance;
    private String accountHolderName;
    private int accountNumber;


    public BankAccount2(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }


    public BankAccount2() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("What is the name for the account? ");
        this.accountHolderName = scanner.nextLine();
        System.out.print("What is the beginning balance for the account? ");
        this.balance = Double.parseDouble(scanner.nextLine());
        this.accountNumber = generateAccountNumber();
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public void printAccountDetails() {
        System.out.println("Account Number: " + accountNumber + ", Name: " + accountHolderName + ", Balance: $" + balance);
    }

    public void printTransferDetails() {
        System.out.println("The name on the account is: " + accountHolderName + " and they have a balance of $" + balance);
    }


    private int generateAccountNumber() {
        return (int) (Math.random() * 10);  // Single digit account number to not make it complicated.
    }
}
