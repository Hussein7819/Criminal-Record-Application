package com.example.criminalrecordproject.Model;

import com.example.criminalrecordproject.Department;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Officer_menu extends user {
    public Officer_menu(String username, String password) {
        super(username, password);
    }

        public static void menu(ArrayList<Department> departments, ArrayList<Officer> officers,String Username) {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("======================================================================================");
                System.out.println("\nChoose an action:");
                System.out.println("1-display officers");
                System.out.println("2-display cases");
                System.out.println("3-handle case");
                System.out.println("4-display criminal record");
                System.out.println("5-exit");
                int choice = input.nextInt();
                input.nextLine();

                switch (choice) {
                    case 1:
                        displayOfficers(officers);
                        break;
                    case 2:
                        displayCase(departments,officers,Username);
                    case 5:
                        System.out.println("Exiting...");
                        user u;
                        return;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                input.nextLine();
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }
}
