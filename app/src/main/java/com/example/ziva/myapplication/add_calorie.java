package com.example.ziva.myapplication;

import android.app.Notification;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class add_calorie extends AppCompatActivity {

    private EditText Edititem;
    private EditText Edit1;
    private Button Butt1;
    public CalorieSQL DH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_calorie);

        Toolbar toolbar = findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Add Calorie Intake");
        // 返回鍵
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        DH = new CalorieSQL(this);
        Edititem=(EditText)findViewById(R.id.edititem);
        Edit1=(EditText)findViewById(R.id.edit1);
        Butt1=(Button)findViewById(R.id.butt1);
        AddData();


    }

    public void AddData()
    {

        Butt1.setOnClickListener(new View.OnClickListener()
        {
            @RequiresApi(api = Build.VERSION_CODES.N)
            public void onClick(View v)
            {
                String t1 = Edititem.getText().toString();
                String t2=Edit1.getText().toString();
//                CalorieSQL.addData(item, calorie);

                if(t1.isEmpty() || t2.isEmpty())
                {
                    Toast.makeText(add_calorie.this,"Fill Both Columns",Toast.LENGTH_LONG).show();
                }
                else {
//                    Bundle extras = getIntent().getExtras();
//                    String values = null;
//                    if (extras != null) {
//                        values = extras.getString("c");
//                    }
                    String values = MainActivity.getdata();
                    long id = DH.addData(values, t1, t2);
                    Toast.makeText(add_calorie.this, "success", Toast.LENGTH_LONG).show();
                    Intent view = new Intent(add_calorie.this, view_calorie.class);
                    startActivity(view);
//                    if(id>=0)
//                    {
//                        Toast.makeText(add_calorie.this,"Data successfully inserted!",Toast.LENGTH_LONG).show();                        Edititem.setText("");
//                        Edit1.setText("");
//                    } else
//                    {
//                        Toast.makeText(add_calorie.this,"Error!!Please try again.",Toast.LENGTH_LONG).show();
//                        Edititem.setText("");
//                        Edit1.setText("");
//                    }
                }
            }
        });

    }

    }

