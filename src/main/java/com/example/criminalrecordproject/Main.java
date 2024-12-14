package com.example.criminalrecordproject;

import com.example.criminalrecordproject.Model.Case;
import com.example.criminalrecordproject.Model.Criminal;
import com.example.criminalrecordproject.Model.Officer;
import com.example.criminalrecordproject.Model.user;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main //extends Application {
{
/*
    @Override
     public void start(Stage stage) throws IOException {
         FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("sample.fxml"));
         Scene scene = new Scene(fxmlLoader.load());
         stage.setTitle("Criminal Record");
         stage.setScene(scene);
         stage.show();
     }*/

    public static void main(String[] args) {

        DirSetup.setupDirectory();


        ArrayList<Department> departments = new ArrayList<>();
        ArrayList<Officer> officers = new ArrayList<>();
        ArrayList<Criminal> criminals = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        // Read the existing data from the directories into the lists
        FileReader.readAll(departments, officers, criminals);
        Department.numofdepartments=departments.size();
        Criminal.numOfCriminals=criminals.size();
        Officer.officerNum=officers.size();


        // Pre-existing departments and cases (only if no existing data is found)
        if (departments.isEmpty()) {
            Department homicide = new Department("Homicide", "20/11/2024");
            departments.add(homicide);
            homicide.addCase(new Case("Murder investigation in downtown", "15/11/2024", "Homicide", homicide));
            homicide.addCase(new Case("Suspicious death in a park", "17/11/2024", "Homicide", homicide));

            Department cybercrime = new Department("Cybercrime", "21/11/2024");
            departments.add(cybercrime);
            cybercrime.addCase(new Case("Ransomware attack on a company", "18/11/2024", "Cybercrime", cybercrime));
            cybercrime.addCase(new Case("Phishing scam targeting seniors", "19/11/2024", "Cybercrime", cybercrime));

            Department forensics = new Department("Forensics", "22/11/2024");
            departments.add(forensics);
            forensics.addCase(new Case("Analysis of blood samples", "20/11/2024", "Forensics", forensics));
            forensics.addCase(new Case("DNA matching for suspects", "21/11/2024", "Forensics", forensics));

            Department terrorism = new Department("Terrorism", "23/11/2024");
            departments.add(terrorism);
            terrorism.addCase(new Case("Bomb threat in a subway", "19/11/2024", "Terrorism", terrorism));
            terrorism.addCase(new Case("Investigation of a terror cell", "20/11/2024", "Terrorism", terrorism));
        }

        // Pre-existing Officers
        if (officers.isEmpty()) {
            Officer o1 = new Officer("Ali Ahmed", 27, 10000, "Ali_Officer1", "Ali1", "D1");
            officers.add(o1);
            Officer o2 = new Officer("Ahmed Mohamed", 38, 20000, "Ahmed_Officer2", "Ahmed2", "D2");
            officers.add(o2);
        }

        // Pre-existing Criminals
        if (criminals.isEmpty()) {
            Criminal c1 = new Criminal("Mahmoud Mohamed");
            criminals.add(c1);
            Criminal c2 = new Criminal("Ahmed Hussien");
            criminals.add(c2);
        }

        // Welcome message
        System.out.println("\n\nWelcome to our criminal management system!");

        // Create user and call login
        user u = new user(departments, officers);
        u.login();

        FileSaver.saveAll(departments, officers, criminals);

        }
    }


