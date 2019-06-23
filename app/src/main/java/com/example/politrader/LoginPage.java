package com.example.politrader;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import java.util.ArrayList;
import java.util.HashMap;

public class LoginPage extends AppCompatActivity {
    Button login;
    TextView errormessage;
    ArrayList<User> users = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        this.login = (Button) findViewById(R.id.login);
        final Intent intent = getIntent();
        User user1 = (User) intent.getSerializableExtra("User1");

        users.add(user1);

        this.errormessage = (TextView) findViewById(R.id.errormessage);
        this.login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Politician trump = (Politician) intent.getSerializableExtra("Donald Trump");
                Politician bernie = (Politician) intent.getSerializableExtra("Bernie Sanders");
                Politician hillary = (Politician) intent.getSerializableExtra("Hillary Clinton");
                Politician mike = (Politician) intent.getSerializableExtra("Mike Pence");
                Politician justin = (Politician) intent.getSerializableExtra("Justin Trudeau");

                String email = ((TextView)(findViewById(R.id.email))).getText().toString();
                String password = ((TextView)findViewById(R.id.password)).getText().toString();

                if (!findUser(email, password).isEmpty()) {
                    Intent goToHome = new Intent(LoginPage.this, HomePage.class);
                    goToHome.putExtra("User1", findUser(email, password));
                    goToHome.putExtra("Donald Trump", trump);
                    goToHome.putExtra("Bernie Sanders", bernie);
                    goToHome.putExtra("Hillary Clinton", hillary);
                    goToHome.putExtra("Mike Pence", mike);
                    goToHome.putExtra("Justin Trudeau", justin);
                    startActivity(goToHome);
                }

                else {
                    errormessage.setText("Invalid Credentials.");
                }
            }
        });
    }

    private boolean validCredentials(String email, String password) {
        for (int x = 0; x<users.size(); x++) {
            if (users.get(x).getEmail().equals(email) && users.get(x).getPassword().equals(password)){
                return true;
            }
        }

        return false;



    }

    private User findUser(String email, String password) {
        for (int x=0; x<users.size(); x++) {
            if (users.get(x).getEmail().equals(email) && users.get(x).getPassword().equals(password)) {
                return users.get(x);
            }
        }

        return new User();
    }

}
