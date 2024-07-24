package org.example.PracticingLoops;
import java.util.Scanner;

public class StopAtFive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Give a number: ");
            int a = sc.nextInt();
            if (a == 5) {
                break;
            }
        }
        sc.close();
    }
}
