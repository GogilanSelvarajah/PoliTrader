package com.example.politrader;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
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
        DatabaseAccess db = DatabaseAccess.getInstance(getApplicationContext());
        db.open();
        politician.add(new Politician("Donald Trump", db.getSentiments("donaldtrumptweetsentiment")));
        politician.add(new Politician("Bernie Sanders", db.getSentiments("berniesanderstweetsentiment")));
        politician.add(new Politician("Hillary Clinton", db.getSentiments("hillaryclintontweetsentiment")));
        politician.add(new Politician("Mike Pence", db.getSentiments("mikepencetweetsentiment")));
        politician.add(new Politician("Justin Trudeau", db.getSentiments("justintrudeautweetsentiment")));
        db.close();
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
