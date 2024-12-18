package com.example.criminalrecordproject.Model;


import com.example.criminalrecordproject.Department;

import java.io.Serializable;

public class Report implements Serializable {

    private static final long serialVersionUID = 1L;

    public static int reportID=0;
    private String reportDescription;
    private String witnesses;
    private String suspects;
    private String evidence;

    // Constructor for Report with Case ID
    public Report(/*int caseId,*/ String reportDescription, String witnesses, String suspects, String evidence  /*String crimeType-- already in case*/) {
        // super(caseId); // Calls the partial Case constructor
        this.reportID = ++reportID;
        this.reportDescription = reportDescription;
        this.witnesses = witnesses;
        this.suspects = suspects;
        this.evidence = evidence;
    }

    public int getReportID() {
        return reportID;
    }

    public String getReportDescription()
    {
        return reportDescription;
    }

    public void setReportDescription(String reportDescription)
    {
        this.reportDescription = reportDescription;
    }

    public String getWitnesses()
    {
        return witnesses;
    }

    public void setWitnesses(String witnesses)
    {
        this.witnesses = witnesses;
    }

    public String getSuspects()
    {
        return suspects;
    }

    public void setSuspects(String suspects)
    {
        this.suspects = suspects;
    }

    public String getEvidence()
    {
        return evidence;
    }

    public void setEvidence(String evidence)
    {
        this.evidence = evidence;
    }

    public String getReport()
    {
        return "Report Description: " + reportDescription +
                "\nWitnesses: " + witnesses +
                "\nSuspects: " + suspects +
                "\nEvidence: " + evidence;
    }
}

