package com.example.b50i7d.shuvamjewellers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        RecyclerView recyle = (RecyclerView)findViewById(R.id.my_recycler_view);
        recyle.setHasFixedSize(true);

        LinearLayoutManager layoutmang = new LinearLayoutManager(getBaseContext());
        recyle.setLayoutManager(layoutmang);

        Dbhelper dbhelper;

        dbhelper = new Dbhelper(MainActivity.this);

        final ArrayList<UserInfo> list = dbhelper.getUserList();

        CardAdapter cd = new CardAdapter(MainActivity.this);
        recyle.setAdapter(cd);
        ItemClickSupport.addTo(recyle).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                final UserInfo info = list.get(position);
                Intent intent = new Intent(MainActivity.this, FinalBillActivity.class);
                intent.putExtra("names",info.name);
                intent.putExtra("no",info.no);
                intent.putExtra("pan_no",info.pan_no);
                intent.putExtra("date",info.date);
                intent.putExtra("order_date",info.order_date);
                intent.putExtra("particular",info.particular);
                intent.putExtra("weight",info.weight);
                intent.putExtra("wastage",info.westage);
                intent.putExtra("making",info.making);
                intent.putExtra("rate",info.rate);
                intent.putExtra("discounts",info.discount);
                intent.putExtra("total",info.total);
                Toast.makeText(MainActivity.this,info.discount,Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }
    public void show_rates(){
        Intent intent = new Intent(MainActivity.this,RatesActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public void onBackPressed(){
        Intent intent = new Intent(MainActivity.this,FirstActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
