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
           // homicide.addCase(new Report(1001, "Murder investigation in downtown", "John Doe, Jane Smith", "Unknown", "Bloody knife, fingerprints", "homicide"));
           // homicide.addCase(new Report(1002, "Suspicious death in a park", "Park Goer", "Unknown", "DNA samples, footprints", "homicide"));
              homicide.addCase(new Case("Murder investigation in downtown","20/12/2024","Murder",homicide,new Report("Murder investigation in downtown","John Doe , Jane Smith","None","\"Bloody knife, fingerprints\"")));


            Department cybercrime = new Department("Cybercrime", "21/11/2024");
            departments.add(cybercrime);
           // cybercrime.addCase(new Report(2001, "Ransomware attack on a company", "Company IT Staff", "Hacker Group", "Encrypted files, ransom note", "cybercrime"));
           // cybercrime.addCase(new Report(2002, "Phishing scam targeting seniors", "Victims A, B, C", "Scammer X", "Email logs, IP addresses", "cybercrime"));
            homicide.addCase(new Case("Ransomware attack on a company","30/11/2024","Cybercrime",cybercrime,new Report("Ransomware attack on a company","John Doe , Jane Smith","Anonymous","Encrypted files, ransom note")));

            Department forensics = new Department("Forensics", "22/11/2024");
            departments.add(forensics);
            // forensics.addCase(new Report(3001, "Analysis of blood samples", "Witness D", "Unknown", "Blood samples, fibers"," forensics"));
            // forensics.addCase(new Report(3002, "DNA matching for suspects", "Detective X", "Suspect Z", "DNA samples, evidence logs"," forensics"));

            Department terrorism = new Department("Terrorism", "23/11/2024");
            departments.add(terrorism);
           // terrorism.addCase(new Report(4001, "Bomb threat in a subway", "Witness A, Witness B", "Terrorist Group X", "Explosives residue, CCTV footage", "terrorism"));
           // terrorism.addCase(new Report(4002, "Investigation of a terror cell", "Informant", "Suspect Y", "Communications, funding trail"," terrorism"));

            Department robbery = new Department("Robbery", "24/11/2024");
            departments.add(robbery);
           // robbery.addCase(new Report(5001, "Bank heist in downtown", "Bank Manager, Security Guard", "Masked Robbers", "CCTV footage, dropped wallet"," robbery"));
           // robbery.addCase(new Report(5002, "Jewelry store theft", "Store Owner", "Two individuals", "Gloves, broken glass"," robbery"));
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

            // Initialize criminals and add crimes
            Criminal c1 = new Criminal("Mahmoud Mohamed", new Location("Cairo", "Nasr City", "Main Street", "Near Mall"));
            c1.getCrime().add("Robbery: Jewelry store heist");
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

            Criminal c5 = new Criminal("Youssef Ali", new Location("Cairo", "Shobra", "Industrial Zone", "Opposite Factory"));
            c5.getCrime().add("Robbery: Armed bank robbery");
            c5.getCrime().add("Robbery: Jewelry store heist");
            c5.updateDangerLevel(); // Manually update danger level
            criminals.add(c5);

            Criminal c6 = new Criminal("Amira Saeed", new Location("Aswan", "City Center", "Market Street", "Near River"));
            c6.getCrime().add("Terrorism: Bomb threat in a subway");
            c6.getCrime().add("Terrorism: Investigation of a terror cell");
            c6.getCrime().add("Terrorism: Attempted sabotage of power plant");
            c6.updateDangerLevel(); // Manually update danger level
            criminals.add(c6);
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
