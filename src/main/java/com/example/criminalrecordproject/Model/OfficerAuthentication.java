package com.example.criminalrecordproject.Model;

import java.util.List;
public class OfficerAuthentication {
    public String username;
    private String password;

    public OfficerAuthentication(String username, String password){
        this.username = username;
        this.password=password;
    }
    // Method to authenticate officer
    public boolean Authentication(String enteredUsername, String enteredPassword) {
        return  this.username.equals(enteredUsername)&& this.password.equals(enteredPassword);
    }

    // Method to check case access
    public boolean checkCaseAccess(int officerId, List<Integer> caseOfficers){
        return caseOfficers.contains(officerId);
    }
    @Override
    public String toString(){
        return "OfficerAuthentication{"+"username = "+ username + '\'' + '}';
    }
}
