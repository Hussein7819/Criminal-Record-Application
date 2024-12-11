package com.example.criminalrecordproject;

import com.example.criminalrecordproject.Model.Case;
import com.example.criminalrecordproject.Model.Officer;

import java.util.ArrayList;

public class Department {
    public String departmentID;
    private String name;
    private String dateOfActivation;
    private ArrayList<Officer> officers;
    private ArrayList<Case> cases;
    public static int numofdepartments = 0;


  /*  public Department(String departmentID, String name, String dateOfActivation)
    {
        this.departmentID = "D" + (++numofdepartments);
        this.name = name;
        this.dateOfActivation = dateOfActivation;
        this.officers = new ArrayList<>();
        this.cases = new ArrayList<>();
    }*/
    public Department(String name, String dateOfActivation)
    {
        this.departmentID= "D" + (++numofdepartments);
        this.name = name;
        this.dateOfActivation = dateOfActivation;
        this.officers = new ArrayList<>();
        this.cases = new ArrayList<>();
    }


    public String getName()
    {
        return name;
    }

    public String getDateOfActivation()
    {
        return dateOfActivation;
    }

    public String getDetails()
    {
        return "ID: " + departmentID + ", Name: " + name + ", Active since: " + dateOfActivation;
    }


    public void addCase(Case newCase)
    {
        cases.add(newCase);
    }

    public String getDepartmentID()
    {
        return departmentID;
    }

    public ArrayList<Case> getCases()
    {
        return cases;
    }
}
