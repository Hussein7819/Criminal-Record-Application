package com.example.criminalrecordproject.Model;

import com.example.criminalrecordproject.Admin;
import com.example.criminalrecordproject.Department;

import java.util.ArrayList;
import java.util.Scanner;

public class user {

    private String User_username;
    private String User_password;
    protected ArrayList<Officer> officers;
    protected ArrayList<Department> departments;
    protected static ArrayList<Criminal> criminals;
    protected static ArrayList<OfficerAuthentication> Authentication;

    public class SimpleDateValidation {

        public static void isValidDate() {
            boolean isValid = false;
            String date = "";

            Scanner in = new Scanner(System.in);

            while (!isValid) {
                System.out.println("Enter Start Date (dd/MM):");
                date = in.nextLine();


                if (date.chars().filter(ch -> ch == '/').count() != 1) {
                    System.out.println("Invalid Date format. Please enter in dd/MM format.");
                    continue;
                }


                String[] parts = date.split("/");
                if (parts.length != 2) {
                    System.out.println("Invalid Date format. Please enter in dd/MM format.");
                    continue;
                }

                try {

                    int day = Integer.parseInt(parts[0]);
                    int month = Integer.parseInt(parts[1]);


                    if (day <= 24 && day > 0 && month <= 12 && month > 0) {
                        System.out.println("Valid Date format.");
                        isValid = true;
                    } else {
                        System.out.println("Invalid Date. Day should be ≤ 24, and Month should be ≤ 12.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid Date format. Please enter numeric values for day and month.");
                }
            }
        }

    }

    public user(String User_username, String User_password) {
        this.User_username = User_username;
        this.User_password = User_password;
    }

    public user(ArrayList<Department> departments, ArrayList<Officer> officers, ArrayList<Criminal> criminals,ArrayList<OfficerAuthentication> Authentication) {
        this.departments = departments;
        this.officers = officers;
        this.criminals = criminals;
        this.Authentication = Authentication;
    }
    public void login() {
        String username;
        String password;
        while (true) {
            System.out.println("login");
            Scanner sc = new Scanner(System.in);
            System.out.println("enter username:");
            username = sc.nextLine();
            System.out.println("enter password:");
            password = sc.nextLine();

            if (username.equals("admin") && password.equals("admin")) {
                Admin admin = new Admin(username, password);
                System.out.println("Login successfully!");
                admin.Show_Admin_Menu(departments, officers, criminals,Authentication);
            } else {
                boolean login = false;
                for (Officer Off:officers) {
                    if (username.equals(Off.getOfficerUsername()) && password.equals(Off.getOfficerPassword())) {
                        System.out.println("Login successfully!");
                        login = true;
                        Officer_menu.menu(departments, officers,Authentication,Off.getOfficerID());
                    }
                }
                if (login == false) {
                    System.out.println("Login failed!");
                }
            }
            try {
                System.out.println("1 to close the system\n 2 logout and return to login ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        logout();
                        return;
                    case 2:
                        login();
                        break;
                    default:
                        System.out.println("unavailable option");
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("login failed" + e.getMessage());
                System.out.println("enter the correct format");
                char ch = sc.next().charAt(0);
            }
        }
    }


    protected void logout() {

        System.out.println("logout successfully");


    }


    protected static void addCasesToDepartment(Scanner input, ArrayList<Department> departments) {
        Department targetDepartment = null;
        System.out.println("Enter Department ID to assign cases: ");
        String assignDeptID = input.nextLine();
        for (Department dept : departments) {
            if (dept.getDepartmentID().equals(assignDeptID)) {
                targetDepartment = dept;
                break;
            }
        }

        int caseID = 0;
        String description = new String();
        String startDate = new String();
        String crimeType = new String();
        Case newCase = new Case(description, startDate, crimeType, targetDepartment);

        for (Department dept : departments) {
            if (dept.getDepartmentID().equals(assignDeptID)) {
                targetDepartment = dept;
                break;
            }
        }

        if (targetDepartment == null) {
            System.out.println("Department not found!");
            return;
        }

        System.out.println("How many cases would you like to add?");
        int numCases = input.nextInt();
        //   input.nextLine();

        for (int i = 0; i < numCases; i++) {
            System.out.println("Enter details for case " + (i + 1));
            input.nextLine();
            System.out.println("Enter Case Description:");
            description = input.nextLine();

            SimpleDateValidation.isValidDate();
            System.out.println("Enter Crime Type:");
            crimeType = input.nextLine();

            targetDepartment.addCase(newCase);
        }

        System.out.println(numCases + " cases added to department: " + targetDepartment.getDepartmentID());
    }

    protected static void displayDepartments(ArrayList<Department> departments)
    {
        try {
            if (departments == null || departments.isEmpty())
            {
                System.out.println("No departments to display.");
                return;
            }
            int departmentIndex = 1;
            for (Department dept : departments)
            {
                System.out.println("_______________________________________________________________________________________");
                System.out.println("Department " + departmentIndex + ":");
                System.out.println("\tID: " + dept.getDepartmentID());
                System.out.println("\tName: " + dept.getName());
                System.out.println("\tDate of Activation: " + dept.getDateOfActivation());
                System.out.println("\tCases assigned to this department:");
                for (Case c : dept.getCases()) {
                    System.out.println("Case ID: " + c.getCaseId() +
                            ", Description: " + c.getDescription() +
                            ", Start Date: " + c.getStartDate() +
                            ", Crime type: " + c.getCrimeType());
                }
                departmentIndex++;
            }
        } catch (Exception e)
        {
            System.out.println("An error occurred while displaying departments: " + e.getMessage());
        }
    }
    protected static void displayOfficers(ArrayList<Officer> officers)
    {
        try {
            if (officers == null || officers.isEmpty())
            {
                System.out.println("No officers to display.");
                return;
            }
            int officerIndex = 1;
            for (Officer officer : officers)
            {
                System.out.println("_______________________________________________________________________________________");
                System.out.println("Officer " + officerIndex + ":");
                System.out.println("\tID: " + officer.getOfficerID());
                System.out.println("\tName: " + officer.getName());
                System.out.println("\tAge: " + officer.getage());
                System.out.println("\tDepartment: " + officer.getAssignedDepartment());
                officerIndex++;
            }
        } catch (Exception e)
        {
            System.out.println("An error occurred while displaying officers: " + e.getMessage());
        }
    }

    protected static void displayCase(ArrayList<Department> departments, ArrayList<Officer> officers, String Off_ID) {
        try {
            boolean officerFound = false;
            for (Officer officer : officers) {
                if (officer.getOfficerID().equals(Off_ID))
                {
                    officerFound = true;
                    for (Department targetDepartment : departments)
                    {
                        if (officer.getAssignedDepartment().equals(targetDepartment.getDepartmentID()))
                        {
                            for (Case c : targetDepartment.getCases())
                            {
                                //if (c instanceof Report)
                                //{
                                   // Report report = (Report) c;

                             //   System.out.println("\t\tCase ID: " + report.getReportID() +
                               //             ", Report Details: " + report.getReport());
                                //} else
                                //{
                                    System.out.println("\t\tCase ID: " + c.getCaseId() +
                                            ", Description: " + c.getDescription() +
                                            ", Crime Type: " + c.getCrimeType());
                                    System.out.println("Case report" + c.getReport());
                                //}
                            }
                        }
                    }
                }
            }
            if (!officerFound)
            {
                System.out.println("Officer ID not found.");
            }
        } catch (Exception e)
        {
            System.out.println("An error occurred while displaying cases: " + e.getMessage());
        }
    }

    protected static void DeleteDepartments(ArrayList<Department> departments) {
        Scanner d1 = new Scanner(System.in);
        System.out.println("Please Enter the department you want to delete");
        String delete = d1.nextLine();
        int x = 0;
        for (int i = 0; i < departments.size(); i++) {
            if (delete.equals(departments.get(i))) {

                departments.remove(x);
                break;
            }
        }

    }

    public static void Deleteofficers(ArrayList<Officer> officers) {
        Scanner d1 = new Scanner(System.in);
        System.out.println("Please Enter the Officer ID you want to remove");
        String deleteID = d1.nextLine();
        boolean officerFound = false;
        for (int i = 0; i < officers.size(); i++) {
            if (deleteID.equals(officers.get(i).getOfficerID())) {
                officers.remove(i);
                System.out.println("Officer removed successfully.");
                officerFound = true;
                return;
            }
        }
        if (!officerFound) {
            System.out.println("Officer not found.");
        }
    }

    public static void DeleteCase(ArrayList<Department> departments) {
        Scanner d1 = new Scanner(System.in);
        System.out.println("Please Enter the Case ID you want to delete");
        int deleteID = d1.nextInt();
        boolean caseFound = false;
        for (Department department : departments) {
            for (int i = 0; i < department.getCases().size(); i++) {
                if (deleteID == department.getCases().get(i).getCaseId()) {
                    department.getCases().remove(i);
                    System.out.println("Case deleted successfully.");
                    caseFound = true;
                    return;
                }
            }
        }
        if (!caseFound) {
            System.out.println("Case not found.");
        }
    }

    protected static void AssignOfficers(ArrayList<Officer> officers, ArrayList<Department> departments, ArrayList<OfficerAuthentication> Authentications)
    {
        try {
            Scanner d1 = new Scanner(System.in);
            System.out.println("Please Enter the Officer ID you want to assign:");
            String assign_Officer = d1.nextLine();
            System.out.println("Please Enter the Case ID you want to assign:");
            String assign_Case = d1.nextLine();

            boolean officerFound = false;
            boolean caseFound = false;

            for (Officer officer : officers)
            {
                if (assign_Officer.equals(officer.getOfficerID()))
                {
                    officerFound = true;
                    for (Department department : departments)
                    {
                        for (Case c : department.getCases())
                        {
                           // if (c instanceof Report) {
                           //     Report report = (Report) c;
                                if (assign_Case.equals(String.valueOf(c.getCaseId())) && officer.getAssignedDepartment().equals(department.getDepartmentID()))
                                {
                                    caseFound = true;
                                    boolean alreadyAssigned = false;
                                    for (OfficerAuthentication auth : Authentications)
                                    {
                                        if (auth.getCase_ID().equals(assign_Case))
                                        {
                                            if (!auth.getOfficers_ID().contains(assign_Officer))
                                            {
                                                auth.getOfficers_ID().add(assign_Officer);
                                            }
                                            alreadyAssigned = true;
                                            break;
                                        }
                                    }

                                    if (!alreadyAssigned)
                                    {
                                        OfficerAuthentication assign = new OfficerAuthentication(assign_Case, String.valueOf(new ArrayList<>()));
                                        assign.getOfficers_ID().add(assign_Officer);
                                        Authentications.add(assign);
                                    }

                                    System.out.println("Officer assigned successfully!");
                                    return;
                                }
                            }
                        }
                    }
                }
           // }

            if (!officerFound)
            {
                System.out.println("Officer ID not found.");
            } else if (!caseFound)
            {
                System.out.println("Case ID not found or does not match the officer's department.");
            }
        } catch (Exception e)
        {
            System.out.println("An error occurred while assigning officers: " + e.getMessage());
        }
    }


    protected static void DisplayCriminals(ArrayList<Criminal> criminals)
    {
        try
        {
            if (criminals == null || criminals.isEmpty())
            {
                System.out.println("No criminals to display.");
                return;
            }
            int i = 1;
            for (Criminal c : criminals) {
                System.out.println("Criminal #" + i++ + ":");
                System.out.println("  ID: " + c.getCriminalID());
                System.out.println("  Name: " + c.getName());
                System.out.println("  Address: " + c.getAddress());
                System.out.println("  Danger Level: " + c.getDangerLevel());

                if (c.getCrime() == null || c.getCrime().isEmpty())
                {
                    System.out.println("  Crimes: None");
                }
                else
                {
                    System.out.println("  Crimes:");
                    for (int x = 0; x < c.getCrime().size(); x++)
                    {
                        System.out.println("    " + (x + 1) + ". " + c.getCrime().get(x));
                    }
                }
                System.out.println("---------------------------------------------------");
            }
        } catch (Exception e)
        {
            System.out.println("An error occurred while displaying criminals: " + e.getMessage());
        }
    }


}



