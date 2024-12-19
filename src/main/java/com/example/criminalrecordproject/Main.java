package com.example.criminalrecordproject;

import com.example.criminalrecordproject.Model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main { // Main class
    public static void main(String[] args) {

        DirSetup.setupDirectory();

        ArrayList<Department> departments = new ArrayList<>();
        ArrayList<Officer> officers = new ArrayList<>();
        ArrayList<Criminal> criminals = new ArrayList<>();
        ArrayList<OfficerAuthentication> Authentication=new ArrayList<OfficerAuthentication>();
        Scanner input = new Scanner(System.in);

        // Read the existing data from the directories into the lists
        FileReader.readAll(departments, officers, criminals);
        Department.numofdepartments = departments.size();
        Criminal.numOfCriminals = criminals.size();
        Officer.officerNum = officers.size();


       // Pre-existing departments and cases (only if no existing data is found)
        if (departments.isEmpty()) {
            Department homicide = new Department("Homicide", "20/11/2024");
            departments.add(homicide);
            homicide.addCase(new Case("Murder investigation in downtown","20/12/2024","Murder",homicide,new Report("Murder investigation in downtown","John Doe , Jane Smith","None","\"Bloody knife, fingerprints\"")));

            Department cybercrime = new Department("Cybercrime", "21/11/2024");
            departments.add(cybercrime);
            cybercrime.addCase(new Case("Ransomware attack on a company","30/11/2024","Cybercrime",cybercrime,new Report("Ransomware attack on a company","John Doe , Jane Smith","Anonymous","Encrypted files, ransom note")));

            Department forensics = new Department("Forensics", "22/11/2024");
            departments.add(forensics);
            forensics.addCase(new Case("DNA matching for suspects","25/11/2024","Forensics",forensics,new Report("DNA matching for suspects","Detective X","Suspect Z","DNA samples, evidence logs")));

            Department terrorism = new Department("Terrorism", "23/11/2024");
            departments.add(terrorism);
            terrorism.addCase(new Case("Bomb threat in a subway","26/11/2024","Terrorism",terrorism,new Report("Bomb threat in a subway","Witness A, Witness B","Terrorist Group X","Explosives residue, CCTV footage")));

            Department robbery = new Department("Robbery", "24/11/2024");
            departments.add(robbery);
            robbery.addCase(new Case("Bank heist in downtown","27/11/2024","Robbery",robbery,new Report("Bank heist in downtown","Bank Manager, Security Guard","Masked Robbers","CCTV footage, dropped wallet")));
        }



        // Pre-existing Officers
        // Example: Initializing officers with assigned departments
        if (officers.isEmpty()) {
            Officer o1 = new Officer("Ali Ahmed", 27, 10000, "Ali_Officer1", "Ali1", "Homicide");
            officers.add(o1);
            Officer o2 = new Officer("Ahmed Mohamed", 38, 20000, "Ahmed_Officer2", "Ahmed2", "Cybercrime");
            officers.add(o2);
            Officer o3 = new Officer("Hassan Khalid", 30, 15000, "Hassan_Officer3", "Hassan3", "Terrorism");
            officers.add(o3);
            Officer o4 = new Officer("Omar Hassan", 45, 25000, "Omar_Officer4", "Omar4", "Forensics");
            officers.add(o4);
            Officer o5 = new Officer("Youssef Ehab", 33, 18000, "Youssef_Officer5", "Youssef5", "Robbery");
            officers.add(o5);
        }


        // Pre-existing Criminals
        if (criminals.isEmpty()) {

            // Initialize criminals and add crimes
            Criminal c1 = new Criminal("Mahmoud Mohamed", new Location("Cairo", "Nasr City", "Main Street", "Near Mall"));
            c1.getCrime().add("Robbery: Breaking and entering a warehouse");
            c1.updateDangerLevel(); // Manually update danger level
            criminals.add(c1);

            Criminal c2 = new Criminal("Ahmed Hussien", new Location("Giza", "Dokki", "Park Avenue", "Opposite Museum"));
            c2.getCrime().add("Homicide: Assault leading to death");
            c2.getCrime().add("Homicide: Suspicious death investigation in a park");
            c2.updateDangerLevel(); // Manually update danger level
            criminals.add(c2);

            // New criminals related to specific departments
            Criminal c3 = new Criminal("Hassan Omar", new Location("Alexandria", "Montaza", "Corniche Road", "Near Beach"));
            c3.getCrime().add("Homicide: Murder in downtown");
            c3.getCrime().add("Homicide: Suspicious death in a park");
            c3.updateDangerLevel(); // Manually update danger level
            criminals.add(c3);

            Criminal c4 = new Criminal("Fatima Khaled", new Location("Cairo", "Heliopolis", "Airport Road", "Near Mall"));
            c4.getCrime().add("Forensics: Tampering with evidence");
            c4.getCrime().add("Forensics: Forgery of documents");
            c4.updateDangerLevel(); // Manually update danger level
            criminals.add(c4);

            Criminal c5 = new Criminal("Amira Saeed", new Location("Cairo", "Shobra", "Industrial Zone", "Opposite Factory"));;
            c5.getCrime().add("Robbery: Jewelry store heist");
            c5.updateDangerLevel(); // Manually update danger level
            criminals.add(c5);

            Criminal c6 = new Criminal("Youssef Ali", new Location("Aswan", "City Center", "Market Street", "Near River"));
            c6.getCrime().add("Terrorism: Bomb threat in a subway");
            c6.getCrime().add("Terrorism: Investigation of a terror cell");
            c6.getCrime().add("Terrorism: Attempted sabotage of power plant");
            c6.updateDangerLevel(); // Manually update danger level
            criminals.add(c6);

            Criminal c7 = new Criminal("Omar Farouk", new Location("Cairo", "Nasr City", "Tech Park", "Next to IT Plaza"));
            c7.getCrime().add("Cybercrime: Ransomware attack on a company");
            c7.getCrime().add("Cybercrime: Phishing scam targeting seniors");
            c7.getCrime().add("Cybercrime: Data breach in a government system");
            c7.getCrime().add("Cybercrime: Unauthorized access to financial records");
            c7.getCrime().add("Cybercrime: Distributed denial-of-service attack");
            c7.updateDangerLevel(); // Manually update danger level
            criminals.add(c7);


        }


        // Welcome message
        System.out.println("\n\nWelcome to our criminal management system!");

        // Create user and call login
        user u = new user(departments, officers, criminals,Authentication);
        u.login();

        // Save all data before exiting
        FileSaver.saveAll(departments, officers, criminals);
    }
}
