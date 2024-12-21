package com.example.criminalrecordproject.Model;

import com.example.criminalrecordproject.Model.Person;

import java.io.Serializable;
import java.util.Scanner;

public class Witness extends Person implements Serializable {

    private static final long serialVersionUID = 1L;

    public static int numofwitness = 0 ;
    protected String phonenumber;

   /* public Witness(String name, String phonenumber, int age,int numofwitness) {
        this.ID= this.ID = "W" + numofwitness++;;
        this.phonenumber = phonenumber;
        this.age = age;
        this.name=name;
        this.numofwitness=numofwitness;

    }
    public Witness(String name, String phonenumber, int age) {
        this.ID= this.ID = "W" + numofwitness++;;
        this.phonenumber = phonenumber;
        this.age = age;
        this.name=name;
    }*/

    public Witness(String name,String phonenumber)
    {
        this.ID= this.ID = "W" + numofwitness++;;
        this.name = name;
        this.phonenumber= phonenumber;
    }

   /* public void AddWitness()
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
        System.out.println("enter number of witness");
        numofwitness= x.nextInt();


    }*/

    public void setNumofwitness(int numofwitness) {
        this.numofwitness = numofwitness;
    }

    public int getNumofwitness() {
        return numofwitness;
    }


    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPhonenumber() {
        return phonenumber;
    }
    public String getwitnessid() {
        return ID;
    }
    public String getwitnessname(){
        return name;
    }


}