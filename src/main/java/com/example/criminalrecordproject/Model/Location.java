package com.example.criminalrecordproject.Model;

public class Location
{
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
        return street +"-"+district + "-" + city+ "-"+DiscriptionOfArea;
    }

    public String toString()
    {
        return getFullLocation();
    }

}