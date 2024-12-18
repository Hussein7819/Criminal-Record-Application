package com.example.criminalrecordproject.Model;

import java.io.Serializable;

public class Victim extends Case implements Serializable {

    private static final long serialVersionUID = 1L;

    private int victimId;
    private String victimName;
    private String Location;

    public Victim(int caseid,int victimId, String victimName, String Location) {
        super(caseid);
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

    @Override
    public String getCaseID() {
        return super.getCaseID();
    }


}