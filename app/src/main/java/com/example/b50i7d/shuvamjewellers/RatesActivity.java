package com.example.b50i7d.shuvamjewellers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.widget.TextView;

import java.util.Date;

/**
 * Created by B50i7D on 9/10/2016.
 */
public class RatesActivity extends AppCompatActivity {
    TextView date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rates_activity);
        date = (TextView) findViewById(R.id.date_for_rate);
        Date d = new Date();
        CharSequence s = DateFormat.format("yyyy-MM-dd", d.getTime());
        date.setText(s);
    }
}
