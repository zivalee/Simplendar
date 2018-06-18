package com.example.ziva.myapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class view_water extends AppCompatActivity {

    public WaterSQL DH;
    ArrayList<Water> WList;
    ListView listView;
    Water W;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.water);
        Toolbar toolbar = findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Water");
        // 返回鍵
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        DH = new WaterSQL(this);
        getdata();

    }

    public void getdata()
    {
        WList = new ArrayList<>();
        Cursor data = DH.getData();
        int numRows = data.getCount();
        if(numRows == 0){
            Toast.makeText(view_water.this,"The Database is empty  :(.",Toast.LENGTH_LONG).show();
        }
        else{
            int i=0;
            while(data.moveToNext()){
                W = new Water(data.getString(0),data.getString(1),data.getString(2));
                WList.add(i,W);
                System.out.println(data.getString(0)+" "+data.getString(1)+" "+data.getString(2));
                System.out.println(WList.get(i).getDate());
                i++;
            }
            three_column_w adapter =  new three_column_w(this,R.layout.water_list, WList);
            listView = findViewById(R.id.listView);
            listView.setAdapter(adapter);
        }
    }

}
