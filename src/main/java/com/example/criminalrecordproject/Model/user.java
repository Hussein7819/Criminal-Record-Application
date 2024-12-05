package com.example.criminalrecordproject.Model;

import java.util.ArrayList;
import java.util.Scanner;

public class user {
    protected ArrayList<String> Username;
    protected ArrayList<String> Password;
    public user(ArrayList<String> Username, ArrayList<String> Password) {
        this.Username = Username;
        this.Password = Password;
    }
   protected void addacounts(String username,String password){
        System.out.println("add account");
        Scanner sc=new Scanner(System.in);
        System.out.println("enter username:");
        username=sc.nextLine();
        this.Username.add(username);
        System.out.println("enter password:");
        password=sc.nextLine();
        this.Password.add(password);
        System.out.println("Created an account successfully!");
    }
    protected void login(String username,String password){
        String Admin_username="admin";
        String Admin_password="admin";
        System.out.println("login");
        Scanner sc=new Scanner(System.in);
        System.out.println("enter username:");
        username=sc.nextLine();
        System.out.println("enter password:");
        password=sc.nextLine();
        if (username.equals(Admin_username) && password.equals(Admin_password)){
            System.out.println("Login successfully!");
        }
        for(int i=0;i<Username.size();i++){
            if(username.equals(Username.get(i))&&password.equals(Password.get(i))){
                System.out.println("login successfully");
            }
            else{
                System.out.println("login failed");
            }
        }
    }
    protected void logout(String password){
        System.out.println("logout");
        Scanner sc=new Scanner(System.in);
        System.out.println("enter password:");
        password=sc.nextLine();
        for(int i=0;i<Password.size();i++){
            if(password.equals(Password.get(i))){
                System.out.println("logout successfully");
            }
            else{
                System.out.println("logout failed");
            }
        }
    }
}
