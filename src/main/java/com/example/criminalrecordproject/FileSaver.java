package com.example.criminalrecordproject;

import com.example.criminalrecordproject.Model.Officer;
import com.example.criminalrecordproject.Model.Criminal;
import com.example.criminalrecordproject.Model.Case;
import com.example.criminalrecordproject.Model.OfficerAuthentication;

import java.io.*;
import java.util.List;
import java.util.UUID;

public class FileSaver {

    // General method to save any object into a specific directory
    public static void saveDept(String directory, Department object, String prefix) {
        try {
            String fileName = directory + prefix + "_" + object.getDepartmentID() + ".ser";
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
                oos.writeObject(object);
                System.out.println("Successfully saved: " + fileName);
            }
        } catch (IOException e) {
            System.err.println("Error saving object to file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void saveCriminal(String directory, Criminal object, String prefix) {
        try {
            String fileName = directory + prefix + "_" + object.getCriminalID() + ".ser";
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
                oos.writeObject(object);
                System.out.println("Successfully saved: " + fileName);
            }
        } catch (IOException e) {
            System.err.println("Error saving object to file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void saveOff(String directory, Officer object, String prefix) {
        try {
            String fileName = directory + prefix + "_" + object.getOfficerID() + ".ser";
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
                oos.writeObject(object);
                System.out.println("Successfully saved: " + fileName);
            }
        } catch (IOException e) {
            System.err.println("Error saving object to file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void saveOffAuth(String directory, OfficerAuthentication object, String prefix) {
        try {
            String fileName = directory + prefix + "_" + object.getOfficers_ID() + ".ser";
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
                oos.writeObject(object);
                System.out.println("Successfully saved: " + fileName);
            }
        } catch (IOException e) {
            System.err.println("Error saving object to file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // General method to save all lists (Departments, Officers, Criminals) into their respective directories
    public static void saveAll(List<Department> departments, List<Officer> officers, List<Criminal> criminals, List<OfficerAuthentication> offAuth) {
        // Save Departments
        for (Department department : departments) {
            saveDept(DirSetup.Departments, department, "Department");
        }

        // Save Officers
        for (Officer officer : officers) {
            saveOff(DirSetup.Officers, officer, "Officer");
        }

        // Save Criminals
        for (Criminal criminal : criminals) {
            saveCriminal(DirSetup.Criminals, criminal, "Criminal");
        }

        // Save Officer-Authentication
        for (OfficerAuthentication offAU : offAuth) {
            saveOffAuth(DirSetup.OfficerAuthentication, offAU , "Authentication");
        }

        // Optionally, you can save Cases if needed, but it's not mandatory in this specific method.
    }
}
