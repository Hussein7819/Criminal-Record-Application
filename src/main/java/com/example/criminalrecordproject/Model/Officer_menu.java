package com.example.criminalrecordproject.Model;

import com.example.criminalrecordproject.Department;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Officer_menu extends user
{
    public Officer_menu(String username, String password)
    {
        super(username, password);
    }

    public void menu(ArrayList<Department> departments, ArrayList<Officer> officers, String Username)
    {
        Scanner input = new Scanner(System.in);
        while (true)
        {
            try {
                System.out.println("======================================================================================");
                System.out.println("\nChoose an action:");
                System.out.println("1-display officers");
                System.out.println("2-display cases");
                System.out.println("3-handle case");
                System.out.println("4-display criminal record");
                System.out.println("5-exit");
                int choice = input.nextInt();
                input.nextLine();

                switch (choice) {
                    case 1:
                        displayOfficers(officers);
                        break;
                    case 2:
                        displayCase(departments,officers,Username);
                        break;
                    case 3:
                        Handle_Case(officers,departments,Username);
                        break;
                        case 4:
                            DisplayCriminals( criminals);
                            break;
                    case 5:
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
    private static void Handle_Case(ArrayList<Officer> officers, ArrayList<Department> departments, String Username) {
        Scanner input = new Scanner(System.in);
        boolean find = false;
        System.out.println("Enter Case ID:");
        int CaseID = input.nextInt();
        input.nextLine();
        while(!find) {
            for (Officer officer : officers) {
                if (officer.getOfficerUsername().equals(Username)) {
                    for (Department department : departments) {
                        for (Case c : department.getCases()) {
                            if (CaseID == c.getCaseId() && c.getOfficer().equals(officer.getOfficerID())) {
                                find = true;
                                System.out.println("\t\tCase ID: " + c.getCaseId() +
                                        ", Description: " + c.getDescription() +
                                        ", Crime Type: " + c.getCrimeType());
                                edit_Case(officers, departments);
                                return;
                            }
                        }
                    }
                }
            }

            if (!find) {
                System.out.println("Invalid Case ID! Please enter a valid number:");
                CaseID = input.nextInt();
                input.nextLine();  // Consume the newline
            }
        }
    }

    protected static void edit_Case(ArrayList<Officer> officers, ArrayList<Department> departments) {
        Scanner input = new Scanner(System.in);

        System.out.println("What do you want to update?");
        System.out.println("1. Location");
        System.out.println("2. Victim");
        System.out.println("3. Report");
        int choice = input.nextInt();
        input.nextLine();  // Consume the newline

        switch (choice) {
            case 1:
                System.out.println("Enter new Location details:");
                System.out.print("City: ");
                String city = input.nextLine();
                System.out.print("District: ");
                String district = input.nextLine();
                System.out.print("Street: ");
                String street = input.nextLine();
                System.out.print("Description of Area: ");
                String descriptionOfArea = input.nextLine();
                Location newLocation = new Location(city, district, street, descriptionOfArea);
                System.out.println("Location updated to: " + newLocation.getFullLocation());
                break;

            case 2:
                System.out.println("Enter Victim ID to update:");
                int victimId = input.nextInt();
                input.nextLine();
                boolean victimFound = false;
                for (Department department : departments) {
                    for (Case c : department.getCases()) {
                        for (Victim v : c.getVictim()) {
                            if (v.getvictimId() == victimId) {
                                victimFound = true;
                                System.out.println("Current details: " + v.getVictimDetails());
                                System.out.print("Enter new Name: ");
                                String newName = input.nextLine();
                                System.out.print("Enter new Location: ");
                                String newVictimLocation = input.nextLine();
                                v.setLocation(newVictimLocation);
                                System.out.println("Victim details updated to: Victim ID: " + victimId + ", Name: " + newName + ", Location: " + newVictimLocation);
                            }
                        }
                    }
                }
                if (!victimFound) {
                    System.out.println("Victim not found.");
                }
                break;

            case 3:
                System.out.println("Enter Case ID to update the report:");
                int caseId = input.nextInt();
                input.nextLine();
                boolean caseFound = false;
                for (Department department : departments) {
                    for (Case c : department.getCases()) {
                        if (c.getCaseId() == caseId) {
                            caseFound = true;
                            System.out.println("Current Report: " + c.getReport());
                            System.out.print("Enter new Report Description: ");
                            String newReportDescription = input.nextLine();
                            System.out.print("Enter Witnesses (comma-separated): ");
                            String witnesses = input.nextLine();
                            System.out.print("Enter Suspects (comma-separated): ");
                            String suspects = input.nextLine();
                            System.out.print("Enter Evidence: ");
                            String evidence = input.nextLine();

                            Report updatedReport = new Report(caseId, newReportDescription, witnesses, suspects, evidence,c.getCrimeType());
                            System.out.println("Report updated to: " + updatedReport.getReport());
                        }
                    }
                }
                if (!caseFound) {
                    System.out.println("Case not found.");
                }
                break;

            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

}
