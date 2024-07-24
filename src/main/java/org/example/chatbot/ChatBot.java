package org.example.chatbot;
import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        greetUser();
        String name = askName();
        double age = guessAge(name);
        countToNumber();
        testProgrammingKnowledge();
        tellStory(name, age);
    }

    public static void greetUser() {
        System.out.println("Hello! I am your friendly chat bot.");
    }

    public static String askName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = scanner.nextLine();
        System.out.println("Nice to meet you, " + name + "! Could you please repeat your name?");
        String repeatedName = scanner.nextLine();
        System.out.println("Thanks, " + repeatedName + "!");
        return repeatedName;
    }

    public static double guessAge(String name) {
        Scanner sc = new Scanner(System.in);
        System.out.println(name + ", now I will guess your age. Please enter the remainders of your age when divided by 3, 5, and 7");
        System.out.print("Remainder when divided by 3: ");
        double rem3 = sc.nextDouble();
        System.out.print("Remainder when divided by 5: ");
        double rem5 = sc.nextDouble();
        System.out.print("Remainder when divided by 7: ");
        double rem7 = sc.nextDouble();

        double age = (rem3 * 70 + rem5 * 21 + rem7 * 15) % 105;
        System.out.println("Your age is approximately " + age + "; now isn't that cool?");
        return age; // Return the calculated age
    }

    public static void countToNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number and I will count to it: ");
        int number = scanner.nextInt();
        for (int i = 1; i <= number; i++) {
            System.out.println(i);
        }
    }

    public static void testProgrammingKnowledge() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Let's test your programming knowledge.");
        System.out.println("What is the result of 5 + 1?");
        System.out.println("1. 5");
        System.out.println("2. 6");
        System.out.println("3. 8");
        System.out.println("4. 9");
        int answer;
        do {
            System.out.println("Please enter either (1 - 4)");
            answer = sc.nextInt();
            if (answer != 2) {
                System.out.println("Please, try again.");
            }
        } while (answer != 2);
        System.out.println("Congratulations! You are correct.");
    }

    public static void tellStory(String name, double age) {
        System.out.println("Great, I will now tell you a story about yourself.");
        System.out.println("Your name is " + name + " and you are " + age + " years old.");
        System.out.println(name + " loved to learn and explore new things. " +
                name + " spent their days coding and solving problems, becoming wiser and more skilled every day. " +
                "And thus, " + name + " lived happily ever after, always eager to take on the next challenge.");
    }
}
