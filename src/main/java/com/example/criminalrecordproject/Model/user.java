package com.example.criminalrecordproject.Model;

import java.util.ArrayList;
import java.util.Scanner;

public class user {
    ArrayList<String>  Username=new ArrayList<>();
    ArrayList<String> Password=new ArrayList<>();
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
        System.out.println("login");
        Scanner sc=new Scanner(System.in);
        System.out.println("enter username:");
        username=sc.nextLine();
        System.out.println("enter password:");
        password=sc.nextLine();
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
