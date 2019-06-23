package com.example.politrader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BuyPage extends AppCompatActivity {
    Button buyStock;
    TextView trumpPrice;
    TextView pencePrice;
    TextView hillaryPrice;
    TextView jtPrice;
    TextView purchaseMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_page);
        Intent intent = getIntent();
        trumpPrice = (TextView) findViewById(R.id.dtPrice);
        pencePrice = (TextView) findViewById(R.id.pencePrice);
        hillaryPrice = (TextView) findViewById(R.id.hillaryprice);
        jtPrice = (TextView) findViewById(R.id.jtPrice);
        this.purchaseMessage = (TextView) findViewById(R.id.purchaseMessage);
        Politician trump = (Politician) intent.getSerializableExtra("Donald Trump");
        Politician bernie = (Politician) intent.getSerializableExtra("Bernie Sanders");
        Politician hillary = (Politician) intent.getSerializableExtra("Hillary Clinton");
        Politician mike = (Politician) intent.getSerializableExtra("Mike Pence");
        Politician justin = (Politician) intent.getSerializableExtra("Justin Trudeau");
        trumpPrice.setText("$" + trump.getCurrentScore() + " (" + trump.getChange()+ ")");
        hillaryPrice.setText("$" + hillary.getCurrentScore() + " (" + hillary.getChange()+ ")");
        pencePrice.setText("$" + mike.getCurrentScore() + " (" + mike.getChange()+ ")");
        jtPrice.setText("$" + justin.getCurrentScore() + " (" + justin.getChange()+ ")");
        this.buyStock = (Button) findViewById(R.id.buyStock);

        this.buyStock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                Politician trump = (Politician) intent.getSerializableExtra("Donald Trump");
                Politician bernie = (Politician) intent.getSerializableExtra("Bernie Sanders");
                Politician hillary = (Politician) intent.getSerializableExtra("Hillary Clinton");
                Politician mike = (Politician) intent.getSerializableExtra("Mike Pence");
                Politician justin = (Politician) intent.getSerializableExtra("Justin Trudeau");
                User currentUser = (User) intent.getSerializableExtra("currentUser");
                String stockName = ((TextView) findViewById(R.id.stockName)).getText().toString().trim();

                if (stockName.equals("Donald Trump")) {
                    currentUser.invest(trump);
                    purchaseMessage.setText("Purchased Donald Trump..");

                }

                else if(stockName.equals("Bernie Sanders")) {
                    currentUser.invest(bernie);
                    purchaseMessage.setText("Puchased Bernie Sanders.");


                }

                else if(stockName.equals("Hillary Clinton")) {
                    currentUser.invest(hillary);
                    purchaseMessage.setText("Purchased Hillary Clinton.");


                }

                else if(stockName.equals("Mike Pence")) {
                    currentUser.invest(mike);
                    purchaseMessage.setText("Purchased Mike Pence.");


                }

                else if(stockName.equals("Justin Trudeau")) {
                    currentUser.invest(justin);
                    purchaseMessage.setText("Purchased Justin Trudeau.");


                } else {
                    purchaseMessage.setText("Stock does not exist.");

                }


            }
        });

        Button backtoDashboard =(Button)findViewById(R.id.backDashboard);

        backtoDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                Politician trump = (Politician) intent.getSerializableExtra("Donald Trump");
                Politician bernie = (Politician) intent.getSerializableExtra("Bernie Sanders");
                Politician hillary = (Politician) intent.getSerializableExtra("Hillary Clinton");
                Politician mike = (Politician) intent.getSerializableExtra("Mike Pence");
                Politician justin = (Politician) intent.getSerializableExtra("Justin Trudeau");
                User currentUser = (User) intent.getSerializableExtra("currentUser");
                Intent goToHome = new Intent(BuyPage.this, HomePage.class);
                goToHome.putExtra("Donald Trump", trump);
                goToHome.putExtra("Bernie Sanders", bernie);
                goToHome.putExtra("Hillary Clinton", hillary);
                goToHome.putExtra("Mike Pence", mike);
                goToHome.putExtra("Justin Trudeau", justin);
                goToHome.putExtra("User1",currentUser);
                startActivity(goToHome);
            }
        });






    }
}
