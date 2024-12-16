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

    public static void menu(ArrayList<Department> departments, ArrayList<Officer> officers,ArrayList<OfficerAuthentication> Authentication,String Off_ID)
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
                        displayCase(departments,officers,Off_ID);
                        break;
                    case 3:
                        Handle_Case(officers,departments,Authentication,Off_ID);
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
    private static void Handle_Case(ArrayList<Officer> officers, ArrayList<Department> departments, ArrayList<OfficerAuthentication> Authentication, String Off_ID) {
        Scanner input = new Scanner(System.in);
        boolean find = false;

        while (!find) {
            System.out.println("Enter Case ID:");
            String CaseID = input.nextLine(); // Changed to String to match the type in OfficerAuthentication
            boolean caseIdFound = false;

            for (OfficerAuthentication finding : Authentication) {
                if (finding.getCase_ID().equals(CaseID)) {
                    caseIdFound = true;
                    if (finding.getOfficers_ID().contains(Off_ID)) {
                        find = true;
                        edit_Case(departments, CaseID);
                        return;
                    } else {
                        System.out.println("You are not assigned to this case.");
                        return;
                    }
                }
            }

            if (!caseIdFound) {
                System.out.println("Invalid Case ID! Please enter a valid number:");
            }
        }
    }



    protected static void edit_Case(ArrayList<Department> departments, String CaseID) {
        Scanner input = new Scanner(System.in);

        System.out.println("What do you want to update?");
        System.out.println("1. Location");
        System.out.println("2. Victim");
        System.out.println("3. Report");
        int choice = input.nextInt();
        input.nextLine();  // Consume the newline

        for (Department department : departments) {
            for (Case c : department.getCases()) {
                if (c.getCaseId() == Integer.parseInt(CaseID)) {
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
                            if (!victimFound) {
                                System.out.println("Victim not found.");
                            }
                            break;

                        case 3:
                            System.out.println("Enter new Report details:");
                            System.out.print("Enter new Report Description: ");
                            String newReportDescription = input.nextLine();
                            System.out.print("Enter Witnesses (comma-separated): ");
                            String witnesses = input.nextLine();
                            System.out.print("Enter Suspects (comma-separated): ");
                            String suspects = input.nextLine();
                            System.out.print("Enter Evidence: ");
                            String evidence = input.nextLine();

                            if (c instanceof Report) {
                                ((Report) c).setReportDescription(newReportDescription);
                                ((Report) c).setWitnesses(witnesses);
                                ((Report) c).setSuspects(suspects);
                                ((Report) c).setEvidence(evidence);
                                System.out.println("Report updated to: " + c.getReport());
                            } else {
                                System.out.println("Invalid case type for updating the report.");
                            }
                            break;

                        default:
                            System.out.println("Invalid choice.");
                            break;
                    }
                    return;
                }
            }
        }

        System.out.println("Case ID not found.");
    }

}

