package com.example.b50i7d.shuvamjewellers;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

/**
 * Created by B50i7D on 9/1/2016.
 */
public class Main_activity extends AppCompatActivity {
    TextView txt_title;
    Button total_btn;
    Dbhelper dbhelper;
    EditText name,address,date,order_date,pan_no,no,weight,wastage,rate,making,particular,discount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.name);
        address = (EditText) findViewById(R.id.address);
        date = (EditText) findViewById(R.id.date);
        order_date = (EditText) findViewById(R.id.order_date);
        pan_no = (EditText) findViewById(R.id.pan_no);
        no = (EditText) findViewById(R.id.no);
        particular = (EditText) findViewById(R.id.particular);
        weight = (EditText) findViewById(R.id.weight);
        wastage = (EditText) findViewById(R.id.wastage);
        making = (EditText) findViewById(R.id.making);
        rate = (EditText) findViewById(R.id.rate);
        discount = (EditText) findViewById(R.id.discount);
        total_btn = (Button) findViewById(R.id.total_btn);
        Date d = new Date();
        CharSequence s = DateFormat.format("yyyy-MM-dd", d.getTime());
        date.setHint(s);
        date.setText(s);
        total_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passing_onclick();
            }
        });
    }
    public void passing_onclick(){
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putInt("id", 0);

        int id = pref.getInt("id",0);
        id= id + 1;

        boolean validation = true;
        String names = name.getText().toString();
        String addresss = address.getText().toString();
        String dates = date.getText().toString();
        String order_dates = order_date.getText().toString();
        String pan_nos = pan_no.getText().toString();
        String nos = no.getText().toString();
        String particulars = particular.getText().toString();
        String weights = weight.getText().toString();
        String wastges = wastage.getText().toString();
        String makings = making.getText().toString();
        String rates = rate.getText().toString();
        String discounts = discount.getText().toString();

        if(names.length() <= 10){
            name.setError("enter your full name");
            validation = false;
        }

        if(addresss.length() == 0){
            address.setError("enter your valid address");
            validation = false;
        }

        if(dates.length() == 0){
            date.setError("enter valid date");
            validation = false;
        }

        if(order_dates.length() == 0){
            order_date.setError("enter valid date");
            validation = false;
        }

        if(pan_nos.length()!= 10){
            pan_no.setError("pan no should be of length 10");
            validation = false;
        }

        if(nos.length() == 0){
            no.setError("enter valid no");
            validation = false;
        }

        if(particulars.length() == 0){
            particular.setError("enter particular");
            validation = false;
        }

        if(weights.length() == 0){
            weight.setError("enter weight");
            validation = false;
        }

        if(wastges.length() == 0){
            wastage.setError("enter wastge");
            validation = false;
        }

        if(makings.length() == 0){
            making.setError("enter ur making");
            validation = false;
        }

        if(rates.length() == 0){
            rate.setError("enter ur rate");
            validation = false;
        }
        if(discounts.length() == 0){
            rate.setError("enter discounts");
            validation = false;
        }
        if(validation){
            Float we= Float.parseFloat(weights);
            Float wa= Float.parseFloat(wastges);
            Float ma= Float.parseFloat(makings);
            Float ra= Float.parseFloat(rates);
            Float di= Float.parseFloat(discounts);
            Float total=((we + wa)*ra)+ma-di;
            String final_total = total.toString();
            Intent intent = new Intent(Main_activity.this,Total_activity.class);
            intent.putExtra("names",names);
            intent.putExtra("address",addresss);
            intent.putExtra("dates",dates);
            intent.putExtra("order_dates",order_dates);
            intent.putExtra("pan_nos",pan_nos);
            intent.putExtra("nos",nos);
            intent.putExtra("particulars",particulars);
            intent.putExtra("weights",weights);
            intent.putExtra("wastages",wastges);
            intent.putExtra("makings",makings);
            intent.putExtra("rates",rates);
            intent.putExtra("totals",final_total);
            intent.putExtra("discounts",discounts);
            intent.putExtra("id",id);
            editor.putInt("id",id);
            Toast.makeText(this,final_total,Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }

    }
}