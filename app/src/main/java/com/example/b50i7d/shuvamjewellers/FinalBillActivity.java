package com.example.b50i7d.shuvamjewellers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by B50i7D on 9/3/2016.
 */
public class FinalBillActivity extends AppCompatActivity {
    TextView pan_no,name,no,date,order_date,particular,weight,wastage,making,rate,total,discount,signature;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_bill_layout);
        pan_no =(TextView) findViewById(R.id.pan_no_no);
        name =(TextView) findViewById(R.id.mr_name);
        no =(TextView) findViewById(R.id.no_no);
        date =(TextView) findViewById(R.id.indate);
        order_date =(TextView) findViewById(R.id.inorder_date);
        particular =(TextView) findViewById(R.id.inparticular);
        weight =(TextView) findViewById(R.id.inweight);
        wastage =(TextView) findViewById(R.id.inwastage);
        making =(TextView) findViewById(R.id.inmaking);
        rate =(TextView) findViewById(R.id.inrate);
        total =(TextView) findViewById(R.id.intotal);
        discount = (TextView) findViewById(R.id.indiscount);
        signature = (TextView) findViewById(R.id.name_section);



        no.setText(getIntent().getStringExtra("no"));
        name.setText(getIntent().getStringExtra("names"));
        pan_no.setText(getIntent().getStringExtra("pan_no"));
        date.setText(getIntent().getStringExtra("date"));
        order_date.setText(getIntent().getStringExtra("order_date"));
        particular.setText(getIntent().getStringExtra("particular"));
        weight.setText(getIntent().getStringExtra("weight"));
        wastage.setText(getIntent().getStringExtra("wastage"));
        making.setText(getIntent().getStringExtra("making"));
        rate.setText(getIntent().getStringExtra("rate"));
        discount.setText(getIntent().getStringExtra("discounts"));
        total.setText(getIntent().getStringExtra("total"));
        no.setText(getIntent().getStringExtra("no"));
        signature.setText(getIntent().getStringExtra("names"));


    }
    public void onBackPressed(){
        Intent intent = new Intent(FinalBillActivity.this,MainActivity.class);
        startActivity(intent);
    }
}
