package com.example.ziva.myapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class view_expense extends AppCompatActivity
{
    public ExpenseSQL DH;
    ArrayList<Expense> EList;
    ListView listView;
    Expense E;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expense);
        Toolbar toolbar = findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Expense");
        // 返回鍵
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        DH = new ExpenseSQL(this);
        getdata();


    }
    public void getdata()
    {
        EList = new ArrayList<>();
        Cursor data = DH.getData();
        int numRows = data.getCount();
        if(numRows == 0){
            Toast.makeText(view_expense.this,"The Database is empty  :(.",Toast.LENGTH_LONG).show();
        }
        else{
            int i=0;
            while(data.moveToNext()){
                E = new Expense(data.getString(0),data.getString(1),data.getString(2));
                EList.add(i,E);
                System.out.println(data.getString(0)+" "+data.getString(1)+" "+data.getString(2));
                System.out.println(EList.get(i).getDate());
                i++;
            }
            three_column_e adapter =  new three_column_e(this,R.layout.expense_list, EList);
            listView = findViewById(R.id.listView);
            listView.setAdapter(adapter);
        }
    }


}
