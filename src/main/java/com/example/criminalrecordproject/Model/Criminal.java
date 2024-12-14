package com.example.criminalrecordproject.Model;

import java.util.ArrayList;
import java.util.Scanner;

import java.io.Serializable;


public class Criminal extends Person implements Serializable  {

    private static final long serialVersionUID = 1L;

    public int criminalIndex=0;

    public static int numOfCriminals = 0;
    private ArrayList<String> Crime;

    public Criminal(String name)
    {
        this.name = name;
        this.ID = "C" + numOfCriminals++;
        this.Crime=new ArrayList<>();
        criminalIndex= numOfCriminals;
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
    protected void AddCrime()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Add crime");
        Crime.add(sc.next());
    }
}

