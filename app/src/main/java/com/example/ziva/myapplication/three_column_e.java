package com.example.ziva.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class three_column_e extends ArrayAdapter<Expense> {

    private LayoutInflater mInflater;
    private ArrayList<Expense> expenses;
    private int mViewResourceId;

    public three_column_e(Context context, int textViewResourceId, ArrayList<Expense> expenses) {
        super(context, textViewResourceId, expenses);
        this.expenses = expenses;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
}
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(mViewResourceId, null);

        Expense expense = expenses.get(position);

        if (expense != null) {
            TextView date = convertView.findViewById(R.id.date);
            TextView income = convertView.findViewById(R.id.income);
            TextView expense1 = convertView.findViewById(R.id.expense);
            if (date != null) {
                date.setText(Expense.getDate());
            }
            if (income != null) {
                income.setText((Expense.getIncome()));
            }
            if (expense1 != null) {
                expense1.setText((Expense.getExpense()));
            }
        }

        return convertView;
    }
}

