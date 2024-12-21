package com.example.criminalrecordproject.Model;

import com.example.criminalrecordproject.Department;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Officer_menu extends user {
    public Officer_menu(String username, String password) {
        super(username, password);
    }

    public static void menu(ArrayList<Department> departments, ArrayList<Officer> officers, ArrayList<OfficerAuthentication> Authentication, String Off_ID) {
        Scanner input = new Scanner(System.in);
        while (true) {
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
                        displayCase(departments, officers,Authentication, Off_ID);
                        break;
                    case 3:
                        Handle_Case(officers, departments, Authentication, Off_ID);
                        break;
                    case 4:
                        DisplayCriminals(criminals);
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
            try {
                System.out.println("Enter Case ID:");
                String CaseID = input.nextLine(); // Read Case ID as String

                if (CaseID.isEmpty()) {
                    System.out.println("Case ID cannot be empty. Please enter a valid Case ID.");
                    continue; // Skip the rest and ask for input again
                }

                boolean caseIdFound = false;

                // Loop through OfficerAuthentication to find the Case ID
                for (OfficerAuthentication finding : Authentication) {
                    if (finding.getCase_ID().equals(CaseID)) {
                        caseIdFound = true;

                        // Check if the officer is assigned to the case
                        if (finding.getOfficers_ID().contains(Off_ID)) {
                            find = true; // Officer is found for the case
                            edit_Case(departments, CaseID); // Call method to edit the case
                            return;
                        } else {
                            System.out.println("You are not assigned to this case.");
                            return; // Exit if officer is not assigned to the case
                        }
                    }
                }

                // If no case with the entered Case ID is found
                if (!caseIdFound) {
                    System.out.println("Invalid Case ID! Please enter a valid Case ID.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                e.printStackTrace(); // Optionally print the stack trace for debugging
            }
        }
    }



    protected static void edit_Case(ArrayList<Department> departments, String CaseID) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.println("What do you want to update?");
            System.out.println("1. Location");
            System.out.println("2. Victim");
            System.out.println("3. Report");

            // Exception handling for non-integer inputs
            int choice;
            try {
                choice = input.nextInt();
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                return; // Exit the method if invalid input is entered.
            }
            input.nextLine();  // Consume the newline character

            // Parse CaseID and handle NumberFormatException
            int caseId;
            try {
                caseId = Integer.parseInt(CaseID);
            } catch (NumberFormatException e) {
                System.out.println("Invalid Case ID format. Please enter a valid integer Case ID.");
                return;
            }

            // Loop through departments to find the case by ID
            boolean caseFound = false;
            for (Department department : departments) {
                for (Case c : department.getCases()) {
                    if (c.getCaseID().equals(CaseID)) {
                        caseFound = true; // Case found, now proceed to update

                        switch (choice) {
                            case 1: // Update Location
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

                            case 2: // Update Victim
                                System.out.println("Enter Victim ID to update:");
                                int victimId;
                                try {
                                    victimId = input.nextInt();
                                    input.nextLine(); // Consume the newline character
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid Victim ID format.");
                                    return; // Exit if invalid victim ID entered
                                }

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
                                        break;
                                    }
                                }
                                if (!victimFound) {
                                    System.out.println("Victim not found.");
                                }
                                break;

                            case 3: // Update Report
                                System.out.println("Enter new Report details:");
                                System.out.print("Enter new Report Description: ");
                                String newReportDescription = input.nextLine();

                                System.out.print("Enter Witness data (comma-separated): ");
                                System.out.println("Name: ");
                                String witnessname= input.nextLine();
                                System.out.println("Phone-number: ");
                                String witnessnumber = input.nextLine();

                                System.out.print("Enter Suspects (comma-separated): ");
                                String suspects = input.nextLine();
                                System.out.print("Enter Evidence: ");
                                String evidence = input.nextLine();

                                //if (c instanceof Report) {
                                   // Report reportCase = (Report) c;
                                    c.getCaseReport().setReportDescription(newReportDescription);
                                    c.getCaseReport().setWitnesses(new Witness(witnessname,witnessnumber));
                                    c.getCaseReport().setSuspects(suspects);
                                    c.getCaseReport().setEvidence(evidence);
                                    System.out.println("Report updated to: " + c.getReport());
                               // } else {
                               //   System.out.println("Invalid case type for updating the report.");
                               // }
                                break;

                            default:
                                System.out.println("Invalid choice.");
                                break;
                        }
                        return; // Exit once the case is found and updated
                    }
                }
            }

            // If no case is found with the given ID
            if (!caseFound) {
                System.out.println("Case ID not found.");
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}