package com.example.criminalrecordproject;

import com.example.criminalrecordproject.Model.Case;
import com.example.criminalrecordproject.Model.user;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main //extends Application {
{

    /* @Override
     public void start(Stage stage) throws IOException {
         FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("sample.fxml"));
         Scene scene = new Scene(fxmlLoader.load());
         stage.setTitle("Criminal Record");
         stage.setScene(scene);
         stage.show();
     }

     */
    public static void main(String[] args) {

        //launch();


       /* department d1 = new department("D1", "Homicide", "20/11/2024");
        department d2 = new department("D2", "Cybercrime", "21/11/2024");
        department d3 = new department("D3", "Robbery", "22/11/2024");
        department d4 = new department("D4", "Narcotics", "23/11/2024");
        department d5 = new department("D5", "Financialcrime", "24/11/2024");
        department d6 = new department("D6", "Forensics", "25/11/2024");
        department d7 = new department("D7", "Domesticviolence", "26/11/2024");
        department d8 = new department("D8", "Terrorism", "27/11/2024");

        System.out.println("The available departments:");

        System.out.println(d1.getDetails());
        System.out.println(d2.getDetails());
        System.out.println(d3.getDetails());
        System.out.println(d4.getDetails());
        System.out.println(d5.getDetails());
        System.out.println(d6.getDetails());
        System.out.println(d7.getDetails());
        System.out.println(d8.getDetails());*/
        ArrayList<Department> departments = new ArrayList<>();
        Scanner input = new Scanner(System.in);


        //existing departments and cases inside it
        Department homicide = new Department("D1", "Homicide", "20/11/2024");
        homicide.addCase(new Case(101, "Murder investigation in downtown", "15/11/2024", "Homicide"));
        homicide.addCase(new Case(102, "Suspicious death in a park", "17/11/2024", "Homicide"));

        Department cybercrime = new Department("D2", "Cybercrime", "21/11/2024");
        cybercrime.addCase(new Case(201, "Ransomware attack on a company", "18/11/2024", "Cybercrime"));
        cybercrime.addCase(new Case(202, "Phishing scam targeting seniors", "19/11/2024", "Cybercrime"));

        Department forensics = new Department("D3", "Forensics", "22/11/2024");
        forensics.addCase(new Case(301, "Analysis of blood samples", "20/11/2024", "Forensics"));
        forensics.addCase(new Case(302, "DNA matching for suspects", "21/11/2024", "Forensics"));

        Department terrorism = new Department("D4", "Terrorism", "23/11/2024");
        terrorism.addCase(new Case(401, "Bomb threat in a subway", "19/11/2024", "Terrorism"));
        terrorism.addCase(new Case(402, "Investigation of a terror cell", "20/11/2024", "Terrorism"));

        departments.add(homicide);
        departments.add(cybercrime);
        departments.add(forensics);
        departments.add(terrorism);

        System.out.println("\n\nWelcome to our criminal management system!");
        user u = new user(departments);
        u.login();
        /*while (true)
        {
            try
            {
                System.out.println("\nChoose an action:");
                System.out.println("1. Add a new department");
                System.out.println("2. Add new cases to a department");
                System.out.println("3. Display departments and their cases");
                System.out.println("4. Exit");

                int choice = input.nextInt();
                input.nextLine();

                switch (choice)
                {
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
                        input.close();
                        return;

                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } catch (InputMismatchException e)
            {
                System.out.println("Invalid input! Please enter a valid number.");
                input.nextLine();
            } catch (Exception e)
            {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }
    private static void addDepartment(Scanner input, ArrayList<Department> departments)
    {
        System.out.println("Enter Department ID:");
        String deptID = input.nextLine();


        for (Department dept : departments)
        {
            if (dept.getDepartmentID().equals(deptID))
            {
                System.out.println("A department with this ID already exists! Please try again.");
                return;
            }
        }

        System.out.println("Enter Department Name:");
        String deptName = input.nextLine();
        System.out.println("Enter Date of Activation:");
        String activationDate = input.nextLine();

        departments.add(new Department(deptID, deptName, activationDate));
        System.out.println("Department added successfully!");
    }


    private static void addCasesToDepartment(Scanner input, ArrayList<Department> departments)
    {
        System.out.println("Enter Department ID to assign cases:");
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
            int caseID = input.nextInt();
            input.nextLine();
            System.out.println("Enter Case Description:");
            String description = input.nextLine();
            System.out.println("Enter Start Date:");
            String startDate = input.nextLine();
            System.out.println("Enter Crime Type:");
            String crimeType = input.nextLine();

            Case newCase = new Case(caseID, description, startDate, crimeType);
            targetDepartment.addCase(newCase);
        }

        System.out.println(numCases + " cases added to department: " + targetDepartment.getDetails());
    }


    private static void displayDepartments(ArrayList<Department> departments)
    {
        int departmentIndex = 1;
        for (Department dept : departments)
        {
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
    }*/
    }
}
