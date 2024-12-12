package com.example.criminalrecordproject.Model;

import java.util.Scanner;

abstract public class Person {
    protected String name;
    protected String ID;
    protected int age;

    public Person(String ID,String name,int age) {
        this.ID=ID;
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    protected void addetails() {
    }

    ;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    protected void changename(String name) //admin modifying names function
    {
        this.name = name;
    }
}
