package com.example.criminalrecordproject.Model;

import com.example.criminalrecordproject.Admin;
import com.example.criminalrecordproject.Department;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    protected  ArrayList<Officer> officers;
    protected ArrayList<Department> departments;

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
    public user(ArrayList<Department> departments,ArrayList<Officer> officers) {
        this.departments = departments;
        this.officers = officers;
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

            if (username.equals("admin") && password.equals("admin")) {
                Admin admin= new Admin(username,password);
                System.out.println("Login successfully!");
                admin.Show_Admin_Menu(departments,officers);
            }
            else {
                boolean login=false;
                for (int i=0;i<officers.size();i++){
                    if (username.equals(officers.get(i).getOfficerUsername()) && password.equals(officers.get(i).getOfficerPassword())){
                        System.out.println("Login successfully!");
                        login=true;
                        Officer_menu.menu(departments,officers,username);
                    }
                }
                if (login==false){
                    System.out.println("Login failed!");
                }
            }
            try{
                System.out.println("1 to close the system\n 2 logout and return to login ");
                int choice=sc.nextInt();
                switch (choice) {
                    case 1:
                            logout();
                            break;
                            case 2:
                                login();
                                break;
                            default:
                                System.out.println( "unavailable option");
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
        Case newCase = new Case(caseID, description, startDate, crimeType, assignDeptID);

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

           SimpleDateValidation.isValidDate();
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

    }
    protected static void  displayOfficers(ArrayList<Officer> officers)
    {
        int officerIndex = 1;
        for (Officer officer : officers) {
            System.out.println("_______________________________________________________________________________________");
            System.out.println("Officer " + officerIndex + ":");
            System.out.println("\tID: " + officer.getOfficerID());
            System.out.println("\tName: " + officer.getName());
            System.out.println("\tAge"+ officer.getage());
            System.out.println("\tDepartment"+officer.getAssignedDepartment());
            officerIndex++;
        }
    }
    protected static void displayCase(ArrayList<Department> departments,ArrayList<Officer> officers,String user_username){
        int index=0;
        for (Officer officer : officers) {
            if(officer.getOfficerUsername().equals(user_username)){
                for (Department targetDepartment: departments) {
                    for (Case c : targetDepartment.getCases()) {
                        if (officer.getAssignedDepartment().equals(c.assignedDept)) {
                            System.out.println("\t\tCase ID: " + c.getCaseId() +
                                    ", Description: " + c.getDescription() +
                                    ", Crime Type: " + c.getCrimeType());
                        }
                    }
                }
            }
            index++;
        }
    }
    protected static void DeleteDepartments(ArrayList<Department> departments)
    {
        Scanner d1 = new Scanner(System.in );
        System.out.println("Please Enter the department you want to delete");
        String delet = d1.nextLine();
        int x= 0;
        for(int i=0 ; i<departments.size(); i++)
        {
            if(delet.equals(departments.get(i)))
            {

                departments.remove(x) ;
                break;
            }
        }

    }

    public static void Deleteofficers(ArrayList<Officer> officers)
    {
        Scanner d1 = new Scanner(System.in );
        System.out.println("Please Enter the Officer you want to remove");
        String delet = d1.nextLine();
        int x= 0;
        for(int i = 0; i<officers.size(); i++)
        {
            if(delet.equals(officers.get(i)))
            {

                officers.remove(x) ;
                break;
            }
        }

    }

}

