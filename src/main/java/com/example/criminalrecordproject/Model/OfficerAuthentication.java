package com.example.criminalrecordproject.Model;

import java.util.ArrayList;
import java.util.List;
public class OfficerAuthentication {
    protected ArrayList<String> officers_ID;
    protected String Case_ID;
    public OfficerAuthentication(String Case_ID, String officers_ID) {
        this.Case_ID = Case_ID;
        this.officers_ID = new ArrayList<>();
    }
    public String getCase_ID() {
            return Case_ID;
    }
    public void setCase_ID(String case_ID) {
        Case_ID = case_ID;
    }
    public ArrayList<String> getOfficers_ID() {
        return officers_ID;
    }
    public void setOfficers_ID(ArrayList<String> officers_ID) {
        this.officers_ID = officers_ID;
    }
}
