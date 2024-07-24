package org.example.PracticingLoops;
import java.util.Scanner;

public class TakeABreak {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Loop until the user enters "yes"
        while (true) {
            System.out.println("Do you want to take a break?");
            String response = sc.nextLine();
            if (response.equals("yes")) {
                break;
            }
        }
        sc.close();
    }
}
