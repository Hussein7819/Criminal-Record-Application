package com.example.criminalrecordproject;

import com.example.criminalrecordproject.Model.Case;
import com.example.criminalrecordproject.Model.Officer;
import com.example.criminalrecordproject.Model.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Department implements Serializable {
    private static final long serialVersionUID = 1L;

    public String departmentID;
    private String name;
    private String dateOfActivation;
    private ArrayList<Officer> officers;
    private ArrayList<Case> cases;
    public static int numofdepartments = 0;
    public int numofcasesAssigned = 0;
    public int deptNo = 0;

    public Department(String name, String dateOfActivation) {
        this.departmentID = "D" + (numofdepartments++);
        this.name = name;
        this.dateOfActivation = dateOfActivation;
        this.officers = new ArrayList<>();
        this.cases = new ArrayList<>();
        this.deptNo = numofdepartments;
    }


    public String getName() {
        return name;
    }

    public String getDateOfActivation() {
        return dateOfActivation;
    }

    public String getDetails() {
        return "ID: " + departmentID + ", Name: " + name + ", Active since: " + dateOfActivation;
    }


    public void addCase(Case newCase) {
        cases.add(newCase);
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public ArrayList<Case> getCases() {
        return cases;
    }

    public void addOfficer(Officer officer) {
        officers.add(officer);
    }

    public ArrayList<Officer> getOfficer() {
        return officers;
    }

    public String getFileID() {
        return departmentID;
    }


}
