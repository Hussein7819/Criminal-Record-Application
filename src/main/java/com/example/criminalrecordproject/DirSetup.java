package com.example.criminalrecordproject;
import java.io.File;

public class DirSetup {

        static final String DIRECTORY = "Database/";

        static String Officers = DIRECTORY + "Officers/";
        static String Departments = DIRECTORY + "Departments/";
        static String Cases = DIRECTORY + "Cases/";
        static String Criminals = DIRECTORY + "Criminals/";
        static String OfficerAuthentication = DIRECTORY + "OffAuth/";

        public static void setupDirectory() {
            Create_folder(DIRECTORY);

            Create_folder(Officers);
            Create_folder(Departments);
            Create_folder(Cases);
            Create_folder(Criminals);
            Create_folder(OfficerAuthentication);
            System.out.println("Directories setup completed.");
        }

        private static void Create_folder(String DIRECTORY) {
            File dir = new File(DIRECTORY);
            if (!dir.exists()) {
                dir.mkdirs();
                System.out.println("Created directory: " + DIRECTORY);
            }
        }
    }
