package com.example.criminalrecordproject.Model;

import java.io.Serializable;
import java.util.Scanner;

abstract public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    protected String name;
    public String ID;
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



}
