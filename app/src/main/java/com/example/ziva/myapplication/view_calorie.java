package com.example.ziva.myapplication;

import android.database.Cursor;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;



public class view_calorie extends AppCompatActivity {

    public CalorieSQL DH;
    ArrayList<Calorie> CList;
    ListView listView;
    Calorie C;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calorie);
        Toolbar toolbar = findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Calorie");
        // 返回鍵
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        DH = new CalorieSQL(this);

        button2=(Button)findViewById(R.id.button2);
        getdata();

    }

    public void getdata()
    {
        CList = new ArrayList<>();
        Cursor data = DH.getData();
        int numRows = data.getCount();
        if(numRows == 0){
            Toast.makeText(view_calorie.this,"The Database is empty  :(.",Toast.LENGTH_LONG).show();
        }
        else{
            int i=0;
            while(data.moveToNext()){
                C = new Calorie(data.getString(0),data.getString(1),data.getString(2));
                CList.add(i,C);
                System.out.println(data.getString(0)+" "+data.getString(1)+" "+data.getString(2));
                System.out.println(CList.get(i).getDate());
                i++;
            }
            three_column_c adapter =  new three_column_c(this,R.layout.calorie_list, CList);
            listView = findViewById(R.id.listView);
            listView.setAdapter(adapter);
        }
    }


}
