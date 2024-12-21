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

        //Local defined not related to files
       // ArrayList<Witness> witnesses_local= new ArrayList<>();

        // Pre-existing departments and cases (only if no existing data is found)
        if (departments.isEmpty()) {
            // Homicide Department
            Department homicide = new Department("Homicide", "20/11/2024");
            departments.add(homicide);

            Officer homicideOfficer = new Officer("Ali Ahmed", 27, 10000, "Ali_Officer1", "Ali1", "D0");
            officers.add(homicideOfficer);

            Criminal homicideCriminal = new Criminal("Mahmoud Mohamed", new Location("Cairo", "Nasr City", "Main Street", "Near Mall"));
            homicideCriminal.getCrime().add("Robbery: Breaking and entering a warehouse");
            criminals.add(homicideCriminal);

            Case homicideCase = new Case("Murder investigation in downtown", "20/12/2024", "Murder", homicide,
                    new Report("Murder investigation in downtown", new Witness("John Doe", "01131526985"), "None", "\"Bloody knife, fingerprints\""));
            homicideCase.addOfficer(homicideOfficer);
            homicideCase.addCriminal(homicideCriminal);
            homicide.addCase(homicideCase);

            // Cybercrime Department
            Department cybercrime = new Department("Cybercrime", "21/11/2024");
            departments.add(cybercrime);

            Officer cybercrimeOfficer = new Officer("Hassan Khalid", 30, 15000, "Hassan_Officer3", "Hassan3", "D2");
            officers.add(cybercrimeOfficer);

            Criminal cybercrimeCriminal = new Criminal("Omar Farouk", new Location("Cairo", "Nasr City", "Tech Park", "Next to IT Plaza"));
            cybercrimeCriminal.getCrime().add("Cybercrime: Ransomware attack on a company");
            criminals.add(cybercrimeCriminal);

            Case cybercrimeCase = new Case("Ransomware attack on a company", "30/11/2024", "Cybercrime", cybercrime,
                    new Report("Ransomware attack on a company", new Witness("Jane Smith","01112535654"), "Anonymous", "Encrypted files, ransom note"));
            cybercrimeCase.addOfficer(cybercrimeOfficer);
            cybercrimeCase.addCriminal(cybercrimeCriminal);
            cybercrime.addCase(cybercrimeCase);

            // Forensics Department
            Department forensics = new Department("Forensics", "22/11/2024");
            departments.add(forensics);

            Officer forensicsOfficer = new Officer("Youssef Ehab", 33, 18000, "Youssef_Officer5", "Youssef5", "D4");
            officers.add(forensicsOfficer);

            Criminal forensicsCriminal = new Criminal("Fatima Khaled", new Location("Cairo", "Heliopolis", "Airport Road", "Near Mall"));
            forensicsCriminal.getCrime().add("Forensics: Tampering with evidence");
            criminals.add(forensicsCriminal);

            Case forensicsCase = new Case("DNA matching for suspects", "25/11/2024", "Forensics", forensics,
                    new Report("DNA matching for suspects", new Witness("Detective X","01185426648"), "Suspect Z", "DNA samples, evidence logs"));
            forensicsCase.addOfficer(forensicsOfficer);
            forensicsCase.addCriminal(forensicsCriminal);
            forensics.addCase(forensicsCase);

            // Terrorism Department
            Department terrorism = new Department("Terrorism", "23/11/2024");
            departments.add(terrorism);

            Officer terrorismOfficer = new Officer("Omar Hassan", 45, 25000, "Omar_Officer4", "Omar4", "D3");
            officers.add(terrorismOfficer);

            Criminal terrorismCriminal = new Criminal("Youssef Ali", new Location("Aswan", "City Center", "Market Street", "Near River"));
            terrorismCriminal.getCrime().add("Terrorism: Bomb threat in a subway");
            criminals.add(terrorismCriminal);

            Case terrorismCase = new Case("Bomb threat in a subway", "26/11/2024", "Terrorism", terrorism,
                    new Report("Bomb threat in a subway", new Witness("Ali sayed","01115476459"), "Terrorist Group X", "Explosives residue, CCTV footage"));
            terrorismCase.addOfficer(terrorismOfficer);
            terrorismCase.addCriminal(terrorismCriminal);
            terrorism.addCase(terrorismCase);

            // Robbery Department
            Department robbery = new Department("Robbery", "24/11/2024");
            departments.add(robbery);

            Officer robberyOfficer = new Officer("Ahmed Mohamed", 38, 20000, "Ahmed_Officer2", "Ahmed2", "D1");
            officers.add(robberyOfficer);

            Criminal robberyCriminal = new Criminal("Amira Saeed", new Location("Cairo", "Shobra", "Industrial Zone", "Opposite Factory"));
            robberyCriminal.getCrime().add("Robbery: Jewelry store heist");
            criminals.add(robberyCriminal);

            Case robberyCase = new Case("Bank heist in downtown", "27/11/2024", "Robbery", robbery,
                    new Report("Bank heist in downtown", new Witness("Security Guard", "01115426455"), "Masked Robbers", "CCTV footage, dropped wallet"));
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
        /* {
           Criminal c1 = new Criminal("Mahmoud Mohamed", new Location("Cairo", "Nasr City", "Main Street", "Near Mall"));
            c1.getCrime().add("Robbery: Breaking and entering a warehouse");
            criminals.add(c1);
            c1.updateDangerLevel();

            Criminal c2 = new Criminal("Ahmed Hussien", new Location("Giza", "Dokki", "Park Avenue", "Opposite Museum"));
            c2.getCrime().add("Homicide: Assault leading to death");
            c2.getCrime().add("Homicide: Suspicious death investigation in a park");
            criminals.add(c2);
            c2.updateDangerLevel();

            Criminal c3 = new Criminal("Hassan Omar", new Location("Alexandria", "Montaza", "Corniche Road", "Near Beach"));
            c3.getCrime().add("Homicide: Murder in downtown");
            c3.getCrime().add("Homicide: Suspicious death in a park");
            criminals.add(c3);
            c3.updateDangerLevel();

            Criminal c4 = new Criminal("Fatima Khaled", new Location("Cairo", "Heliopolis", "Airport Road", "Near Mall"));
            c4.getCrime().add("Forensics: Tampering with evidence");
            c4.getCrime().add("Forensics: Forgery of documents");
            criminals.add(c4);
            c4.updateDangerLevel();

            Criminal c5 = new Criminal("Amira Saeed", new Location("Cairo", "Shobra", "Industrial Zone", "Opposite Factory"));
            c5.getCrime().add("Robbery: Jewelry store heist");
            criminals.add(c5);
            c5.updateDangerLevel();

            Criminal c6 = new Criminal("Youssef Ali", new Location("Aswan", "City Center", "Market Street", "Near River"));
            c6.getCrime().add("Terrorism: Bomb threat in a subway");
            c6.getCrime().add("Terrorism: Investigation of a terror cell");
            c6.getCrime().add("Terrorism: Attempted sabotage of power plant");
            criminals.add(c6);
            c6.updateDangerLevel();

            Criminal c7 = new Criminal("Omar Farouk", new Location("Cairo", "Nasr City", "Tech Park", "Next to IT Plaza"));
            c7.getCrime().add("Cybercrime: Ransomware attack on a company");
            c7.getCrime().add("Cybercrime: Phishing scam targeting seniors");
            c7.getCrime().add("Cybercrime: Data breach in a government system");
            c7.getCrime().add("Cybercrime: Unauthorized access to financial records");
            c7.getCrime().add("Cybercrime: Distributed denial-of-service attack");
            criminals.add(c7);
            c7.updateDangerLevel();
        }*/


        // Welcome message
        System.out.println("\n\nWelcome to our criminal management system!");

        // Create user and call login
        user u = new user(departments, officers, criminals,Authentication);
        u.login();

        // Save all data before exiting
        FileSaver.saveAll(departments, officers, criminals);

    }
}
