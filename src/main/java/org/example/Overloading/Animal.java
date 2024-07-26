package org.example.Overloading;

import java.util.ArrayList;
import java.util.Scanner;

public class Animal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Animal> animals = new ArrayList<>();

        System.out.println("Animal Menu");
        System.out.println("Entering nothing will stop the loop");

        while (true) {
            System.out.print("Please enter a name: ");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                break;
            }

            System.out.print("Is it a dog? Yes or no: ");
            String isDogInput = scanner.nextLine();
            boolean isDog = isDogInput.equalsIgnoreCase("yes");

            animals.add(new Animal(name, isDog));
        }

        System.out.println("Animals in the list:");
        for (Animal animal : animals) {
            System.out.println(animal);
        }

        // Creating objects using overloaded constructors
        Animal animal1 = new Animal("Buddy");
        Animal animal2 = new Animal();
        System.out.println(animal1);
        System.out.println(animal2);
    }

    private String name;
    private boolean isDog;

    public Animal(String name, boolean isDog) {
        this.name = name;
        this.isDog = isDog;
    }

    public Animal(String name) {
        this(name, true);  // Assuming default is a dog
    }

    public Animal() {
        this("Unknown", false);  // Default values
    }

    public String getName() {
        return name;
    }

    public boolean getIsDog() {
        return isDog;
    }

    public String toString() {
        return getName() + " is a dog = " + getIsDog();
    }
}
