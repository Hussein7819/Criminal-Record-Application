package com.example.criminalrecordproject.Model;
import com.example.criminalrecordproject.Department;

import java.util.ArrayList;

public class Case
{
    private int caseId;
    private String description;
    private String startDate;
    private String lastUpdateDate;
    private String crimeType;
    private ArrayList<Officer> assignedOfficers;
    private ArrayList<Criminal> criminals;
    public String assignedDept;

    public Case(int caseId, String description, String startDate, String crimeType, String assignedDept)
    {
        this.caseId = caseId;
        this.description = description;
        this.startDate = startDate;
        this.crimeType = crimeType;
        this.assignedOfficers = new ArrayList<>();
        this.criminals = new ArrayList<>();
        this.assignedDept=assignedDept;       //Dept ID
       // this.assignedDept = Integer.parseInt(String Department.numofdepartments);
    }

    public int getCaseId()
    {
        return caseId;
    }

    public String getDescription()
    {
        return description;
    }

    public String getCrimeType()
    {
        return crimeType;
    }

    public String getStartDate()
    {
        return startDate;
    }

    public String getLastUpdateDate()
    {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate)
    {
        this.lastUpdateDate = lastUpdateDate;
    }

    public void addOfficer(Officer officer)
    {
        assignedOfficers.add(officer);
    }
    public ArrayList<Officer> getOfficer()
    {
        return assignedOfficers;
    }
    public void addCriminal(Criminal criminal)
    {
        criminals.add(criminal);
    }
}