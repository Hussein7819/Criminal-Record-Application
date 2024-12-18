package com.example.criminalrecordproject.Model;

import java.io.Serializable;

public class Location implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String city;
    private String district;
    private String street;
    private String DiscriptionOfArea;


    public Location(String city, String district, String Street, String DiscriptionOfArea)
    {
        this.city = city;
        this.district = district;
        this.street = street;
        this.DiscriptionOfArea = DiscriptionOfArea;

    }

    public String getFullLocation()
    {
        return city +"-"+district + "-" + street+ "-"+DiscriptionOfArea;
    }

    public String toString()
    {
        return getFullLocation();
    }

}