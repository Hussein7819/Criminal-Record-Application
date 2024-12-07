package com.example.criminalrecordproject.Model;

import java.util.ArrayList;
import java.util.Scanner;

public class Criminal extends Person
{
    private String criminalID;
    private String currentLocation;
    private ArrayList<String> Crime;

    public Criminal(String criminalID, String currentLocation)
    {
        this.criminalID = criminalID;
        this.currentLocation = currentLocation;
        this.Crime=new ArrayList<>();
    }

    public String getCriminalID()
    {
        return criminalID;
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

