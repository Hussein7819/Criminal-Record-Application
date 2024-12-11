package com.example.criminalrecordproject.Model;

import java.util.ArrayList;

public class Officer extends Person {

    private int salary;
    private String officerUsername;
    private String officerPassword;
    public static int officerNum = 0;
    private ArrayList<Case> assignedCases;
    private String assignedDepartment;

    public Officer(String name, String phonenumber, int age, int salary, String officerUsername, String officerPassword, String assignedDepartment)
    {
        this.name =name;
        this.ID= "OFF"+ ++officerNum;
        this.phonenumber=phonenumber;
        this.age=age;
        this.salary=salary;
        this.officerUsername=officerUsername;
        this.officerPassword=officerPassword;
        assignedCases= null;
        this.assignedDepartment= assignedDepartment;
    }



    public String getOfficerID()
    {
        return ID;
    }

    public String getAssignedDepartment() {
        return assignedDepartment;
    }

    public void setAssignedCases(ArrayList<Case> assignedCases) {
        this.assignedCases = assignedCases;
    }

    public String getName()
    {
        return name;
    }

    public int getSalary()
    {
        return salary;
    }

    @Override
    protected void adddetails() {}
}

