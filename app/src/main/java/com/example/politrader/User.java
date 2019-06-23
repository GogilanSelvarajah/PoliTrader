package com.example.politrader;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private String email;
    private String password;
    private String username;
    double initialBalance = 100;
    double currentBalance;
    private ArrayList<Politician> myInvestments = new ArrayList<>();
    User() {

    }

    User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;

    }

    double getInitialBalance() {
        return this.initialBalance;
    }

    double getCurrentBalance() {
        return currentBalance;

    }

    ArrayList<Politician> getMyInvestments() {
        return this.myInvestments;
    }

    String getUsername() {
        return this.username;
    }

    String getEmail() {
        return this.email;
    }

    String getPassword() {
        return this.password;
    }

    void invest(Politician politician) {
        myInvestments.add(politician);
        currentBalance += Double.parseDouble(politician.getCurrentScore());
        initialBalance += Double.parseDouble(politician.getCurrentScore());
    }

    boolean isEmpty() {
        return this.email == null || this.password == null;
    }

}
