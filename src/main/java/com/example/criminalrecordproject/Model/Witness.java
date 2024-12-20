package com.example.criminalrecordproject.Model;

import com.example.criminalrecordproject.Model.Person;

import java.util.Scanner;

class Witness extends Person {

   protected String phonenumber;

    public Witness(String name, String ID, String phonenumber, int age) {
        this.ID= ID;
        this.phonenumber = phonenumber;
        this.age = age;
        this.name=name;

    }
    public void AddWitness()
    {
        Scanner x = new Scanner(System.in);
        System.out.println("enter name of witness");
        name=x.next();
        System.out.println("enter id of witness");
        ID=x.next();
        System.out.println("enter phone number of witness");
        phonenumber=x.next();
        System.out.println("enter age of witness");
        age=x.nextInt();


    }
}