package com.example.criminalrecordproject.Model;


import com.example.criminalrecordproject.Department;

import java.util.ArrayList;

public class Case {
    protected int caseId;
    protected String description;
    protected String startDate;
    protected String crimeType;
    protected ArrayList<String> assignedOfficers;
    protected ArrayList<Criminal> criminals;
    protected String assignedDept; // Department ID
    protected ArrayList<Victim> victims;
    private String lastUpdateDate;

    public Case(int caseId, String description, String startDate, String crimeType)
    {
        this.caseId = caseId; // Set case ID explicitly
        this.description = description;
        this.startDate = startDate;
        this.crimeType = crimeType;
        this.assignedOfficers = new ArrayList<>();
        this.criminals = new ArrayList<>();
        this.victims = new ArrayList<>();
    }



    public int getCaseId() {
        return caseId;
    }

    public String getDescription() {
        return description;
    }

    public String getCrimeType() {
        return crimeType;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public ArrayList<String> getOfficer() {
        return assignedOfficers;
    }

    public void addCriminal(Criminal criminal) {
        criminals.add(criminal);
    }

    public ArrayList<Victim> getVictim() {
        return victims;
    }

    public void AddVictim(Victim victim) {
        victims.add(victim);
    }

    public void setAssignedOfficers(String off) {
        this.assignedOfficers.add(off);
    }

    public String getReport() {
        return "No detailed report available for this case.";
    }
}
