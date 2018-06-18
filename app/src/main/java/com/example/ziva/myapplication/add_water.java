package com.example.ziva.myapplication;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class add_water extends AppCompatActivity {


    private EditText eddetail;
    private EditText edAmount;
    private Button Butt1;
    public WaterSQL DH;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_water);

        Toolbar toolbar = findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Add Water Intake");
        // 返回鍵
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        DH = new WaterSQL(this);
        eddetail=(EditText)findViewById(R.id.ed_info);
        edAmount=(EditText)findViewById(R.id.ed_amount);
        Butt1=(Button)findViewById(R.id.add);
        button2=(Button)findViewById(R.id.button2);
        AddData();
        delete();

    }
    public void AddData()
    {

        Butt1.setOnClickListener(new View.OnClickListener()
        {
            @RequiresApi(api = Build.VERSION_CODES.N)
            public void onClick(View v)
            {
                String t1 = eddetail.getText().toString();
                String t2=edAmount.getText().toString();
//                CalorieSQL.addData(item, calorie);

                if(t1.isEmpty() || t2.isEmpty())
                {
                    Toast.makeText(add_water.this,"Fill Both Columns",Toast.LENGTH_LONG).show();
                }
                else {
//                    Bundle extras = getIntent().getExtras();
//                    String values = null;
//                    if (extras != null) {
//                        values = extras.getString("c");
//                    }
                    String values = MainActivity.getdata();
                    long id = DH.addData(values, t1, t2);
                    Toast.makeText(add_water.this, "success", Toast.LENGTH_LONG).show();
                    Intent view = new Intent(add_water.this, view_water.class);
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
    
    public void delete(){

        button2.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                {
                    DH.delete();
                    Toast.makeText(add_water.this,"ALL DELETED!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

