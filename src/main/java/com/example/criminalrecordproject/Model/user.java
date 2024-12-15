package com.example.criminalrecordproject.Model;

import com.example.criminalrecordproject.Admin;
import com.example.criminalrecordproject.Department;
import com.example.criminalrecordproject.Model.user;
import com.example.criminalrecordproject.Model.Officer;

import java.util.ArrayList;
import java.util.Scanner;

public class user {

    /* private ArrayList<Officer> Username;
         private ArrayList<Officer> Password;
     */
    /*private String Admin_username="admin";
    private String Admin_password="admin";

     */
    private String User_username;
    private String User_password;
    protected ArrayList<Officer> officers;
    protected ArrayList<Department> departments;
    protected static ArrayList<Criminal> criminals;

    /*public user(ArrayList<Officer> Username, ArrayList<Officer> Password) {
        this.Username = Username;
        this.Password = Password;
    }*/
    /*public user(String Admin_username, String Admin_password) {
        this.Admin_username = Admin_username;
        this.Admin_password = Admin_password;
    }

     */
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

    public user(ArrayList<Department> departments, ArrayList<Officer> officers, ArrayList<Criminal> criminals) {
        this.departments = departments;
        this.officers = officers;
        this.criminals = criminals;
    }


   /* protected void addacounts(String username,String password){
        System.out.println("add account");
        Scanner sc=new Scanner(System.in);
        System.out.println("enter username:");
        username=sc.nextLine();
        this.Username.add(username);
        System.out.println("enter password:");
        password=sc.nextLine();
        this.Password.add(password);
        System.out.println("Created an account successfully!");
    }*/


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
                admin.Show_Admin_Menu(departments, officers, criminals);
            } else {
                boolean login = false;
                for (int i = 0; i < officers.size(); i++) {
                    if (username.equals(officers.get(i).getOfficerUsername()) && password.equals(officers.get(i).getOfficerPassword())) {
                        System.out.println("Login successfully!");
                        login = true;
                        Officer_menu.menu(departments, officers, username);
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

        System.out.println("Enter Department ID to assign cases:");
        String assignDeptID = input.nextLine();

        for (Department dept : departments) {
            if (dept.getDepartmentID().equals(assignDeptID)) {
                targetDepartment = dept;
                break;
            }
        }

        if (targetDepartment == null) {
            System.out.println("Department not found! Please try again.");
            return;
        }

        System.out.println("How many cases would you like to add?");
        int numCases = input.nextInt();
        input.nextLine(); // Consume newline

        for (int i = 0; i < numCases; i++) {
            System.out.println("Enter details for case " + (i + 1) + ":");

            // Get case description
            System.out.println("Enter Case Description:");
            String description = input.nextLine();


            String startDate;
            while (true) {
                System.out.println("Enter Start Date (format: dd/MM/yyyy):");
                startDate = input.nextLine();
                if (startDate.matches("\\d{2}/\\d{2}/\\d{4}")) { // Regex for dd/MM/yyyy
                    break;
                } else {
                    System.out.println("Invalid date format! Please use dd/MM/yyyy.");
                }
            }


            System.out.println("Enter Crime Type:");
            String crimeType = input.nextLine();


            Case newCase = new Case(caseId,description, startDate, crimeType);
            targetDepartment.addCase(newCase);

            System.out.println("Case added successfully to department: " + targetDepartment.getName());
        }

        System.out.println(numCases + " case(s) added to department: " + targetDepartment.getName());
    }


    protected static void displayDepartments(ArrayList<Department> departments) {
        int departmentIndex = 1;
        for (Department dept : departments) {
            System.out.println("_______________________________________________________________________________________");
            System.out.println("Department " + departmentIndex + ":");
            System.out.println("\tID: " + dept.getDepartmentID());
            System.out.println("\tName: " + dept.getName());
            System.out.println("\tDate of Activation: " + dept.getDateOfActivation());
            System.out.println("\tCases assigned to this department:");
            for (Case c : dept.getCases()) {
                if (c instanceof Report) {
                    Report report = (Report) c;
                    System.out.println("\t\tCase ID: " + report.getCaseId() +
                            ", Report Details: " + report.getReport()
                    );
                } else {
                    System.out.println("\t\tCase ID: " + c.getCaseId() +
                            ", Description: " + c.getDescription() +
                            ", Crime Type: " + c.getCrimeType());
                }
            }
            departmentIndex++;
        }

    }

    protected static void displayOfficers(ArrayList<Officer> officers) {
        int officerIndex = 1;
        for (Officer officer : officers) {
            System.out.println("_______________________________________________________________________________________");
            System.out.println("Officer " + officerIndex + ":");
            System.out.println("\tID: " + officer.getOfficerID());
            System.out.println("\tName: " + officer.getName());
            System.out.println("\tAge" + officer.getage());
            System.out.println("\tDepartment" + officer.getAssignedDepartment());
            officerIndex++;
        }
    }

    protected static void displayCase(ArrayList<Department> departments, ArrayList<Officer> officers, String user_username) {
        int index = 0;
        for (Officer officer : officers) {
            if (officer.getOfficerUsername().equals(user_username)) {
                for (Department targetDepartment : departments) {
                    if (officer.getAssignedDepartment().equals(targetDepartment.getDepartmentID())) {
                        for (Case c : targetDepartment.getCases()) {
                            if (c instanceof Report) {
                                Report report = (Report) c;
                                System.out.println("\t\tCase ID: " + report.getCaseId() +
                                        ", Report Details: " +
                                        report.getReport());
                            } else {
                                System.out.println("\t\tCase ID: " + c.getCaseId() +
                                        ", Description: " + c.getDescription() +
                                        ", Crime Type: " + c.getCrimeType());
                            }
                        }
                    }
                }
            }
            index++;
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

    protected static void AssignOfficers(ArrayList<Officer> officers, ArrayList<Department> departments) {
        Scanner d1 = new Scanner(System.in);
        try {
            System.out.println("Please Enter the Officer ID you want to assign:");
            String assign = d1.nextLine();

            System.out.println("Please Enter the Case ID you want to assign:");
            String assign2 = d1.nextLine();

            boolean officerFound = false;
            boolean caseFound = false;

            // Iterate over officers to check if the officer ID exists
            for (Officer officer : officers) {
                if (assign.equals(officer.getOfficerID())) {
                    officerFound = true;

                    // Iterate over departments to find the department containing the case
                    for (Department department : departments) {
                        for (Case c : department.getCases()) {
                            if (assign2.equals(c.getCaseId())) {
                                caseFound = true;
                                c.setAssignedOfficers(officer.getOfficerID());
                                System.out.println("Officer " + officer.getName() + " has been assigned to case " + c.getCaseId() + " successfully.");
                                break; // Exit the inner loop as the case has been found and assigned
                            }
                        }
                        if (caseFound) break; // Exit the outer loop if case has been assigned
                    }
                    break; // Exit the officer loop if officer has been found and assigned
                }
            }

            // If no officer was found with the provided ID
            if (!officerFound) {
                System.out.println("Error: Officer with ID " + assign + " not found.");
            }

            // If no case was found with the provided ID
            if (!caseFound) {
                System.out.println("Error: Case with ID " + assign2 + " not found.");
            }

        } catch (Exception e) {
            System.out.println("An error occurred while assigning the officer: " + e.getMessage());
        }
    }


    protected static void DisplayCriminals(ArrayList<Criminal> criminals)
    {

        int i = 1;
        for (Criminal c : criminals)
        {
            System.out.println("Criminal #" + i++ + ":");
            System.out.println("  ID: " + c.getCriminalID());
            System.out.println("  Name: " + c.getName());
            System.out.println("  Address: " + c.getAddress());
            System.out.println("  Danger Level: " + c.getDangerLevel());

            if (c.getCrime().isEmpty())
            {
                System.out.println("  Crimes: None");
            } else {
                System.out.println("  Crimes:");
                for (int x = 0; x < c.getCrime().size(); x++)
                {
                    System.out.println("    " + (x + 1) + ". " + c.getCrime().get(x));
                }
            }
            System.out.println("---------------------------------------------------");
        }
    }

}



