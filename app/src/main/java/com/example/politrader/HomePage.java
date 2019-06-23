package com.example.politrader;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Button;
public class HomePage extends AppCompatActivity {
    User currentUser;
    TextView stock1name;
    TextView stock2name;
    TextView stock1price;
    TextView stock2price;
    TextView balance;
    Button buyMore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Intent intent = getIntent();
        this.currentUser = (User)intent.getSerializableExtra("User1");

        this.stock1price = (TextView) findViewById(R.id.stockprice);
        this.stock2price = (TextView) findViewById(R.id.Stock2Price);
        stock1price = (TextView) findViewById(R.id.stockprice);
        stock1name = (TextView) findViewById(R.id.stock1name);
        stock2name = (TextView) findViewById(R.id.stock2name);
        stock1name.setText(currentUser.getMyInvestments().get(0).getName());
        stock2name.setText(currentUser.getMyInvestments().get(1).getName());

        String stock1price = "$" + currentUser.getMyInvestments().get(0).getCurrentScore();
        this.balance = (TextView)findViewById(R.id.balance);

        this.stock1price.setText(currentUser.getMyInvestments().get(0).getCurrentScore());
        this.stock2price.setText(currentUser.getMyInvestments().get(1).getCurrentScore());

        this.balance.setText("" + currentUser.getCurrentBalance());


        this.buyMore = (Button)findViewById(R.id.buyMore);

        this.buyMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToBuyPage();
            }
        });

    }

    private void goToBuyPage() {

        Intent goTo = new Intent(HomePage.this, BuyPage.class);
        Intent intent = getIntent();
        Politician trump = (Politician) intent.getSerializableExtra("Donald Trump");
        Politician bernie = (Politician) intent.getSerializableExtra("Bernie Sanders");
        Politician hillary = (Politician) intent.getSerializableExtra("Hillary Clinton");
        Politician mike = (Politician) intent.getSerializableExtra("Mike Pence");
        Politician justin = (Politician) intent.getSerializableExtra("Justin Trudeau");

        goTo.putExtra("Donald Trump", trump);
        goTo.putExtra("Bernie Sanders", bernie);
        goTo.putExtra("Hillary Clinton", hillary);
        goTo.putExtra("Mike Pence", mike);
        goTo.putExtra("Justin Trudeau", justin);
        goTo.putExtra("currentUser", currentUser);
        startActivity(goTo);

    }
}
