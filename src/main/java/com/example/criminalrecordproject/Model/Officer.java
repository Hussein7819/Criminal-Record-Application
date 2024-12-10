package com.example.criminalrecordproject.Model;

public class Officer extends Person {

    private int salary;
    private String officerUsername;
    private String officerPassword;
    public static int officerNum = 0;

    public Officer(String name, String ID, String phonenumber, int age, int salary, String officerUsername, String officerPassword)
    {
        this.name =name;
        this.ID= "OFF"+ ++officerNum;
        this.phonenumber=phonenumber;
        this.age=age;
        this.salary=salary;
        this.officerUsername=officerUsername;
        this.officerPassword=officerPassword;

    }



    public String getOfficerID()
    {
        return ID;
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

