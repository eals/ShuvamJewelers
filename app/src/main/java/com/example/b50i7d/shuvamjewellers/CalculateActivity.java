package com.example.b50i7d.shuvamjewellers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by B50i7D on 9/11/2016.
 */
public class CalculateActivity extends AppCompatActivity {
    EditText weight,wastage,making,discount,rate;
    TextView total;
    Button calculate_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculate_activity);
        weight = (EditText) findViewById(R.id.cweight);
        wastage = (EditText) findViewById(R.id.cwastage);
        making = (EditText) findViewById(R.id.cmaking);
        discount = (EditText) findViewById(R.id.cdiscount);
        rate = (EditText) findViewById(R.id.crate);
        total = (TextView) findViewById(R.id.view_total);
        calculate_btn= (Button)findViewById(R.id.ctotal);
        calculate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String weights = weight.getText().toString();
                String wastges = wastage.getText().toString();
                String makings = making.getText().toString();
                String rates = rate.getText().toString();
                String discounts = discount.getText().toString();

                Float we= Float.parseFloat(weights);
                Float wa= Float.parseFloat(wastges);
                Float ma= Float.parseFloat(makings);
                Float ra= Float.parseFloat(rates);
                Float di= Float.parseFloat(discounts);
                Float totals=((we + wa)*ra)+ma-di;
                String final_total = totals.toString();
                total.setText(final_total);
            }
        });

    }
}
