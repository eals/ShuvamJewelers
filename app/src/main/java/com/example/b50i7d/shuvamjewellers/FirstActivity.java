package com.example.b50i7d.shuvamjewellers;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

/**
 * Created by B50i7D on 9/11/2016.
 */
public class FirstActivity extends AppCompatActivity {
    CardView making_bill, calculate, profiles, rates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        making_bill = (CardView) findViewById(R.id.making_bill);
        calculate = (CardView) findViewById(R.id.calculate);
        profiles = (CardView) findViewById(R.id.profiles);
        rates = (CardView) findViewById(R.id.rates);

        making_bill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, Main_activity.class);
                startActivity(intent);
            }
        });
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, CalculateActivity.class);
                startActivity(intent);
            }
        });
        profiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        rates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, RatesActivity.class);
                startActivity(intent);
            }
        });

    }

    private Boolean exit = false;

    public void onBackPressed() {
        if (exit) {
            finish(); // finish activity
        } else {
            Toast.makeText(this, "Press Back again to Exit.",
                    Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    moveTaskToBack(true);
                    Intent a = new Intent(Intent.ACTION_MAIN);
                    a.addCategory(Intent.CATEGORY_HOME);
                    a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(a);
                }
            }, 1000);

        }
    }
}
