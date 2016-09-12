package com.example.b50i7d.shuvamjewellers;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Date;

/**
 * Created by B50i7D on 9/10/2016.
 */
public class RatesActivity extends AppCompatActivity {
    TextView date;
    TextView gold,silver;
    public static final String gold_value = "gold_value";
    public static final String silver_value = "silver_value";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rates_activity);
        date = (TextView) findViewById(R.id.date_for_rate);
        gold = (TextView) findViewById(R.id.rate);
        silver = (TextView) findViewById(R.id.rate2);
        Date d = new Date();
        CharSequence s = DateFormat.format("yyyy-MM-dd", d.getTime());
        date.setText(s);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        final SharedPreferences.Editor editor = pref.edit();

        Firebase.setAndroidContext(this);
        Firebase mRef = new Firebase("https://shuvamjewelery.firebaseio.com/");
        Firebase messagesRef11 = mRef.child("gold");
        messagesRef11.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                editor.putString("gold_value",value);
                gold.setText(value);
                editor.commit();
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
        String imgSett = pref.getString(gold_value, "");

        gold.setText(imgSett);

        Firebase messagesRef2 = mRef.child("silver");
        messagesRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                editor.putString("silver_value",value);
                silver.setText(value);
                editor.commit();
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
        String imgSett2 = pref.getString(silver_value, "");
        silver.setText(imgSett2);
    }
}
