package com.example.criminalrecordproject.Model;

import java.util.ArrayList;

import com.example.criminalrecordproject.Department;

public class Officer extends Person {

    private int salary;
    private String officerUsername;
    private String officerPassword;
    public static int officerNum = 0;
    private ArrayList<Case> assignedCases;
    private String assignedDepartment;

    public Officer(String name,int age, int salary, String officerUsername, String officerPassword, String assignedDepartment)
    {
        this.name =name;
        this.ID= "OFF"+ ++officerNum;
        this.age=age;
        this.salary=salary;
        this.officerUsername=officerUsername;
        this.officerPassword=officerPassword;
        assignedCases= null;
        this.assignedDepartment= assignedDepartment;
    }

    public String getOfficerUsername() {
        return officerUsername;
    }
    public void setOfficerUsername(String officerUsername) {
        this.officerUsername = officerUsername;
    }
    public String getOfficerPassword() {
        return officerPassword;
    }
    public void setOfficerPassword(String officerPassword) {
        this.officerPassword = officerPassword;
    }
    public String getOfficerID()
    {
        return ID;
    }
    public int getage(){
        return age;
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
    protected void addetails() {}
    protected void  add_officer_department(ArrayList<Department> addtodepartment){

    }
}

