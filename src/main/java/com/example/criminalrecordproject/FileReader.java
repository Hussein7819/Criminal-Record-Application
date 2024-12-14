package com.example.criminalrecordproject;

import com.example.criminalrecordproject.Model.Officer;
import com.example.criminalrecordproject.Model.Criminal;
import com.example.criminalrecordproject.Model.Case;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    // General method to read objects from a specific directory
    private static List<Object> readObjectsFromDirectory(String directory) {
        List<Object> objects = new ArrayList<>();
        File dir = new File(directory);
        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles((d, name) -> name.endsWith(".ser"));
            if (files != null) {
                for (File file : files) {
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                        Object obj = ois.readObject();
                        objects.add(obj);
                    } catch (IOException | ClassNotFoundException e) {
                        System.err.println("Error reading object from file: " + e.getMessage());
                        e.printStackTrace();
                    }
                }
            }
        }
        return objects;
    }

    // Method to read all data (Departments, Officers, and Criminals) and return them in their respective lists
    public static void readAll(List<Department> departments, List<Officer> officers, List<Criminal> criminals) {
        // Read Departments
        List<Object> departmentObjects = readObjectsFromDirectory(DirSetup.Departments);
        for (Object obj : departmentObjects) {
            if (obj instanceof Department) {
                departments.add((Department) obj);

            }
        }

        // Read Officers
        List<Object> officerObjects = readObjectsFromDirectory(DirSetup.Officers);
        for (Object obj : officerObjects) {
            if (obj instanceof Officer) {
                officers.add((Officer) obj);
            }
        }

        // Read Criminals
        List<Object> criminalObjects = readObjectsFromDirectory(DirSetup.Criminals);
        for (Object obj : criminalObjects) {
            if (obj instanceof Criminal) {
                criminals.add((Criminal) obj);
            }
        }
    }
}
