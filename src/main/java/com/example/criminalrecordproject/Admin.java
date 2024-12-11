package com.example.criminalrecordproject;

import com.example.criminalrecordproject.Model.Case;
import com.example.criminalrecordproject.Model.user;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin extends user {
    int Adminid = 1;
    String Adminname = "Admin";

    public Admin(String Username, String Password) {
        super(Username, Password);
    }

    public void Show_Admin_Menu(ArrayList<Department> departments) {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("======================================================================================");
                System.out.println("\nChoose an action:");
                System.out.println("1. Add a new department");
                System.out.println("2. Add new cases to a department");
                System.out.println("3. Display departments and their cases");
                System.out.println("4. Exit");

                int choice = input.nextInt();
                input.nextLine();

                switch (choice) {
                    case 1:
                        addDepartment(input, departments);
                        break;

                    case 2:
                        addCasesToDepartment(input, departments);
                        break;

                    case 3:
                        displayDepartments(departments);
                        break;

                    case 4:
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

    private static void addDepartment(Scanner input, ArrayList<Department> departments)
    {
        System.out.println("Enter Department ID:");
        String deptID = input.nextLine();
        System.out.println("Enter Department Name:");
        boolean x = true;
        String deptName = "";
        while (x)
        {
            boolean exist =false;
            deptName = input.nextLine();
            for (Department dept : departments) {
                if (dept.getName().equals(deptName)) {
                    System.out.println("A department with this name already exists! Please try again.");
                    exist = true;
                    break;

                }
            }

            if (!exist)
            {
                System.out.println("A Department is Added successfully.");
                x= false;


            }

        }
        System.out.println("Enter Date of Activation:");
        String activationDate = input.nextLine();

        departments.add(new Department(deptID, deptName, activationDate));
        System.out.println("Department added successfully!");
    }

    private static void addOfficers() {
        System.out.println("Which department do you want to add officers to? \n enter department ID");
    }


}

