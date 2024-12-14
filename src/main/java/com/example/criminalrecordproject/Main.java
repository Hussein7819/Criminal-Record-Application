package com.example.criminalrecordproject;

import com.example.criminalrecordproject.Model.Case;
import com.example.criminalrecordproject.Model.Criminal;
import com.example.criminalrecordproject.Model.Officer;
import com.example.criminalrecordproject.Model.user;
import com.example.criminalrecordproject.Model.Report;
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

        //launch();


        ArrayList<Department> departments = new ArrayList<>();
        ArrayList<Officer> officers = new ArrayList<>();
        ArrayList<Criminal> criminals = new ArrayList<>();
        Scanner input = new Scanner(System.in);


        // Existing departments and cases inside it
        Department homicide = new Department("Homicide", "20/11/2024");
        departments.add(homicide);
        homicide.addCase(new Report(101, "Murder investigation in downtown", "Neighbour1, Neighbour2", "Unknown", "Bloody knife, fingerprints"));
        homicide.addCase(new Report(102, "Suspicious death in a park", "dustman", "Unknown", "DNA samples, footprints"));

        Department cybercrime = new Department("Cybercrime", "21/11/2024");
        departments.add(cybercrime);
        cybercrime.addCase(new Report(201, "Ransomware attack on a company", "Company IT Staff", "Hacker Group", "Encrypted files, ransom note"));
        cybercrime.addCase(new Report(202, "Phishing scam targeting seniors", "Victims A, B, C", "Scammer X", "Email logs, IP addresses"));

        Department forensics = new Department("Forensics", "22/11/2024");
        departments.add(forensics);
        forensics.addCase(new Report(301, "Analysis of blood samples", "Witness D", "Unknown", "Blood samples, fibers"));
        forensics.addCase(new Report(302, "DNA matching for suspects", "Detective X", "Suspect Z", "DNA samples, evidence logs"));

        Department terrorism = new Department("Terrorism", "23/11/2024");
        departments.add(terrorism);
        terrorism.addCase(new Report(401, "Bomb threat in a subway", "Witness A, Witness B", "Terrorist Group X", "Explosives residue, CCTV footage"));
        terrorism.addCase(new Report(402, "Investigation of a terror cell", "Police officer", "Suspect Y", "Communications, funding trail"));

        Department robbery = new Department("Robbery", "24/11/2024");
        departments.add(robbery);
        robbery.addCase(new Report(501, "Bank heist in downtown", "Bank Manager, Security Guard", "Masked Robbers", "CCTV footage, dropped wallet"));
        robbery.addCase(new Report(502, "Jewelry store theft", "Store Owner", "Two individuals", "Gloves, broken glass"));

        // Existing Officers
        Officer o1 = new Officer("Ali Ahmed", 27, 10000, "Ali_Officer1", "Ali1", forensics.departmentID);
        officers.add(o1);
        Officer o2 = new Officer("Ahmed Mohamed", 38, 20000, "Ahmed_Officer2", "Ahmed2", terrorism.departmentID);
        officers.add(o2);

        // Existing Criminals
        Criminal c1 = new Criminal("Mahmoud Mohamed");
        criminals.add(c1);
        Criminal c2 = new Criminal("Ahmed Hussien");
        criminals.add(c2);

        System.out.println("\n\nWelcome to our criminal management system!");
        user u = new user(departments, officers);
        u.login();


    }
}