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

                switch (choice)
                {
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
        try {
            if (officers == null || departments == null || Authentication == null)
            {
                throw new IllegalArgumentException("Input lists cannot be null.");
            }
            if (Off_ID == null || Off_ID.trim().isEmpty())
            {
                throw new IllegalArgumentException("Officer ID cannot be null or empty.");
            }

            Scanner input = new Scanner(System.in);
            boolean find = false;

            while (!find)
            {
                try {
                    System.out.println("Enter Case ID:");
                    String CaseID = input.nextLine().trim();

                    if (CaseID.isEmpty())
                    {
                        System.out.println("Case ID cannot be empty. Please enter a valid Case ID.");
                        continue;
                    }

                    boolean caseIdFound = false;

                    for (OfficerAuthentication finding : Authentication)
                    {
                        if (finding.getCase_ID().equals(CaseID))
                        {
                            caseIdFound = true;


                            if (finding.getOfficers_ID().contains(Off_ID))
                            {
                                find = true;
                                edit_CaseReport(departments, CaseID);
                                return;
                            } else {
                                System.out.println("You are not assigned to this case.");
                                return;
                            }
                        }
                    }


                    if (!caseIdFound)
                    {
                        System.out.println("Invalid Case ID! Please enter a valid Case ID.");
                    }
                } catch (Exception e)
                {
                    System.out.println("An error occurred while handling the case: " + e.getMessage());
                }
            }
        } catch (IllegalArgumentException e)
        {
            System.out.println("Input error: " + e.getMessage());
        } catch (Exception e)
        {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }



    protected static void edit_CaseReport(ArrayList<Department> departments, String CaseID)
    {
        Scanner input = new Scanner(System.in);

        try {
            if (departments == null || departments.isEmpty())
            {
                throw new IllegalArgumentException("Department list cannot be null or empty.");
            }
            if (CaseID == null || CaseID.trim().isEmpty())
            {
                throw new IllegalArgumentException("Case ID cannot be null or empty.");
            }

            boolean caseFound = false;
            for (Department department : departments)
            {
                for (Case c : department.getCases())
                {
                    if (c.getCaseID().equals(CaseID))
                    {
                        caseFound = true;

                        if (c.getCaseReport() == null)
                        {
                            System.out.println("Case report is missing for this case.");
                            return;
                        }

                        System.out.println("Enter new Report details:");
                        System.out.print("Enter new Report Description: ");
                        String newReportDescription = input.nextLine();
                        System.out.print("Enter Witness Name: ");
                        String witnessName = input.nextLine();
                        System.out.print("Enter Witness Phone-number: ");
                        String witnessNumber = input.nextLine();
                        System.out.print("Enter Suspects (comma-separated): ");
                        String suspects = input.nextLine();
                        System.out.print("Enter Evidence: ");
                        String evidence = input.nextLine();

                        c.getCaseReport().setReportDescription(newReportDescription);
                        c.getCaseReport().setWitnesses(new Witness(witnessName, witnessNumber));
                        c.getCaseReport().setSuspects(suspects);
                        c.getCaseReport().setEvidence(evidence);

                        System.out.println("Report updated successfully.");
                        return; // Exit after updating
                    }
                }
            }

            if (!caseFound)
            {
                throw new IllegalArgumentException("Case ID not found.");
            }
        } catch (IllegalArgumentException e)
        {
            System.out.println("Input error: " + e.getMessage());
        } catch (Exception e)
        {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

}