package com.example.b50i7d.shuvamjewellers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Vaio Home on 11/28/2015.
 */


/**
 * Created by Edwin on 18/01/2015.
 */

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    ArrayList<UserInfo> dataset;
    Dbhelper dbhelper;
    public CardAdapter(Context context) {
        super();

        dbhelper = new Dbhelper(context);
        dataset = dbhelper.getUserList();

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recyclerviewitem, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
        final UserInfo info = dataset.get(i);
        viewHolder.itemName.setText(info.particular);
        viewHolder.itemDate.setText(info.date);
    }

    @Override
    public int getItemCount() {
     return dataset.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView itemName,itemDate;

        public ViewHolder(View itemView) {
            super(itemView);
            itemName = (TextView)itemView.findViewById(R.id.iteminfo);
            itemDate = (TextView)itemView.findViewById(R.id.datefor_main);
        }


    }
}
