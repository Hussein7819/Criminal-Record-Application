package com.example.criminalrecordproject;

import com.example.criminalrecordproject.Model.Case;
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

        //launch();


        ArrayList<Department> departments = new ArrayList<>();
        Scanner input = new Scanner(System.in);


        //existing departments and cases inside it
        Department homicide = new Department("Homicide", "20/11/2024");
        homicide.addCase(new Case(101, "Murder investigation in downtown", "15/11/2024", "Homicide"));
        homicide.addCase(new Case(102, "Suspicious death in a park", "17/11/2024", "Homicide"));

        Department cybercrime = new Department("Cybercrime", "21/11/2024");
        cybercrime.addCase(new Case(201, "Ransomware attack on a company", "18/11/2024", "Cybercrime"));
        cybercrime.addCase(new Case(202, "Phishing scam targeting seniors", "19/11/2024", "Cybercrime"));

        Department forensics = new Department("Forensics", "22/11/2024");
        forensics.addCase(new Case(301, "Analysis of blood samples", "20/11/2024", "Forensics"));
        forensics.addCase(new Case(302, "DNA matching for suspects", "21/11/2024", "Forensics"));

        Department terrorism = new Department("Terrorism", "23/11/2024");
        terrorism.addCase(new Case(401, "Bomb threat in a subway", "19/11/2024", "Terrorism"));
        terrorism.addCase(new Case(402, "Investigation of a terror cell", "20/11/2024", "Terrorism"));

        departments.add(homicide);
        departments.add(cybercrime);
        departments.add(forensics);
        departments.add(terrorism);

        System.out.println("\n\nWelcome to our criminal management system!");
        user u = new user(departments);
        u.login();

    }
}
