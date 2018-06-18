package com.example.ziva.myapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class view_idea extends AppCompatActivity {

    public IdeaSQL DH;
    ArrayList<Idea> IList;
    ListView listView;
    Idea I;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.idea);
        Toolbar toolbar = findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Idea");
        // 返回鍵
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        DH = new IdeaSQL(this);
        getdata();

    }
    public void getdata()
    {
        IList = new ArrayList<>();
        Cursor data = DH.getData();
        int numRows = data.getCount();
        if(numRows == 0){
            Toast.makeText(view_idea.this,"The Database is empty  :(.",Toast.LENGTH_LONG).show();
        }
        else{
            int i=0;
            while(data.moveToNext()){
                I = new Idea(data.getString(0),data.getString(1));
                IList.add(i,I);
                System.out.println(data.getString(0)+" "+data.getString(1));
                System.out.println(IList.get(i).getDate());
                i++;
            }
            two_column_i adapter =  new two_column_i(this,R.layout.idea_list, IList);
            listView = findViewById(R.id.listView);
            listView.setAdapter(adapter);
        }
    }

}
