package org.example.PracticingLoops;

import java.util.Scanner;

public class CountToEleven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number less than 11");
        int a = sc.nextInt();

        for (int i = a;  i <= 11; i++) {
            System.out.println(i);
        }
    }
}
