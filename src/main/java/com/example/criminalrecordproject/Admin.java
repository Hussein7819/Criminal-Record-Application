package com.example.criminalrecordproject;

import com.example.criminalrecordproject.Model.Criminal;
import com.example.criminalrecordproject.Model.Officer;
import com.example.criminalrecordproject.Model.OfficerAuthentication;
import com.example.criminalrecordproject.Model.user;
import com.example.criminalrecordproject.Model.Case;
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

    public void Show_Admin_Menu(ArrayList<Department> departments, ArrayList<Officer> officers, ArrayList<Criminal> criminals, ArrayList<OfficerAuthentication> Authentication, ArrayList<Case> cases) {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("======================================================================================");
                System.out.println("\nChoose an action:");
                System.out.println("1- Add a new department");
                System.out.println("2- Add new cases to a department");
                System.out.println("3- Display departments and their cases");
                System.out.println("4- Assign Officer for a case");
                System.out.println("5- remove officer from a case");
                System.out.println("6- remove cases from department");
                System.out.println("7- Add Officers");
                System.out.println("8- display officers");
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

                        AssignOfficers(officers,departments,Authentication);
                        break;
                    case 5 :
                        Deleteofficers(officers,departments);
                        break;
                        case 6:
                        DeleteCase(departments);
                        break;
                    case 7:
                        addOfficers(officers);
                        break;
                        case 8:
                            displayOfficers(officers);
                            break;
                            case 9:
                                DisplayCriminals(criminals);
                                break;
                                case 10:
                                    AddCriminalToDepartment(departments,criminals);
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

        System.out.println("Enter Officer Age:");
        int officerAge = input.nextInt();

        input.nextLine();  // Consume newline left-over

        System.out.println("Enter Officer Salary:");
        int officerSalary = input.nextInt();
        input.nextLine();  // Consume newline left-over

        System.out.println("Enter Officer Username:");
        String officerUsername = input.nextLine();

        // Check if the username already exists
        boolean usernameExists = false;
        do {
            usernameExists = false;
            for (Officer off : officers) {
                if (off.getOfficerUsername().equals(officerUsername)) {
                    System.out.println("Officer Username already exists! Please try again:");
                    officerUsername = input.nextLine();
                    usernameExists = true;
                    break;
                }
            }
        } while (usernameExists);

        System.out.println("Enter Officer Password:");
        String officerPassword = input.nextLine();

        // Create new officer object without assigning them to any case
        Officer newOfficer = new Officer(officerName, officerAge, officerSalary, officerUsername, officerPassword);
        officers.add(newOfficer);

        System.out.println("Officer added successfully.");
    }




    public static void AddCriminalToDepartment(ArrayList<Department> departments, ArrayList<Criminal> criminals) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Ask for criminal details
            System.out.println("Enter Criminal Name:");
            String criminalName = scanner.nextLine();

            // Create the new criminal
            Criminal newCriminal = new Criminal(criminalName);

            // Add to the global list of criminals
            criminals.add(newCriminal);

            // Ask for the crime type
            System.out.println("Enter the Crime Type:");
            String crimeType = scanner.nextLine();

            // Add the crime to the criminal record
            newCriminal.AddCrime(); // Optionally, you could provide a way to add multiple crimes

            // Find the matching department for the crime type
            boolean foundDepartment = false;

            for (Department dept : departments) {
                if (dept.getName().equalsIgnoreCase(crimeType)) {
                    // Add criminal to the department's case related to the crime
                    Case newCase = new Case("Case for " + crimeType, "2024-12-18", crimeType, dept);
                    newCase.addCriminal(newCriminal); // Add criminal to case
                    dept.addCase(newCase); // Add case to department
                    foundDepartment = true;

                    System.out.println("Criminal " + criminalName + " added to the department for crime: " + crimeType);
                    break;
                }
            }

            if (!foundDepartment) {
                System.out.println("No department found for this crime type.");
            }

        } catch (Exception e) {
            System.out.println("An error occurred while adding the criminal: " + e.getMessage());
        }
    }








}


