package com.example.ziva.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class three_column_c extends ArrayAdapter<Calorie> {

    private LayoutInflater mInflater;
    private ArrayList<Calorie> calories;
    private int mViewResourceId;

    public three_column_c(Context context, int textViewResourceId, ArrayList<Calorie> calories) {
        super(context, textViewResourceId, calories);
        this.calories = calories;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(mViewResourceId, null);

        Calorie calorie = calories.get(position);

        if (calorie != null) {
            TextView date = convertView.findViewById(R.id.date);
            TextView item = convertView.findViewById(R.id.item);
            TextView ca = convertView.findViewById(R.id.calorie);
            if (date != null) {
                date.setText(Calorie.getDate());
            }
            if (item != null) {
                item.setText((Calorie.getItem()));
            }
            if (ca != null) {
                ca.setText((Calorie.getCalorie()));
            }
        }

        return convertView;
    }
}
