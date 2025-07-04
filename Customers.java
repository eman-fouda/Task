package org.example;

import sun.security.util.Password;

import javax.naming.Name;

public class Customers {
    public String Name;
    private double Balance;
    static private int id = 0;
    private int Password;

    public Customers(String name){
        Name =name;
        Balance = 0.0;
        id=+1;
        Password = id+1000;
    }

    public void SetBalance(double balance){
        Balance = balance;
    }
    public double GetBalance(){return Balance;}
}

