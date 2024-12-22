package com.example.criminalrecordproject.Model;

import com.example.criminalrecordproject.Department;
import com.example.criminalrecordproject.Model.Criminal;

import java.io.Serializable;
import java.util.ArrayList;

public class Case implements Serializable {

    private static final long serialVersionUID = 1L;

    private static int caseReports_num=0;

    private int caseId;
    private String description;
    private String startDate;
    private String crimeType;
    private ArrayList<String> assignedOfficers;
    protected ArrayList<Criminal> criminals;
    public String assignedDept;
    /*private String reportDescription;
    private String witnesses;
    private String suspects;
    private String evidence;*/

    //for the DB
    public int caseIndex=0;
    public static int numoftotalcases;
    private Report caseReport;

    protected ArrayList<Victim> victims;


      public Case(String description, String startDate, String crimeType, Department dept, Report caseReport)
     {
        this.caseId = (dept.deptNo*100)+ dept.numofcasesAssigned++;
        this.description = description;
        this.startDate = startDate;
        this.crimeType = crimeType;
        this.assignedOfficers = new ArrayList<String>();
        this.criminals = new ArrayList<>();
        this.assignedDept=dept.departmentID;       //Dept ID
        this.caseReport= new Report(caseReport.getReportDescription(),caseReport.getWitnesses(), caseReport.getSuspects(), caseReport.getEvidence());

        numoftotalcases++;
        this.caseIndex= numoftotalcases;
    }


    public void addOfficer(Officer officer) {
        if (officer == null) {
            throw new IllegalArgumentException("Officer cannot be null");
        }
        if (!this.assignedOfficers.contains(officer.getOfficerUsername())) {
            this.assignedOfficers.add(officer.getOfficerUsername());
            System.out.println("Officer " + officer.getOfficerUsername() + " assigned to case " + this.caseId);
        } else {
            System.out.println("Officer is already assigned to this case.");
        }
    }

    public Case(int caseId) {
        this.caseId = caseId;
    }
    public String getCaseID() {
        return String.valueOf(this.caseId); // Convert caseId to String if needed.
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


    public ArrayList<String> getOfficer()
    {
        return assignedOfficers;
    }

    public void addCriminal(Criminal criminal) {
        if (criminal != null && !criminals.contains(criminal)) {
            criminals.add(criminal);
            System.out.println("Criminal " + criminal.getCriminalID() + " added to case " + this.caseId);
        } else {
            System.out.println("Criminal already added or invalid.");
        }
    }

    public void setAssignedOfficers(String off){
        this.assignedOfficers.add(off);
    }

    public Report getCaseReport(){
          return caseReport;
    }

    public void setCaseReport(){
          this.caseReport=caseReport;
    }

    public String getReport()
    {
       // return "No detailed report available for this case.";
        return "Report Description: " + caseReport.getReportDescription() +
                "\nWitnesses: " + caseReport.getwitnessData(caseReport) +
                "\nSuspects: " + caseReport.getSuspects() +
                "\nEvidence: " + caseReport.getEvidence()+
                "\nDate of last update: "+ caseReport.Date;
    }


}
