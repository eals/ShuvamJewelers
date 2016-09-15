package com.example.b50i7d.shuvamjewellers;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.widget.TextView;

/**
 * Created by B50i7D on 9/3/2016.
 */
public class FinalBillActivity extends AppCompatActivity {
    TextView pan_no,name,no,date,order_date,particular,weight,wastage,making,rate,total,discount,signature,bought_price_value,Todays_price_value;
    public static final String gold_value = "gold_value";
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_bill_layout);
        pan_no =(TextView) findViewById(R.id.pan_no_no);
        name =(TextView) findViewById(R.id.mr_name);
        no =(TextView) findViewById(R.id.no_no);
        date =(TextView) findViewById(R.id.indate);
        Todays_price_value = (TextView) findViewById(R.id.Todays_price_value);
        order_date =(TextView) findViewById(R.id.inorder_date);
        particular =(TextView) findViewById(R.id.inparticular);
        weight =(TextView) findViewById(R.id.inweight);
        wastage =(TextView) findViewById(R.id.inwastage);
        making =(TextView) findViewById(R.id.inmaking);
        rate =(TextView) findViewById(R.id.inrate);
        total =(TextView) findViewById(R.id.intotal);
        discount = (TextView) findViewById(R.id.indiscount);
        signature = (TextView) findViewById(R.id.name_section);
        bought_price_value = (TextView) findViewById(R.id.bought_price_value);



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
        bought_price_value.setText(getIntent().getStringExtra("total"));
        String da = date.getText().toString();
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        String ratess = pref.getString(gold_value, "");
        String weights = weight.getText().toString();
        String wastges = wastage.getText().toString();
        String makings = making.getText().toString();
        String totals = total.getText().toString();
        String discounts = discount.getText().toString();
        Float we= Float.parseFloat(weights);
        Float wa= Float.parseFloat(wastges);
        Float ma= Float.parseFloat(makings);
        Float ra= Float.parseFloat(ratess);
        Float di= Float.parseFloat(discounts);
        Float total1 = Float.parseFloat(totals);
        Float total=((we + wa)*ra)+ma-di;
        Float final_total = total - total1;
        String final_total1 = final_total.toString();
        Todays_price_value.setText(final_total1);
        if(total>total1){
            Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder mBuilder =
                    (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                            .setSmallIcon(R.drawable.gold_icon)
                            .setContentTitle("Shuvam jewelers")
                            .setContentText("the rate of the jeweler you bought in " + da+" \n has increased from" + total1 +" to "+ total)
                            .setSound(alarmSound)
                            .setStyle(new NotificationCompat.BigTextStyle()
                                    .bigText("the rate of the jeweler you bought in " + da+" \n has increased from" + total1 +" to "+ total));

// Creates an explicit intent for an Activity in your app
            Intent resultIntent = new Intent(this, MainActivity.class);

// The stack builder object will contain an artificial back stack for the
// started Activity.
// This ensures that navigating backward from the Activity leads out of
// your application to the Home screen.
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
// Adds the back stack for the Intent (but not the Intent itself)
            stackBuilder.addParentStack(FirstActivity.class);
// Adds the Intent that starts the Activity to the top of the stack
            stackBuilder.addNextIntent(resultIntent);
            PendingIntent resultPendingIntent =
                    stackBuilder.getPendingIntent(
                            0,
                            PendingIntent.FLAG_UPDATE_CURRENT
                    );
            mBuilder.setContentIntent(resultPendingIntent);
            NotificationManager mNotificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
// mId allows you to update the notification later on.
            mNotificationManager.notify(0, mBuilder.build());

        }

    }
    public void onBackPressed(){
        Intent intent = new Intent(FinalBillActivity.this,MainActivity.class);
        startActivity(intent);
    }
}
