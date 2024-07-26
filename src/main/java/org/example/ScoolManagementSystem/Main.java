package org.example.ScoolManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Teacher lizzy = new Teacher(1, "Lizzy", 500);
        Teacher mellisa = new Teacher(2, "Mellisa", 700);
        Teacher vanderhorn = new Teacher(3, "Vanderhorn", 600);

        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(lizzy);
        teacherList.add(mellisa);
        teacherList.add(vanderhorn);

        Student tamasha = new Student(1, "Tamasha", 4);
        Student rakshith = new Student(2, "Rakshith Vasudev", 12);
        Student rabbi = new Student(3, "Rabbi", 5);

        List<Student> studentList = new ArrayList<>();
        studentList.add(tamasha);
        studentList.add(rakshith);
        studentList.add(rabbi);

        School ghs = new School(teacherList, studentList);

        tamasha.payFees(5000);
        rakshith.payFees(6000);
        System.out.println("GHS has earned $" + School.getTotalMoneyEarned());

        System.out.println("------ Making SCHOOL PAY SALARY ------");
        lizzy.receiveSalary(lizzy.getSalary());
        System.out.println("GHS has spent for salary to Lizzy and now has $" + (School.getTotalMoneyEarned() - School.getTotalMoneySpent()));

        vanderhorn.receiveSalary(vanderhorn.getSalary());
        System.out.println("GHS has spent for salary to Vanderhorn and now has $" + (School.getTotalMoneyEarned() - School.getTotalMoneySpent()));

        System.out.println(rakshith);

        mellisa.receiveSalary(mellisa.getSalary());
        System.out.println(mellisa);
    }
}
