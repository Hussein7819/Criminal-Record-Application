package com.example.criminalrecordproject.Model;

public class Officer extends Person{

    private String salary;

    public Officer(String name, int age, String phonenumber)
    {
        super(name, age);
        this.phonenumber=phonenumber;
    }

    @Override
    protected void adddetails()
    {

    }
}
