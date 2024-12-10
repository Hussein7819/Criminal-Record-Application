package com.example.criminalrecordproject.Model;

import com.example.criminalrecordproject.Admin;
import com.example.criminalrecordproject.Department;

import java.util.ArrayList;
import java.util.Scanner;

public class user {
    protected ArrayList<String> Username;
    protected ArrayList<String> Password;

    private String Admin_username="admin";
    private String Admin_password="admin";

    protected ArrayList<Department> departments;
    public user(ArrayList<String> Username, ArrayList<String> Password) {
        this.Username = Username;
        this.Password = Password;
    }
    public user(String Admin_username, String Admin_password) {
        this.Admin_username = Admin_username;
        this.Admin_password = Admin_password;
    }

    public user(ArrayList<Department> departments) {
        this.departments = departments;
    }

    protected void addacounts(String username,String password){
        System.out.println("add account");
        Scanner sc=new Scanner(System.in);
        System.out.println("enter username:");
        username=sc.nextLine();
        this.Username.add(username);
        System.out.println("enter password:");
        password=sc.nextLine();
        this.Password.add(password);
        System.out.println("Created an account successfully!");
    }


    public void login(){
        String username;
        String password;
        while (true){
        System.out.println("login");
        Scanner sc=new Scanner(System.in);
        System.out.println("enter username:");
        username=sc.nextLine();
        System.out.println("enter password:");
        password=sc.nextLine();

            if (username.equals(Admin_username) && password.equals(Admin_password)) {
                Admin admin = new Admin(Admin_username,Admin_password);
                System.out.println("Login successfully!");
                admin.Show_Admin_Menu(departments);
            }
            else {
                for (int i = 0; i < Username.size(); i++) {
                    if (username.equals(Username.get(i)) && password.equals(Password.get(i))) {
                        System.out.println("login successfully");
                    } else {
                        System.out.println("login failed");
                    }
                }
            }
            try{
                System.out.println("1 to close the system\n 2 to login to another account");
                int choice=sc.nextInt();
                switch (choice) {
                    case 1:
                            logout();
                            break;
                            case 2:
                                    System.out.println("Login in to anther account");
                                    break;
                                    default:
                                        System.out.println( "unavailable option");
                                        break;
                }
            }catch (IndexOutOfBoundsException e){
                System.out.println("login failed"+e.getMessage());
                System.out.println("enter the correct format");
                char ch = sc.next().charAt(0);
            }
        }
    }




    protected void logout() {

        System.out.println("logout successfully");
        System.exit(0);
    }



    protected static void addCasesToDepartment(Scanner input, ArrayList<Department> departments)
    {
        System.out.println("Enter Department ID to assign cases:");
        String assignDeptID = input.nextLine();
        Department targetDepartment = null;
        int caseID = 0;
        String description = new String();
        String startDate = new String();
        String crimeType= new String();
        Case newCase = new Case(caseID, description, startDate, crimeType);

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
            System.out.println("Department not found!");
            return;
        }

        System.out.println("How many cases would you like to add?");
        int numCases = input.nextInt();
        input.nextLine();

        for (int i = 0; i < numCases; i++)
        {
            System.out.println("Enter details for case " + (i + 1));
            System.out.println("Enter Case ID:");
            caseID = input.nextInt();
            for(Case c : targetDepartment.getCases()){
                if(c.getCaseId()==caseID){
                    System.out.println("this case ID already exists");
                    return;
                }
            }
            input.nextLine();
            System.out.println("Enter Case Description:");
            description = input.nextLine();
            System.out.println("Enter Start Date:");
            startDate = input.nextLine();
            System.out.println("Enter Crime Type:");
            crimeType = input.nextLine();

            targetDepartment.addCase(newCase);
        }

        System.out.println(numCases + " cases added to department: " + targetDepartment.getDetails());
    }

    protected static void displayDepartments(ArrayList<Department> departments)
    {
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
                System.out.println("\t\tCase ID: " + c.getCaseId() +
                        ", Description: " + c.getDescription() +
                        ", Crime Type: " + c.getCrimeType());
            }
            departmentIndex++;
        }
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Actions :");
        System.out.println("1- add officers to department");
        System.out.println("2- add cases to department");
        System.out.println("3- remove officers from department");
        System.out.println("4- remove cases from department");
        System.out.println("5- Exit menu");

        /*Scanner menu_choice = new Scanner(System.in);
        menu_choice.nextInt();

        switch(menu_choice)
        {
            case 1:

            case 2:
            case 3:
            case 4:
            case 5:
            default:

        }

*/
    }

}

