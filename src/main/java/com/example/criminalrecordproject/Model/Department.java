package com.example.criminalrecordproject.Model;

import java.util.ArrayList;

public class Department {

    private String departmentID;
    private String name;
    private String DateOfActivation;
    private static int officersNum=0;
    private static int casesNum=0;
    private ArrayList officers;
    private ArrayList cases;

    public Department(String departmentID, String name, String DateOfActivation) {
        this.departmentID = departmentID;
        this.name = name;
        this.DateOfActivation = DateOfActivation;
        this.officers = new ArrayList();
        this.cases = new ArrayList();
    }

    protected String getDetails() {
        return "ID: " + departmentID + ", Name: " + name + ", Active since: " + DateOfActivation;
    }

    public void setOfficers(ArrayList officers) {
        this.officers = officers;
        officersNum++;
    }

    public void setCases(ArrayList cases) {
        this.cases = cases;
        casesNum++;
    }

    public String getName() {
        return name;
    }

}
