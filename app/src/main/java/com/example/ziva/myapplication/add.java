package com.example.ziva.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class add extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Intent intent = getIntent();
        Toolbar toolbar = findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Add Activity");


        // 返回鍵
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
    }
    public void open_calorie(View view){
        Intent intent = new Intent(this, add_calorie.class);
        startActivity(intent);
    }
    public void open_expense(View view){
        Intent intent = new Intent(this, add_expense.class);
        startActivity(intent);
    }
    public void open_water(View view){
        Intent intent = new Intent(this, add_water.class);
        startActivity(intent);
    }
    public void open_idea(View view){
        Intent intent = new Intent(this, add_idea.class);
        startActivity(intent);
    }
}
