package com.example.criminalrecordproject.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Criminal extends Person implements Serializable {

    private static final long serialVersionUID = 1L;

    public static int numOfCriminals = 0; // Tracks total criminals
    private ArrayList<String> Crime; // List of crimes committed by the criminal
    private Location address;
    private String dangerLevel; // Danger level specific to each criminal

    // Constructor to initialize the criminal with name and generate ID
    public Criminal(String name, Location criminalAddress, String dangerLevel, ArrayList<String>crime) {
        this.name = name;
        this.ID = "C" + numOfCriminals++;
        this.Crime = new ArrayList<>();
        for(String c: crime)
        {
            this.Crime.add(c);
        }
        this.dangerLevel = dangerLevel;
        this.address=criminalAddress;

    }

    // Overloaded constructor to initialize with address
    public Criminal(String name, Location address) {
        this.name = name;  // Directly assign name
        this.ID = "C" + numOfCriminals++;  // Set a unique ID
        this.Crime = new ArrayList<>();  // Initialize Crime as an empty list
        this.dangerLevel = dangerLevel;
        this.address = address;  // Assign the location address
    }

    // Getter for Criminal ID
    public String getCriminalID() {
        return ID;
    }

    // Getter for crimes list
    public ArrayList<String> getCrime() {
        return Crime;
    }

    // Getter for danger level
    public String getDangerLevel() {
        return dangerLevel;
    }

    // Getter for address
    public String getAddress() {
        return address != null ? address.toString() : "Address not available";
    }

    public void setAddress(Location address) {
        this.address = address;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    @Override
    protected void addetails() {}

    // Add a crime and update the danger level based on number of crimes
    public void AddCrime() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Add crime:");
        String crime = sc.nextLine();
        Crime.add(crime); // Add the crime to the criminal's list
        updateDangerLevel(); // Update the danger level after adding the crime
    }

    // Recalculate the danger level based on the number of crimes for this individual criminal
    public void updateDangerLevel() {
        int numOfCrimes = Crime.size(); // Number of crimes committed by the current criminal

        if (numOfCrimes == 0) {
            dangerLevel = "No Record";
        } else if (numOfCrimes == 1) {
            dangerLevel = "Low";
        } else if (numOfCrimes >= 2 && numOfCrimes <= 3) {
            dangerLevel = "Moderate";
        } else if (numOfCrimes >= 4 && numOfCrimes < 5) {
            dangerLevel = "High";
        } else {
            dangerLevel = "Very High";
        }
    }
}
