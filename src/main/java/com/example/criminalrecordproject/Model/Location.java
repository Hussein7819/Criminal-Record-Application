package com.example.criminalrecordproject.Model;

import java.io.Serializable;

public class Location implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String city;
    private String district;
    private String street;
    private String DiscriptionOfArea;


    public Location(String city, String district, String street, String descriptionOfArea) {
        if (city == null || district == null || street == null || descriptionOfArea == null) {
            throw new IllegalArgumentException("All fields must be provided.");
        }
        this.city = city;
        this.district = district;
        this.street = street;
        this.DiscriptionOfArea = descriptionOfArea;
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