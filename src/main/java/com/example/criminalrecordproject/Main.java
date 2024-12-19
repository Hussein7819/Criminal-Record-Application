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
            // Create Officer and Criminal for this case
            Officer homicideOfficer = new Officer("Ali Ahmed", 27, 10000, "Ali_Officer1", "Ali1", "D0");
            Criminal homicideCriminal = new Criminal("Mahmoud Mohamed", new Location("Cairo", "Nasr City", "Main Street", "Near Mall"));
            homicideCriminal.getCrime().add("Robbery: Breaking and entering a warehouse");
            criminals.add(homicideCriminal);

            // Add case with officer and criminal
            Case homicideCase = new Case("Murder investigation in downtown", "20/12/2024", "Murder", homicide, new Report("Murder investigation in downtown","John Doe , Jane Smith","None","\"Bloody knife, fingerprints\""));
            homicideCase.addOfficer(homicideOfficer);
            homicideCase.addCriminal(homicideCriminal);
            homicide.addCase(homicideCase);

            Department cybercrime = new Department("Cybercrime", "21/11/2024");
            departments.add(cybercrime);
            // Create Officer and Criminal for this case
            Officer cybercrimeOfficer = new Officer("Hassan Khalid", 30, 15000, "Hassan_Officer3", "Hassan3", "D2");
            Criminal cybercrimeCriminal = new Criminal("Omar Farouk", new Location("Cairo", "Nasr City", "Tech Park", "Next to IT Plaza"));
            cybercrimeCriminal.getCrime().add("Cybercrime: Ransomware attack on a company");
            criminals.add(cybercrimeCriminal);

            // Add case with officer and criminal
            Case cybercrimeCase = new Case("Ransomware attack on a company", "30/11/2024", "Cybercrime", cybercrime, new Report("Ransomware attack on a company","John Doe , Jane Smith","Anonymous","Encrypted files, ransom note"));
            cybercrimeCase.addOfficer(cybercrimeOfficer);
            cybercrimeCase.addCriminal(cybercrimeCriminal);
            cybercrime.addCase(cybercrimeCase);

            Department forensics = new Department("Forensics", "22/11/2024");
            departments.add(forensics);
            // Create Officer and Criminal for this case
            Officer forensicsOfficer = new Officer("Youssef Ehab", 33, 18000, "Youssef_Officer5", "Youssef5", "D4");
            Criminal forensicsCriminal = new Criminal("Fatima Khaled", new Location("Cairo", "Heliopolis", "Airport Road", "Near Mall"));
            forensicsCriminal.getCrime().add("Forensics: Tampering with evidence");
            criminals.add(forensicsCriminal);

            // Add case with officer and criminal
            Case forensicsCase = new Case("DNA matching for suspects", "25/11/2024", "Forensics", forensics, new Report("DNA matching for suspects","Detective X","Suspect Z","DNA samples, evidence logs"));
            forensicsCase.addOfficer(forensicsOfficer);
            forensicsCase.addCriminal(forensicsCriminal);
            forensics.addCase(forensicsCase);

            Department terrorism = new Department("Terrorism", "23/11/2024");
            departments.add(terrorism);
            // Create Officer and Criminal for this case
            Officer terrorismOfficer = new Officer("Omar Hassan", 45, 25000, "Omar_Officer4", "Omar4", "D3");
            Criminal terrorismCriminal = new Criminal("Youssef Ali", new Location("Aswan", "City Center", "Market Street", "Near River"));
            terrorismCriminal.getCrime().add("Terrorism: Bomb threat in a subway");
            criminals.add(terrorismCriminal);

            // Add case with officer and criminal
            Case terrorismCase = new Case("Bomb threat in a subway", "26/11/2024", "Terrorism", terrorism, new Report("Bomb threat in a subway","Witness A, Witness B","Terrorist Group X","Explosives residue, CCTV footage"));
            terrorismCase.addOfficer(terrorismOfficer);
            terrorismCase.addCriminal(terrorismCriminal);
            terrorism.addCase(terrorismCase);

            Department robbery = new Department("Robbery", "24/11/2024");
            departments.add(robbery);
            // Create Officer and Criminal for this case
            Officer robberyOfficer = new Officer("Ahmed Mohamed", 38, 20000, "Ahmed_Officer2", "Ahmed2", "D1");
            Criminal robberyCriminal = new Criminal("Amira Saeed", new Location("Cairo", "Shobra", "Industrial Zone", "Opposite Factory"));
            robberyCriminal.getCrime().add("Robbery: Jewelry store heist");
            criminals.add(robberyCriminal);

            // Add case with officer and criminal
            Case robberyCase = new Case("Bank heist in downtown", "27/11/2024", "Robbery", robbery, new Report("Bank heist in downtown","Bank Manager, Security Guard","Masked Robbers","CCTV footage, dropped wallet"));
            robberyCase.addOfficer(robberyOfficer);
            robberyCase.addCriminal(robberyCriminal);
            robbery.addCase(robberyCase);
        }

// Pre-existing Officers
        if (officers.isEmpty()) {
            Officer o1 = new Officer("Ali Ahmed", 27, 10000, "Ali_Officer1", "Ali1", "D0");
            officers.add(o1);
            Officer o2 = new Officer("Ahmed Mohamed", 38, 20000, "Ahmed_Officer2", "Ahmed2", "D1");
            officers.add(o2);
            Officer o3 = new Officer("Hassan Khalid", 30, 15000, "Hassan_Officer3", "Hassan3", "D2");
            officers.add(o3);
            Officer o4 = new Officer("Omar Hassan", 45, 25000, "Omar_Officer4", "Omar4", "D3");
            officers.add(o4);
            Officer o5 = new Officer("Youssef Ehab", 33, 18000, "Youssef_Officer5", "Youssef5", "D4");
            officers.add(o5);
        }

// Pre-existing Criminals
        if (criminals.isEmpty()) {
            Criminal c1 = new Criminal("Mahmoud Mohamed", new Location("Cairo", "Nasr City", "Main Street", "Near Mall"));
            c1.getCrime().add("Robbery: Breaking and entering a warehouse");
            criminals.add(c1);

            Criminal c2 = new Criminal("Ahmed Hussien", new Location("Giza", "Dokki", "Park Avenue", "Opposite Museum"));
            c2.getCrime().add("Homicide: Assault leading to death");
            c2.getCrime().add("Homicide: Suspicious death investigation in a park");
            criminals.add(c2);

            Criminal c3 = new Criminal("Hassan Omar", new Location("Alexandria", "Montaza", "Corniche Road", "Near Beach"));
            c3.getCrime().add("Homicide: Murder in downtown");
            c3.getCrime().add("Homicide: Suspicious death in a park");
            criminals.add(c3);

            Criminal c4 = new Criminal("Fatima Khaled", new Location("Cairo", "Heliopolis", "Airport Road", "Near Mall"));
            c4.getCrime().add("Forensics: Tampering with evidence");
            c4.getCrime().add("Forensics: Forgery of documents");
            criminals.add(c4);

            Criminal c5 = new Criminal("Amira Saeed", new Location("Cairo", "Shobra", "Industrial Zone", "Opposite Factory"));
            c5.getCrime().add("Robbery: Jewelry store heist");
            criminals.add(c5);

            Criminal c6 = new Criminal("Youssef Ali", new Location("Aswan", "City Center", "Market Street", "Near River"));
            c6.getCrime().add("Terrorism: Bomb threat in a subway");
            c6.getCrime().add("Terrorism: Investigation of a terror cell");
            c6.getCrime().add("Terrorism: Attempted sabotage of power plant");
            criminals.add(c6);

            Criminal c7 = new Criminal("Omar Farouk", new Location("Cairo", "Nasr City", "Tech Park", "Next to IT Plaza"));
            c7.getCrime().add("Cybercrime: Ransomware attack on a company");
            c7.getCrime().add("Cybercrime: Phishing scam targeting seniors");
            c7.getCrime().add("Cybercrime: Data breach in a government system");
            c7.getCrime().add("Cybercrime: Unauthorized access to financial records");
            c7.getCrime().add("Cybercrime: Distributed denial-of-service attack");
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
