package com.example.ziva.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class two_column_i extends ArrayAdapter<Idea> {

    private LayoutInflater mInflater;
    private ArrayList<Idea> ideas;
    private int mViewResourceId;

    public two_column_i(Context context, int textViewResourceId, ArrayList<Idea> ideas) {
        super(context, textViewResourceId, ideas);
        this.ideas = ideas;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(mViewResourceId, null);

        Idea idea = ideas.get(position);

        if (idea != null) {
            TextView date = convertView.findViewById(R.id.date);
            TextView idea1 = convertView.findViewById(R.id.idea);
            if (date != null) {
                date.setText(Idea.getDate());
            }
            if (idea1 != null) {
                idea1.setText((Idea.getIdea()));
            }

        }

        return convertView;
    }
}
