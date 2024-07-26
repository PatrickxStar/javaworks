package org.example.ClassObjectsConstructors;

public class BankAccount {
    private double balance;
    private String accountHolderName;

    public BankAccount(String accountHolderName, double balance) {
        this.accountHolderName = accountHolderName;
        this.balance = balance;
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
        System.out.println(accountHolderName + " balance: " + balance);
    }

    public static void main(String[] args) {

        BankAccount myAccount = new BankAccount("My Account", 500.0);
        myAccount.deposit(100.0);
        myAccount.printAccountDetails();


        BankAccount larryAccount = new BankAccount("Larry", 5000.0);
        BankAccount maryAccount = new BankAccount("Mary", 300.0);
        larryAccount.withdraw(100.0);
        maryAccount.deposit(100.0);
        larryAccount.printAccountDetails();
        maryAccount.printAccountDetails();
    }

}

