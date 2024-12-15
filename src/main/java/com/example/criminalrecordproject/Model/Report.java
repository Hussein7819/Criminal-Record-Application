package com.example.criminalrecordproject.Model;


import com.example.criminalrecordproject.Department;

public class Report extends Case {
    private String reportDescription;
    private String witnesses;
    private String suspects;
    private String evidence;

    // Constructor for Report with Case ID
    public Report(int caseId, String reportDescription, String witnesses, String suspects, String evidence, String crimeType) {
        super(caseId, reportDescription, "Not Provided", "Not Provided"); // Calling the Case constructor
        this.reportDescription = reportDescription;
        this.witnesses = witnesses;
        this.suspects = suspects;
        this.evidence = evidence;
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


    @Override
    public String getReport()
    {
        return "Report Description: " + reportDescription +
                "\nWitnesses: " + witnesses +
                "\nSuspects: " + suspects +
                "\nEvidence: " + evidence;
    }
}

