package com.example.b50i7d.shuvamjewellers;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

/**
 * Created by B50i7D on 9/11/2016.
 */
public class FirstActivity extends AppCompatActivity {
    CardView making_bill,calculate,profiles,rates;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        making_bill =(CardView) findViewById(R.id.making_bill);
        calculate = (CardView)findViewById(R.id.calculate);
        profiles =(CardView) findViewById(R.id.profiles);
        rates = (CardView) findViewById(R.id.rates);

        making_bill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this,Main_activity.class);
                startActivity(intent);
            }
        });
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this,CalculateActivity.class);
                startActivity(intent);
            }
        });
        profiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        rates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this,RatesActivity.class);
                startActivity(intent);
            }
        });

    }
    public void onBackPressed(){
        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Exit")
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setNegativeButton("No", null).show();
    }
}
