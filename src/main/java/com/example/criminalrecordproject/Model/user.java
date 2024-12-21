package com.example.criminalrecordproject.Model;

import com.example.criminalrecordproject.Admin;
import com.example.criminalrecordproject.Department;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;



public class user {

    private String User_username;
    private String User_password;
    protected static ArrayList<Officer> officers;
    protected ArrayList<Department> departments;
    protected static ArrayList<Criminal> criminals;
    protected static ArrayList<OfficerAuthentication> Authentication;
    protected static ArrayList<Case> cases;

    public class DateValidation {

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

    public user(ArrayList<Department> departments, ArrayList<Officer> officers, ArrayList<Criminal> criminals, ArrayList<OfficerAuthentication> Authentication) {
        this.departments = departments;
        this.officers = officers;
        this.criminals = criminals;
        this.Authentication = Authentication;
    }

    public void login() {
        String username;
        String password;
        //  while (true) {
        System.out.println("login");
        Scanner sc = new Scanner(System.in);
        System.out.println("enter username:");
        username = sc.nextLine();
        System.out.println("enter password:");
        password = sc.nextLine();

        if (username.equals("admin") && password.equals("admin")) {
            Admin admin = new Admin(username, password);
            System.out.println("Login successfully!");
            admin.Show_Admin_Menu(departments, officers, criminals, Authentication, cases);
        } else {
            boolean login = false;
            for (Officer Off : officers) {
                if (username.equals(Off.getOfficerUsername()) && password.equals(Off.getOfficerPassword())) {
                    System.out.println("Login successfully!");
                    login = true;
                    Officer_menu.menu(departments, officers, Authentication, Off.getOfficerID());
                }
            }
            if (login == false) {
                System.out.println("Login failed!");
            }
        }
        try {
            System.out.println("1 to save and close the system\n 2 logout and return to login ");
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
//}


    protected void logout() {

        System.out.println("logout successfully");


    }

    protected static void addCasesToDepartment(Scanner input, ArrayList<Department> departments, ArrayList<Officer> officers, ArrayList<Criminal> criminals) {
        try {
            System.out.println("Enter Department ID to assign cases: ");
            String assignDeptID = input.nextLine();

            Department targetDepartment = null;
            for (Department dept : departments)
            {
                if (dept.getDepartmentID().equals(assignDeptID))
                {
                    targetDepartment = dept;
                    break;
                }
            }

            if (targetDepartment == null)
            {
                throw new IllegalArgumentException("Department not found!");
            }

            System.out.println("How many cases would you like to add?");
            int numCases = input.nextInt();
            input.nextLine();

            if (numCases <= 0)
            {
                throw new IllegalArgumentException("Number of cases must be positive.");
            }

            ArrayList<String> crimes = new ArrayList<>();
            for (int i = 0; i < numCases; i++)
            {
                System.out.println("Enter details for case " + (i + 1));

                System.out.println("Enter Case Date:");
                String startDate = input.nextLine();

                if (startDate.isEmpty())
                {
                    throw new IllegalArgumentException("Start Date cannot be empty!");
                }

                System.out.println("Enter Crime Type:(format crime type:describe the situation)");
                String crimeType = input.nextLine();

                if (crimeType.isEmpty())
                {
                    throw new IllegalArgumentException("Crime Type cannot be empty!");
                }

                crimes.add(crimeType);

                System.out.println("Enter Case Report Description:");
                String reportDescription = input.nextLine();

                if (reportDescription.isEmpty())
                {
                    throw new IllegalArgumentException("Report Description cannot be empty!");
                }

                System.out.println("Enter Witness data:");
                System.out.println("Name:");
                String witnessName = input.nextLine();
                if (witnessName.isEmpty()) {
                    throw new IllegalArgumentException("Witness Name cannot be empty!");
                }

                System.out.println("Phone number:");
                String witnessNumber = input.nextLine();

                if (witnessNumber.isEmpty()) {
                    throw new IllegalArgumentException("Witness Phone Number cannot be empty!");
                }

                System.out.println("Enter Suspects:");
                String suspects = input.nextLine();

                System.out.println("Enter Evidence:");
                String evidence = input.nextLine();

                Report caseReport = new Report(reportDescription, new Witness(witnessName, witnessNumber), suspects, evidence);
                Case newCase = new Case("New case for " + crimeType, startDate, crimeType, targetDepartment, caseReport);

                System.out.println("How many criminals would you like to assign to this case?");
                int numCriminals = input.nextInt();
                input.nextLine();

                if (numCriminals < 0) {
                    throw new IllegalArgumentException("The number of criminals cannot be negative.");
                }

                for (int k = 0; k < numCriminals; k++)
                {
                    System.out.println("Enter Criminal ID to assign to this case:");
                    String criminalID = input.nextLine();
                    Criminal criminal = null;

                    for (Criminal tempCriminal : criminals)
                    {
                        if (tempCriminal.getCriminalID().equals(criminalID))
                        {
                            criminal = tempCriminal;
                            break;
                        }
                    }

                    if (criminal == null)
                    {
                        System.out.println("Criminal not found. Creating a new one.");
                        System.out.println("Enter Criminal Name:");
                        String criminalName = input.nextLine();

                        if (criminalName.isEmpty()) {
                            throw new IllegalArgumentException("Criminal Name cannot be empty!");
                        }

                        System.out.println("Enter Criminal Address:");
                        System.out.println("City:");
                        String city = input.nextLine();

                        if (city.isEmpty()) {
                            throw new IllegalArgumentException("City cannot be empty!");
                        }

                        System.out.println("District:");
                        String district = input.nextLine();
                        System.out.println("Street:");
                        String street = input.nextLine();
                        System.out.println("Area description:");
                        String area = input.nextLine();
                        Location loc = new Location(city, district, street, area);

                        System.out.println("Enter Danger Level (Low, Moderate, High, Very High):");
                        String dangerLevel = input.nextLine();

                        if (dangerLevel.isEmpty()) {
                            throw new IllegalArgumentException("Danger Level cannot be empty!");
                        }

                        criminal = new Criminal(criminalName, loc, dangerLevel, crimes);
                        criminals.add(criminal);
                        crimes = new ArrayList<>();
                    }
                    newCase.addCriminal(criminal);
                }

                targetDepartment.addCase(newCase);
                System.out.println("Case added successfully to department " + targetDepartment.getDepartmentID());
            }
        } catch (InputMismatchException e)
        {
            System.out.println("Invalid input. Please enter the correct data type.");
            input.nextLine();
        } catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        } catch (Exception e)
        {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    protected static void displayDepartments(ArrayList<Department> departments, ArrayList<OfficerAuthentication> Authentications, ArrayList<Officer> officers) {
        try {
            if (departments == null || departments.isEmpty())
            {
                throw new IllegalArgumentException("No departments to display.");
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


                for (Case c : dept.getCases())
                {

                    System.out.println("\tCase ID: " + c.getCaseID() +
                            ", Description: " + c.getDescription() +
                            ", Start Date: " + c.getStartDate() +
                            ", Crime Type: " + c.getCrimeType());


                    Report caseReport = c.getCaseReport();
                    System.out.println("\t\tReport Details:");
                    System.out.println("\t\t\tDescription: " + caseReport.getReportDescription());
                    System.out.println("\t\t\tWitness: " + caseReport.getwitnessData(caseReport));
                    System.out.println("\t\t\tSuspects: " + caseReport.getSuspects());
                    System.out.println("\t\t\tEvidence: " + caseReport.getEvidence());


                    System.out.println("\t\tCriminals assigned to this case:");
                    for (Criminal criminal : c.criminals)
                    {
                        System.out.println("\t\t\t" + criminal.getName() + " (" + criminal.getCriminalID() + ")");
                    }

                    // Display officers assigned to the case
                    System.out.println("\t\tOfficers assigned to this case:");
                    for (OfficerAuthentication auth : Authentications)
                    {
                        if (auth.getCase_ID().equals(c.getCaseID()))
                        {
                            for (String officerID : auth.getOfficers_ID())
                            {
                                for (Officer officer : officers) {
                                    if (officer.getOfficerID().equals(officerID))
                                    {
                                        System.out.println("\t\t\t" + officer.getName() + " (Officer ID: " + officer.getOfficerID() + ")");
                                    }
                                }
                            }
                        }
                    }
                }
                departmentIndex++;
            }
        } catch (Exception e) {
            System.out.println("An error occurred while displaying departments: " + e.getMessage());
        }
    }


    protected static void displayOfficers(ArrayList<Officer> officers)
    {
        try {
            if (officers == null || officers.isEmpty())
            {
                throw new IllegalArgumentException("No officers to display.");

            }
            int officerIndex = 1;
            for (Officer officer : officers)
            {
                System.out.println("_______________________________________________________________________________________");
                System.out.println("Officer " + officerIndex + ":");
                System.out.println("\tID: " + officer.getOfficerID());
                System.out.println("\tName: " + officer.getName());
                System.out.println("\tAge: " + officer.getage());
                String assignedDepartment = officer.getAssignedDepartment(); // Assuming this method exists
                if (assignedDepartment != null) {
                    System.out.println("\tDepartment: " + assignedDepartment);
                } else {
                    System.out.println("\tDepartment: Not assigned yet");
                }
                officerIndex++;
            }
        } catch (Exception e)
        {
            System.out.println("An error occurred while displaying officers: " + e.getMessage());
        }
    }

    protected static void displayCase(ArrayList<Department> departments, ArrayList<Officer> officers, ArrayList<OfficerAuthentication> Authentications, String Off_ID) {
        try
        {
            boolean officerFound = false;
            boolean caseFound = false;

            if (Off_ID == null || Off_ID.trim().isEmpty()) {
                throw new IllegalArgumentException("Officer ID cannot be null or empty.");
            }

            for (Officer officer : officers)
            {
                if (officer.getOfficerID().equals(Off_ID))
                {
                    officerFound = true;

                    for (OfficerAuthentication auth : Authentications)
                    {
                        if (auth.getOfficers_ID().contains(Off_ID))
                        {
                            caseFound = true;

                            for (Department department : departments)
                            {
                                for (Case c : department.getCases())
                                {
                                    if (c.getCaseID().equals(auth.getCase_ID()))
                                    {
                                        System.out.println("\tCase ID: " + c.getCaseID() +
                                                ", Description: " + c.getDescription() +
                                                ", Crime Type: " + c.getCrimeType());
                                        System.out.println("\tCase Report: " + c.getReport());
                                    }
                                }
                            }
                        }
                    }
                    break;
                }
            }

            if (!officerFound)
            {
                throw new IllegalArgumentException("Officer ID not found.");
            } else if (!caseFound)
            {
                throw new IllegalArgumentException("No cases assigned to this officer.");
            }
        } catch (Exception e)
        {
            System.out.println("An error occurred while displaying cases: " + e.getMessage());
        }
    }

    protected static void DeleteDepartments(ArrayList<Department> departments)
    {
        try
        {
            if (departments == null || departments.isEmpty())
            {
                throw new IllegalArgumentException("No departments available to delete.");
            }

            Scanner d1 = new Scanner(System.in);
            System.out.println("Please enter the Department ID you want to delete:");
            String deleteID = d1.nextLine();

            if (deleteID == null || deleteID.trim().isEmpty())
            {
                throw new IllegalArgumentException("Department ID cannot be null or empty.");
            }

            boolean departmentFound = false;
            for (int i = 0; i < departments.size(); i++)
            {
                if (departments.get(i).getDepartmentID().equals(deleteID))
                {
                    departments.remove(i);
                    departmentFound = true;
                    System.out.println("Department with ID '" + deleteID + "' has been deleted.");
                    break;
                }
            }

            if (!departmentFound)
            {
                throw new IllegalArgumentException("Department with ID '" + deleteID + "' not found.");
            }
        } catch (Exception e)
        {
            System.out.println("An error occurred while attempting to delete the department: " + e.getMessage());
        }
    }

    public static void Deleteofficers(ArrayList<Officer> officers, ArrayList<Department> departments,ArrayList<OfficerAuthentication> Authentications) {
        Scanner d1 = new Scanner(System.in);
        boolean exist = false;
        do {
            try
            {
                System.out.println("Please Enter the Officer ID you want to remove:");
                String deleteID = d1.nextLine();

                if (deleteID == null || deleteID.trim().isEmpty()) {
                    throw new IllegalArgumentException("Officer ID cannot be null or empty.");
                }

                Officer officerToRemove = null;


                for (Officer officer : officers)
                {
                    if (deleteID.equals(officer.getOfficerID()))
                    {
                        officerToRemove = officer;
                        break;
                    }
                }
                for (OfficerAuthentication authentication : Authentications)
                {
                    if(authentication.getOfficers_ID().contains(deleteID))
                    {
                        authentication.getOfficers_ID().remove(deleteID);
                    }
                }

                if (officerToRemove != null)
                {
                    for (Department department : departments)
                    {
                        for (Case c : department.getCases())
                        {
                            if (c.getOfficer().contains(officerToRemove.getOfficerID()))
                            {
                                c.getOfficer().remove(officerToRemove.getOfficerID());
                                System.out.println("Officer removed from Case ID: " + c.getCaseID());
                            }
                        }
                    }

                    System.out.println("Officer removed from all assigned cases successfully.");
                    exist = true;
                    break;
                } else
                {
                    throw new IllegalArgumentException("Officer ID not found.");
                }

            } catch (Exception e)
            {
                System.out.println("Error: " + e.getMessage() + " Please try again.");
            }
        } while (!exist);
    }



    public static void DeleteCase(ArrayList<Department> departments)
    {
        Scanner d1 = new Scanner(System.in);
        boolean caseFound = false;
        do
        {

            try
            {
                System.out.println("Please Enter the Case ID you want to delete");
               String deleteID = d1.nextLine();

                if (deleteID == null || deleteID.trim().isEmpty()) {
                    throw new IllegalArgumentException("Case ID cannot be null or empty.");
                }

                for (Department department : departments)
                {
                    for (int i = 0; i < department.getCases().size(); i++)
                    {
                        if (deleteID.equals(department.getCases().get(i).getCaseID()))
                        {
                            department.getCases().remove(i);
                            System.out.println("Case deleted successfully.");
                            caseFound = true;
                            break;
                        }
                    }
                }
                if (!caseFound)
                {
                    throw new IllegalArgumentException("Case not found.");
                }
            } catch (Exception e)
            {
                System.out.println("The Case Does not exist Please Try again. ");
            }

        } while (!caseFound);
    }

    protected void AssignOfficers(ArrayList<Officer> officers, ArrayList<Department> departments, ArrayList<OfficerAuthentication> Authentications)
    {
        try {

            if (officers == null || officers.isEmpty()) {
                throw new IllegalArgumentException("Officer list cannot be null or empty.");
            }

            if (departments == null || departments.isEmpty()) {
                throw new IllegalArgumentException("Department list cannot be null or empty.");
            }

            if (Authentications == null) {
                throw new IllegalArgumentException("Authentication list cannot be null.");
            }



            Scanner d1 = new Scanner(System.in);
            System.out.println("Please Enter the Officer ID you want to assign:");
            String assign_Officer = d1.nextLine().trim();

            if (assign_Officer.isEmpty()) {
                throw new IllegalArgumentException("Officer ID cannot be empty.");
            }

            System.out.println("Please Enter the Case ID you want to assign:");
            String assign_Case = d1.nextLine().trim();

            if (assign_Case.isEmpty()) {
                throw new IllegalArgumentException("Case ID cannot be empty.");
            }

            boolean officerFound = false;
            boolean caseFound = false;

            System.out.println("Logging officer IDs:");
            for (Officer officer : officers)
            {
                System.out.println("Officer ID: " + officer.getOfficerID());
            }

            Officer officer = OfficerAuthentication.findOfficerByID(assign_Officer, officers);
            if (officer == null)
            {
                throw new IllegalArgumentException("Officer ID not found.");

            }

            String assignedDepartmentID = officer.getAssignedDepartment();

            if (assignedDepartmentID == null || assignedDepartmentID.trim().isEmpty()) {
                throw new IllegalStateException("Officer does not have an assigned department.");
            }

            System.out.println("Officer's Assigned Department: " + assignedDepartmentID);


            for (Department department : departments)
            {
                if (department.getDepartmentID().equals(assignedDepartmentID))
                {
                    System.out.println("Found the officer's department: " + department.getDepartmentID());

                    for (Case c : department.getCases())
                    {
                        System.out.println("Checking case: " + c.getCaseID());
                        if (assign_Case.equals(c.getCaseID()))
                        {
                            caseFound = true;
                            System.out.println("Case found: " + c.getCaseID());

                            boolean alreadyAssigned = false;
                            for (OfficerAuthentication auth : Authentications)
                            {
                                if (auth.getCase_ID().equals(assign_Case))
                                {
                                    if (!auth.getOfficers_ID().contains(assign_Officer))
                                    {
                                        System.out.println("Assigning officer " + assign_Officer + " to case " + assign_Case);
                                        auth.getOfficers_ID().add(assign_Officer);
                                    }
                                    else
                                    {
                                        alreadyAssigned = true;
                                        System.out.println("Officer is already assigned to this case.");
                                    }
                                    break;
                                }
                            }


                            if (!alreadyAssigned)
                            {
                                System.out.println("Creating new OfficerAuthentication for case " + assign_Case);
                                OfficerAuthentication assign = new OfficerAuthentication(assign_Case, new ArrayList<>());
                                assign.getOfficers_ID().add(assign_Officer);
                                Authentications.add(assign);
                            }


                            System.out.println("Officer assigned successfully to case " + assign_Case + "!");
                            return;
                        }
                    }
                }
            }

            if (!caseFound)
            {
                throw new IllegalArgumentException("Case ID not found or does not match the officer's assigned department.");
            }
        } catch (Exception e)
        {
            System.out.println("An error occurred while assigning officers: " + e.getMessage());
        }
    }


    protected static void DisplayCriminals(ArrayList<Criminal> criminals) {
        try {
            if (criminals == null || criminals.isEmpty())
            {
                throw new IllegalArgumentException("No criminals to display.");
            }
            int i = 1;
            for (Criminal c : criminals)
            {
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



