package com.example.criminalrecordproject.Model;

public class Victim  {
    private int victimId;
    private String victimName;
    private String Location;

    public Victim(int victimId, String victimName, String Location) {
        this.victimId = victimId;
        this.victimName = victimName;
        this.Location=Location;
    }
    //Getter for victim Id
    public int getvictimId() {
        return victimId;
    }

    //setter for location
    public void setLocation(String Location) {
        this.Location = Location;
    }
    //metthod to get victim details
    public String getVictimDetails() {
        return "Victim ID: " + victimId + ", Name: " + victimName + ", Location: " + Location;
    }



}