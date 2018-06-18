package com.example.ziva.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class three_column_w extends ArrayAdapter<Water> {

    private LayoutInflater mInflater;
    private ArrayList<Water> waters;
    private int mViewResourceId;

    public three_column_w(Context context, int textViewResourceId, ArrayList<Water> waters) {
        super(context, textViewResourceId,waters);
        this.waters = waters;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(mViewResourceId, null);

       Water water = waters.get(position);

        if (water != null) {
            TextView date = convertView.findViewById(R.id.date);
            TextView detail = convertView.findViewById(R.id.detail);
            TextView amount = convertView.findViewById(R.id.amount);
            if (date != null) {
                date.setText(Water.getDate());
            }
            if (detail != null) {
                detail.setText((Water.getDetail()));
            }
            if (amount != null) {
                amount.setText((Water.getAmount()));
            }
        }

        return convertView;
    }
}
