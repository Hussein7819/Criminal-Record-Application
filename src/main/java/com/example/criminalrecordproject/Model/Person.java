package com.example.criminalrecordproject.Model;

abstract public class Person
{
    protected String name;
    protected int ID;
    protected String phonenumber;
    protected int age;


    abstract protected void adddetails();

    public Person(String name,int age)
    {
        this.name=name;
        this.age=age;
    }


     protected void changename(String name) //admin modifying names function
    {
        this.name=name;
    }

    protected void ChangePhoneNumber(String phonenumber)
    {
        this.phonenumber=phonenumber;
    }










}
