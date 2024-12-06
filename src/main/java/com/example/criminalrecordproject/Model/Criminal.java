package com.example.criminalrecordproject.Model;

public class Criminal extends Person
{
    private String criminalID;
    private String name;
    private String currentLocation;

    public Criminal(String criminalID, String name)
    {
        this.criminalID = criminalID;
        this.name = name;
    }

    public String getCriminalID()
    {
        return criminalID;
    }

    public String getName()
    {
        return name;
    }

    public String getCurrentLocation()
    {
        return currentLocation;
    }

    @Override
    protected void adddetails() {

    }
}

