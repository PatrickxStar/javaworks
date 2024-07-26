package org.example.ClassObjectsConstructors;

public class Product {
    public static void main(String[] args) {
        Product gas = new Product("Gallon of gas", 4.0, 10);
        gas.printProduct();
        gas.totalCost();
    }
    private double cost;
    private int quantity;
    private String productName;

    public Product(String productName, double cost, int quantity) {
        this.productName = productName;
        this.cost = cost;
        this.quantity = quantity;
    }

    public void totalCost() {
        System.out.println("Total cost is " + (cost * quantity));
    }

    public void printProduct() {
        System.out.println(productName + " costs " + cost + " and " + quantity + " units were purchased");
    }

}
