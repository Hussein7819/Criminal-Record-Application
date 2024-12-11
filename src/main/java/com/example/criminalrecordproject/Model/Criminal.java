package com.example.criminalrecordproject.Model;

import java.util.ArrayList;
import java.util.Scanner;

public class Criminal extends Person
{
    public static int numOfCriminals = 0;
    private String currentLocation;
    private ArrayList<String> Crime;

    public Criminal(String name, String currentLocation)
    {
        this.name = name;
        this.ID = "C" + ++numOfCriminals;
        this.currentLocation = currentLocation;
        this.Crime=new ArrayList<>();
    }

    public String getCriminalID()
    {
        return ID;
    }
    public ArrayList<String> getCrime(){
        return Crime;
    }
    public String getCurrentLocation()
    {
        return currentLocation;
    }

    @Override
    protected void adddetails() {}
    protected void AddCrime(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Add crime");
        Crime.add(sc.next());
    }
}

