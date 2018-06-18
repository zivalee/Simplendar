package com.example.ziva.myapplication;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.Calendar;

@RequiresApi(api = Build.VERSION_CODES.N)
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private TextView ytag, mtag, dtag, daytag;
    private Button gotoc;
    private ImageButton add;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    DateFormat formatDateTime = DateFormat.getDateTimeInstance();
    Calendar dateTime = Calendar.getInstance();
    private static String strDate;

    @SuppressLint("WrongViewCast")
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Simplendar");
        ytag = (TextView) findViewById(R.id.ytext);
        mtag = (TextView) findViewById(R.id.mtext);
        dtag = (TextView) findViewById(R.id.dtext);
        daytag = (TextView) findViewById(R.id.daytext);
        gotoc = (Button) findViewById(R.id.button);
        add = findViewById(R.id.add);


        gotoc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateDate();
                }
            });


        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MMMM/d/E"); // Set your locale!
        strDate = sdf.format(cal.getTime());

        String[] values = strDate.split("/", 0);

        ytag.setText(values[0]);
        mtag.setText(values[1]);
        dtag.setText(values[2]);
        daytag.setText(values[3]);

        }

    public void openadd(View view){
        Intent intent = new Intent(this, add.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.calorie:
                Intent calorie = new Intent(this, view_calorie.class);
                startActivity(calorie);
                break;
            case R.id.expense:
                Intent expense = new Intent(this, view_expense.class);
                startActivity(expense);
                break;
            case R.id.water:
                Intent water = new Intent(this, view_water.class);
                startActivity(water);
                break;
            case R.id.idea:
                Intent idea = new Intent(this, view_idea.class);
                startActivity(idea);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void updateDate(){
            new DatePickerDialog(this, d, dateTime.get(Calendar.YEAR),dateTime.get(Calendar.MONTH),dateTime.get(Calendar.DAY_OF_MONTH)).show();
        }

        DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                dateTime.set(Calendar.YEAR, year);
                dateTime.set(Calendar.MONTH, monthOfYear);
                dateTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MMMM/d/E"); // Set your locale!
                strDate = sdf.format(dateTime.getTime());
                String[] values = strDate.split("/", 0);
                updateTextLabel(values);

//                Intent i = new Intent(MainActivity.this, add_calorie.class);
//                i.putExtra("c",strDate);
//                startActivity(i);
            }
        };

    public static String getdata() {
        return strDate;
    }


    private void updateTextLabel(String[] values){
            ytag.setText(values[0]);
            mtag.setText(values[1]);
            dtag.setText(values[2]);
            daytag.setText(values[3]);
        }

}
