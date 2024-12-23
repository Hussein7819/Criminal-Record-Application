package com.example.criminalrecordproject;

import com.example.criminalrecordproject.Model.*;

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
                System.out.println("10-Delete departments");
                System.out.println("11- Update criminals");
                System.out.println("12- Exit");


                int choice = input.nextInt();
                input.nextLine();

                switch (choice) {
                    case 1:
                        addDepartment(input, departments);
                        break;

                    case 2:
                        addCasesToDepartment(input, departments,officers,criminals);
                        break;

                    case 3:
                        displayDepartments(departments,Authentication,officers);
                        break;

                    case 4:

                        AssignOfficers(officers,departments,Authentication);
                        break;
                    case 5 :
                        Deleteofficers(officers,departments,Authentication);
                        break;
                        case 6:
                        DeleteCase(departments);
                        break;
                       case 7:
                        addOfficers(officers,departments);
                        break;
                        case 8:
                            displayOfficers(officers);
                            break;
                            case 9:
                                DisplayCriminals(criminals);
                                break;
                                    case 10:
                                        DeleteDepartments(departments);
                                        break;

                               case 11:
                            UpdateCriminal(criminals);
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

    private static void addDepartment(Scanner input, ArrayList<Department> departments) {
        try {
            if (input == null) {
                throw new IllegalArgumentException("Input scanner cannot be null.");
            }

            if (departments == null) {
                throw new IllegalArgumentException("Department list cannot be null.");
            }

            System.out.println("Enter Department Name:");
            boolean validInput = false;
            String deptName = "";

            while (!validInput)
            {
                deptName = input.nextLine().trim();
                if (deptName.isEmpty())
                {
                    System.out.println("Department name cannot be empty! Please try again.");
                    continue;
                }

                boolean exists = false;
                for (Department dept : departments)
                {
                    if (dept.getName().equalsIgnoreCase(deptName))
                    {
                        System.out.println("A department with this name already exists! Please try again.");
                        exists = true;
                        break;
                    }
                }

                if (!exists)
                {
                    validInput = true;
                }
            }

            System.out.println("Enter Date of Activation:");
            String activationDate = input.nextLine().trim();
            if (activationDate.isEmpty())
            {
                throw new IllegalArgumentException("Activation date cannot be empty.");
            }

            departments.add(new Department(deptName, activationDate));
            System.out.println("Department added successfully!");
        } catch (IllegalArgumentException e)
        {
            System.out.println("Input error: " + e.getMessage());
        } catch (Exception e)
        {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    private static void addOfficers(ArrayList<Officer> officers, ArrayList<Department> departments)
    {
        try {
            if (officers == null) {
                throw new IllegalArgumentException("Officer list cannot be null.");
            }

            if (departments == null || departments.isEmpty()) {
                throw new IllegalArgumentException("No departments available. Cannot add officers.");
            }

            Scanner input = new Scanner(System.in);

            System.out.println("Enter Officer Name:");
            String officerName = input.nextLine().trim();
            if (officerName.isEmpty()) {
                throw new IllegalArgumentException("Officer name cannot be empty.");
            }

            System.out.println("Enter Officer Age:");
            if (!input.hasNextInt()) {
                throw new IllegalArgumentException("Officer age must be a valid number.");
            }
            int officerAge = input.nextInt();
            input.nextLine();

            System.out.println("Enter Officer Salary:");
            if (!input.hasNextInt()) {
                throw new IllegalArgumentException("Officer salary must be a valid number.");
            }
            int officerSalary = input.nextInt();
            input.nextLine();

            System.out.println("Enter Officer Username:");
            String officerUsername = input.nextLine().trim();
            if (officerUsername.isEmpty()) {
                throw new IllegalArgumentException("Officer username cannot be empty.");
            }


            boolean usernameExists = false;
            do {
                usernameExists = false;
                for (Officer off : officers) {
                    if (off.getOfficerUsername().equalsIgnoreCase(officerUsername)) {
                        System.out.println("Officer username already exists! Please try again:");
                        officerUsername = input.nextLine().trim();
                        usernameExists = true;
                        break;
                    }
                }
            } while (usernameExists);

            System.out.println("Enter Officer Password:");
            String officerPassword = input.nextLine().trim();
            if (officerPassword.isEmpty()) {
                throw new IllegalArgumentException("Officer password cannot be empty.");
            }

            System.out.println("Enter Department ID to assign the Officer to:");
            for (Department department : departments) {
                System.out.println("Department ID: " + department.getDepartmentID());
            }


            String departmentID = input.nextLine().trim();
            if (departmentID.isEmpty()) {
                throw new IllegalArgumentException("Department ID cannot be empty.");
            }


            Department selectedDepartment = null;
            for (Department department : departments) {
                if (department.getDepartmentID().equalsIgnoreCase(departmentID)) {
                    selectedDepartment = department;
                    break;
                }
            }

            if (selectedDepartment == null) {
                throw new IllegalArgumentException("Department ID not found.");
            }


            Officer newOfficer = new Officer(officerName, officerAge, officerSalary, officerUsername, officerPassword, departmentID);
            officers.add(newOfficer);

            System.out.println("Officer added successfully and assigned to the department.");
        } catch (IllegalArgumentException e)
        {
            System.out.println("Input error: " + e.getMessage());
        } catch (Exception e)
        {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    public void UpdateCriminal(ArrayList<Criminal> criminals){
        char X = 'N';
        Scanner hisID = new Scanner(System.in);

        System.out.println("Criminals list: ");
        System.out.println("-------------------------------");
        for(Criminal c :criminals)
        {
            System.out.println("ID: "+ c.ID);
        }
        System.out.println("Which criminal do you want to update: ");
        String ID = hisID.nextLine();
        for(Criminal c: criminals)
        {
            if(c.getCriminalID().equals(ID))
            {
                System.out.println("Enter Criminal Address you want to update : ");
                System.out.println("Enter city: ");
                String City = hisID.nextLine();
                System.out.println("Enter District: ");
                String District = hisID.nextLine();
                System.out.println("Enter Street");
                String Street = hisID.nextLine();
                System.out.println("Enter description of area");
                String AreaDescription = hisID.nextLine();
                Location NewAddress = new Location(City,District,Street,AreaDescription);
                c.setAddress(NewAddress);
                System.out.println("Criminal address Updated successfully!");
                return;
            }

        }
        System.out.println("Officer not found");
    }


}


