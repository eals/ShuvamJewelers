package com.example.b50i7d.shuvamjewellers;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FinalActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));


    }

    public void onBackPressed(){
        Intent intent = new Intent(FinalActivity.this,MainActivity.class);
        startActivity(intent);
    }
}



class MyPagerAdapter extends FragmentPagerAdapter {

    public MyPagerAdapter(FragmentManager fragmentManager){
        super(fragmentManager);

    }
    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        switch(position){
            case 0:
                FragmentTab1 fm =   new FragmentTab1();
                return fm;
            case 1:
                FragmentTab2 fm2 = new FragmentTab2();
                return fm2;

        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }


}

