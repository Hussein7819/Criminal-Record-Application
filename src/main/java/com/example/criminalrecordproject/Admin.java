package com.example.criminalrecordproject;

import com.example.criminalrecordproject.Model.Criminal;
import com.example.criminalrecordproject.Model.Officer;
import com.example.criminalrecordproject.Model.OfficerAuthentication;
import com.example.criminalrecordproject.Model.user;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Admin extends user
{
    int Adminid = 1;
    String Adminname = "Admin";
    public Admin(String username, String password) {
        super(username, password);
    }

    public void Show_Admin_Menu(ArrayList<Department> departments, ArrayList<Officer> officers, ArrayList<Criminal> criminals, ArrayList<OfficerAuthentication> Authentication) {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("======================================================================================");
                System.out.println("\nChoose an action:");
                System.out.println("1- Add a new department");
                System.out.println("2- Add new cases to a department");
                System.out.println("3- Display departments and their cases");
                System.out.println("4- add officers to department");
                System.out.println("5- remove officers from department");
                System.out.println("6- remove cases from department");
                System.out.println("7- display officers");
                System.out.println("8- Assign Officer for a case");
                System.out.println("9-Display Criminals");
                System.out.println("10-Add Criminals");
                System.out.println("11-Delete departments");
                System.out.println("12- Exit");


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
                        addOfficers(officers);
                        break;
                    case 5 :
                        Deleteofficers(officers);
                        break;
                        case 6:
                        DeleteCase(departments);
                        break;
                    case 7:
                        displayOfficers(officers);
                        break;
                        case 8:
                            AssignOfficers(officers,departments,Authentication);
                            break;
                            case 9:
                                DisplayCriminals(criminals);
                                break;
                                case 10:
                                    break;
                                    case 11:
                                        DeleteDepartments(departments);
                                        break;
                    case 12:
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

        departments.add(new Department(deptName, activationDate));
        System.out.println("Department added successfully!");
    }

    private static void addOfficers(ArrayList<Officer> officers) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Officer Name:");
        String officerName = input.nextLine();

        System.out.println("Enter Officer Age");
        int officerAge = input.nextInt();


        input.nextLine();

        System.out.println("Enter Officer Salary");
        int officerSalary = input.nextInt();
        input.nextLine();

        System.out.println("Enter Officer Username:");
        String officerUsername = input.nextLine();

        boolean x = false;
        while (x) {
            for(Officer off : officers) {
                if(off.getOfficerUsername().equals(officerUsername)) {
                    System.out.println("Officer Username already exists! Please try again:");
                    x = true;
                }
            }
            if (x) {
                officerUsername = input.nextLine();
            }
        }

        System.out.println("Enter Officer Password:");
        String officerPassword = input.nextLine();

        System.out.println("Which department do you want to add officers to? \n enter department ID");
        String departmentID = input.nextLine();

        while (x) {
            for (Officer off : officers) {
                if(off.getOfficerID().equals(departmentID)) {
                    x = true;
                }
            }
            if (!x) {
                System.out.println("Invalid department! Please try again:");
            }
            departmentID = input.nextLine();
        }

        Officer O = new Officer(officerName, officerAge, officerSalary, officerUsername, officerPassword, departmentID);
        officers.add(O);
    }

}


