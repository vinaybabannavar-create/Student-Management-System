package com.studentmanagement;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentDAO studentDAO = new StudentDAO();

        int choice;

        do {

            System.out.println();
            System.out.println("====================================");
            System.out.println("       STUDENT MANAGEMENT SYSTEM");
            System.out.println("====================================");

            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                // CREATE
                case 1:

                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Enter Course: ");
                    String course = scanner.nextLine();

                    System.out.print("Enter Phone: ");
                    String phone = scanner.nextLine();

                    Student student = new Student(
                            name,
                            email,
                            course,
                            phone);

                    studentDAO.addStudent(student);

                    break;

                // READ
                case 2:

                    System.out.print("Enter Student ID: ");
                    int viewId = scanner.nextInt();

                    studentDAO.viewStudent(viewId);

                    break;

                // UPDATE
                case 3:

                    System.out.print("Enter Student ID: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter New Course: ");
                    String newCourse = scanner.nextLine();

                    System.out.print("Enter New Phone: ");
                    String newPhone = scanner.nextLine();

                    studentDAO.updateStudent(
                            updateId,
                            newCourse,
                            newPhone);

                    break;

                // DELETE
                case 4:

                    System.out.print("Enter Student ID: ");
                    int deleteId = scanner.nextInt();

                    studentDAO.deleteStudent(deleteId);

                    break;

                // EXIT
                case 5:

                    System.out.println();
                    System.out.println("Thank you for using Student Management System!");
                    System.out.println("Application closed.");

                    break;

                default:

                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 5);

        scanner.close();
    }
}