package com.example.criminalrecordproject.Model;

public class Officer extends Person {
    private String officerID;
    private String name;
    private int Salary;

    public Officer(String officerID, String name)
    {
        this.officerID = officerID;
        this.name = name;
    }

    public String getOfficerID()
    {
        return officerID;
    }

    public String getName()
    {
        return name;
    }

    public int getSalary()
    {
        return Salary;
    }

    @Override
    protected void adddetails() {}
}