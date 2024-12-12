package com.example.criminalrecordproject.Model;

import java.util.ArrayList;
import java.util.Scanner;

public class Criminal extends Person
{
    public static int numOfCriminals = 0;
    private ArrayList<String> Crime;

    public Criminal(String name)
    {
        this.name = name;
        this.ID = "C" + ++numOfCriminals;
        this.Crime=new ArrayList<>();
    }

    public String getCriminalID()
    {
        return ID;
    }
    public ArrayList<String> getCrime(){
        return Crime;
    }

    @Override
    protected void addetails() {}
    protected void AddCrime(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Add crime");
        Crime.add(sc.next());
    }
}

