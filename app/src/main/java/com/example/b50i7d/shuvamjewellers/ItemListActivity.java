package com.example.b50i7d.shuvamjewellers;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by B50i7D on 9/3/2016.
 */
public class ItemListActivity extends Activity {
    LinearLayout holder;
    Dbhelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_list_activity);
        holder = (LinearLayout) findViewById(R.id.holder);
        dbhelper = new Dbhelper(this);
        populateUserList();
    }
    @Override
    protected void onResume() {
        super.onResume();
    }
    public void populateUserList(){
        ArrayList<UserInfo> list = dbhelper.getUserList();
        holder.removeAllViews();
        for(int i =0;i<list.size();i++){
            final UserInfo info = list.get(i);

            View view = LayoutInflater.from(this).inflate(R.layout.list_item_layout,null);


            holder.addView(view);
        }
    }
}
