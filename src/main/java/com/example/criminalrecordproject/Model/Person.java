package com.example.criminalrecordproject.Model;

abstract public class Person
{
    protected String name;
    protected int ID;
    protected String phonenumber;
    protected int age;

    public Person(String name, int ID, String phonenumber, int age) {
        this.name = name;
        this.ID = ID;
        this.phonenumber = phonenumber;
        this.age = age;
    }

    public Person() {}

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
