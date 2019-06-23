package com.example.politrader;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import android.content.Intent;
public class MainActivity extends AppCompatActivity {
    ArrayList<Politician> politicians;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.politicians = loadPoliticians();
        this.login = (Button) findViewById(R.id.login);
        this.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLoginPage();

            }
        });
    }

    private User getUsers() {
        User u = new User("Kawhi Leonard","raptors@game6.ca","kawhi");

        u.invest(this.politicians.get(0));
        u.invest(this.politicians.get(1));
        return u;
    }


    private ArrayList<Politician> loadPoliticians() {
        ArrayList<Politician> politician = new ArrayList<>();
        ArrayList<String> bsScores = new ArrayList<>();
        bsScores.add("-109.68");
        bsScores.add("69.24");
        politician.add(new Politician("Bernie Sanders",bsScores));

        ArrayList<String> dtScores = new ArrayList<>();
        dtScores.add("85.86");
        dtScores.add("129.19");

        politician.add(new Politician("Donald Trump", dtScores));

        ArrayList<String> hcScores = new ArrayList<>();
        hcScores.add("45.88");
        hcScores.add("78.35");

        politician.add(new Politician("Hillary Clinton", hcScores));

        ArrayList<String> mpScores = new ArrayList<>();
        mpScores.add("-234");
        mpScores.add("6.58");
        politician.add(new Politician("Mike Pence", mpScores));

        ArrayList<String> jtScores = new ArrayList<>();
        jtScores.add("42.39");
        jtScores.add("115.1");

        politician.add(new Politician("Justin Trudeau", jtScores));

        return politician;

    }




    private void goToLoginPage()  {
        Intent login = new Intent(MainActivity.this, LoginPage.class);
//        HashMap<String, ArrayList<User>> context  = new HashMap<>();
//        context.put("Users", getUsers());
//        login.putExtra("Users", getUsers());
        login.putExtra("User1", getUsers());
        login.putExtra("Donald Trump", politicians.get(1));
        login.putExtra("Bernie Sanders", politicians.get(0));
        login.putExtra("Hillary Clinton", politicians.get(2));
        login.putExtra("Mike Pence", politicians.get(3));
        login.putExtra("Justin Trudeau", politicians.get(4));

        startActivity(login);
    }

}
