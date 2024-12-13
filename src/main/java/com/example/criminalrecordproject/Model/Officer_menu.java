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
                        break;
                    case 3:
                        Handle_Case(officers,departments,Username);
                        break;
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
    private static void Handle_Case(ArrayList<Officer> officers, ArrayList<Department> departments, String Username) {
        Scanner input = new Scanner(System.in);
        boolean find = false;
        System.out.println("Enter Case ID:");
        int CaseID = input.nextInt();
        while (find == false) {
            for (Officer officer : officers) {
                for (Department department : departments) {
                    for (Case c : department.getCases()) {
                        if (CaseID == c.getCaseId() && c.getOfficer().equals(officer)) {
                            find = true;
                            System.out.println("\t\tCase ID: " + c.getCaseId() +
                                    ", Description: " + c.getDescription() +
                                    ", Crime Type: " + c.getCrimeType());
                            edit_Case(officers,departments);
                        }
                    }
                }
            }
            if (!find) {
                System.out.println("Invalid CaseID! Please enter a valid number:");
                CaseID = input.nextInt();
            }
        }
    }
    protected static void edit_Case(ArrayList<Officer> officers, ArrayList<Department> departments) {
        Scanner input = new Scanner(System.in);
        System.out.println("What do you want to Update?");
        System.out.println("");
    }
}
