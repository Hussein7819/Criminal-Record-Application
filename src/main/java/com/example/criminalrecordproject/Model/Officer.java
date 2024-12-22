package com.example.criminalrecordproject.Model;

import java.util.ArrayList;

import java.io.Serializable;

import com.example.criminalrecordproject.Department;

public class Officer extends Person implements Serializable {

    private static final long serialVersionUID = 1L;

    private int salary;
    private String officerUsername;
    private String officerPassword;
    public static int officerNum = 0;
    private ArrayList<Case> assignedCases;
    private String assignedDepartment;
    public int officerIndex=0;

    public Officer(String name,int age, int salary, String officerUsername, String officerPassword, String assignedDepartment)
    {
        this.name =name;
        this.ID= "OFF"+ officerNum++;
        this.age=age;
        this.salary=salary;
        this.officerUsername=officerUsername;
        this.officerPassword=officerPassword;
        assignedCases= null;
        this.assignedDepartment= assignedDepartment;
        this.officerIndex= officerNum;
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
    public  void setofficerId(String officerId){
        ID=officerId;
    }
    public int getage(){
        return age;
    }
    public void setage(int age){
        this.age=age;
    }
    public void setsalary(int salary){
        this.salary=salary;
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
    public String getID(){return ID;}
    public void setName(String name){
        this.name=name;
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

