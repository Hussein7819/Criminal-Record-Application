package com.example.criminalrecordproject.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Criminal extends Person implements Serializable {

    private static final long serialVersionUID = 1L;

    public int criminalIndex = 0;
    public static int numOfCriminals = 0;
    private ArrayList<String> Crime;
    private String dangerLevel;
    private Location address;

    public Criminal(String name) {
        this.name = name;
        this.ID = "C" + numOfCriminals++;
        this.Crime = new ArrayList<>();
        criminalIndex = numOfCriminals;
        updateDangerLevel(); // Initialize danger level based on existing crimes
    }

    public Criminal(String name, Location address) {
        this(name);
        this.address = address;
    }

    public String getCriminalID() {
        return ID;
    }

    public ArrayList<String> getCrime() {
        return Crime;
    }

    public String getDangerLevel() {
        return dangerLevel;
    }

    public String getAddress() {
        return address != null ? address.toString() : "Address not available";
    }

    public String getName() {
        return name;
    }

    @Override
    protected void addetails() {
    }

    protected void AddCrime() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Add crime:");
        Crime.add(sc.nextLine());
        updateDangerLevel(); // Update danger level after adding a crime
    }

  public void updateDangerLevel() {
        int crimeCount = Crime.size();
        if (crimeCount == 0) {
            dangerLevel = "No Record";
        } else if (crimeCount == 1) {
            dangerLevel = "Normal";
        } else if (crimeCount == 2) {
            dangerLevel = "Moderate";
        } else if (crimeCount >= 3 && crimeCount <= 5) {
            dangerLevel = "Dangerous";
        } else if (crimeCount > 5) {
            dangerLevel = "Insane";
        }
    }


}
