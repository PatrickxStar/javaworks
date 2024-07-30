package org.example.HashMapsPractice;
import java.util.HashMap;

public class IOU {
    private HashMap<String, Double> debts;

    // Constructor that initializes the HashMap
    public IOU() {
        this.debts = new HashMap<>();
    }

    // Method to set the sum owed to a person
    public void setSum(String toWhom, double amount) {
        this.debts.put(toWhom, amount);
    }

    // Method to get the amount owed to a person
    public double howMuchDoIOweTo(String toWhom) {
        return this.debts.getOrDefault(toWhom, 0.0);
    }

    // Main method to demonstrate the functionality
    public static void main(String[] args) {
        IOU mattsIOU = new IOU();
        mattsIOU.setSum("Arthur", 51.5);
        mattsIOU.setSum("Michael", 30);

        System.out.println(mattsIOU.howMuchDoIOweTo("Arthur"));
        System.out.println(mattsIOU.howMuchDoIOweTo("Michael"));
    }
}
