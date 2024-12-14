package com.example.criminalrecordproject.Model;

import com.example.criminalrecordproject.Department;

import java.io.Serializable;
import java.util.ArrayList;

public class Case implements Serializable {

    private static final long serialVersionUID = 1L;

    private int caseId;
    private String description;
    private String startDate;
    private String lastUpdateDate;
    private String crimeType;
    private ArrayList<Officer> assignedOfficers;
    private ArrayList<Criminal> criminals;
    public String assignedDept;

    //for the DB
    public int caseIndex=0;
    public static int numoftotalcases;


    protected ArrayList<Victim> victims;
    public Case(String description, String startDate, String crimeType, Department dept)
    {
        this.caseId = (dept.deptNo*100)+ dept.numofcasesAssigned++;
        this.description = description;
        this.startDate = startDate;
        this.crimeType = crimeType;
        this.assignedOfficers = new ArrayList<>();
        this.criminals = new ArrayList<>();
        this.assignedDept=dept.departmentID;       //Dept ID
        this.victims = new ArrayList<>();

        numoftotalcases++;
        this.caseIndex= numoftotalcases;

    }

    public Case(int caseId)
    {
        this.caseId = caseId;
        this.victims = new ArrayList<>();
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

    public ArrayList<Officer> getOfficer()
    {
        return assignedOfficers;
    }

    public void addCriminal(Criminal criminal)
    {
        criminals.add(criminal);
    }

    public ArrayList<Victim> getVictim()
    {
        return victims;
    }

    public void AddVictim(Victim victim)
    {
        victims.add(victim);
    }


    public String getReport()
    {
        return "No detailed report available for this case.";
    }
}
