package com.example.criminalrecordproject.Model;

import java.util.ArrayList;

public class OfficerAuthentication {
    protected ArrayList<String> officers_ID;
    protected String case_ID;

    // Constructor should initialize the officers_ID with a list of officer IDs
    public OfficerAuthentication(String case_ID, ArrayList<String> officers_ID) {
        this.case_ID = case_ID;
        this.officers_ID = officers_ID != null ? officers_ID : new ArrayList<>();
    }

    public String getCase_ID() {
        return case_ID;
    }

    public void setCase_ID(String case_ID) {
        this.case_ID = case_ID;
    }

    public ArrayList<String> getOfficers_ID() {
        return officers_ID;
    }

    public void setOfficers_ID(ArrayList<String> officers_ID) {
        this.officers_ID = officers_ID;
    }

    // Method to find an officer by ID, officers list is passed as a parameter
    public static Officer findOfficerByID(String officerID, ArrayList<Officer> officers) {
        for (Officer officer : officers) {
            if (officer.getOfficerID().equals(officerID)) {
                return officer;
            }
        }
        return null; // Return null if the officer is not found
    }
}

