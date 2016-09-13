package com.example.b50i7d.shuvamjewellers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Dell on 9/13/2016.
 */
    public class FragmentTab1 extends Fragment {

    TextView pan_no,name,no,date,order_date,particular,weight,wastage,making,rate,total,discount,signature,bought_price_value,Todays_price_value;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.final_bill_layout, container, false);

            pan_no =(TextView) rootView.findViewById(R.id.pan_no_no);
            name =(TextView) rootView.findViewById(R.id.mr_name);
            no =(TextView) rootView.findViewById(R.id.no_no);
            date =(TextView) rootView.findViewById(R.id.indate);
            Todays_price_value = (TextView) rootView.findViewById(R.id.Todays_price_value);
            order_date =(TextView) rootView.findViewById(R.id.inorder_date);
            particular =(TextView) rootView.findViewById(R.id.inparticular);
            weight =(TextView) rootView.findViewById(R.id.inweight);
            wastage =(TextView) rootView.findViewById(R.id.inwastage);
            making =(TextView) rootView.findViewById(R.id.inmaking);
            rate =(TextView) rootView.findViewById(R.id.inrate);
            total =(TextView) rootView.findViewById(R.id.intotal);
            discount = (TextView) rootView.findViewById(R.id.indiscount);
            signature = (TextView) rootView.findViewById(R.id.name_section);
            bought_price_value = (TextView) rootView.findViewById(R.id.bought_price_value);

            no.setText(getActivity().getIntent().getStringExtra("no"));
            name.setText(getActivity().getIntent().getStringExtra("names"));
            pan_no.setText(getActivity().getIntent().getStringExtra("pan_no"));
            date.setText(getActivity().getIntent().getStringExtra("date"));
            order_date.setText(getActivity().getIntent().getStringExtra("order_date"));
            particular.setText(getActivity().getIntent().getStringExtra("particular"));
            weight.setText(getActivity().getIntent().getStringExtra("weight"));
            wastage.setText(getActivity().getIntent().getStringExtra("wastage"));
            making.setText(getActivity().getIntent().getStringExtra("making"));
            rate.setText(getActivity().getIntent().getStringExtra("rate"));
            discount.setText(getActivity().getIntent().getStringExtra("discounts"));
            total.setText(getActivity().getIntent().getStringExtra("total"));
            no.setText(getActivity().getIntent().getStringExtra("no"));
            signature.setText(getActivity().getIntent().getStringExtra("names"));
            bought_price_value.setText(getActivity().getIntent().getStringExtra("total"));




            return rootView;

        }
    }
