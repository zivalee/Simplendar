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

public class add_idea extends AppCompatActivity {

    private EditText Editidea;
    private Button Butt1;
    public IdeaSQL DH;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_idea);

        Toolbar toolbar = findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Add an Idea");
        // 返回鍵
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        DH = new IdeaSQL(this);
        Editidea=(EditText)findViewById(R.id.editText7);
        Butt1=(Button)findViewById(R.id.button);
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
                String t1 = Editidea.getText().toString();
//                IdeaSQL.addData(item, calorie);

                if(t1.isEmpty() )
                {
                    Toast.makeText(add_idea.this,"Fill Both Columns",Toast.LENGTH_LONG).show();
                }
                else {
//                    Bundle extras = getIntent().getExtras();
//                    String values = null;
//                    if (extras != null) {
//                        values = extras.getString("c");
//                    }
                    String values = MainActivity.getdata();
                    long id = DH.addData(values, t1);
                    Toast.makeText(add_idea.this, "success", Toast.LENGTH_LONG).show();
                    Intent view = new Intent(add_idea.this, view_idea.class);
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
                    Toast.makeText(add_idea.this,"ALL DELETED!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
