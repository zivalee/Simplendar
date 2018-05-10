package com.example.ziva.myapplication;

import android.app.DatePickerDialog;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

@RequiresApi(api = Build.VERSION_CODES.N)
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private TextView ytag, mtag, dtag, daytag;
    private Button gotoc;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    DateFormat formatDateTime = DateFormat.getDateTimeInstance();
    Calendar dateTime = Calendar.getInstance();

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ytag = (TextView) findViewById(R.id.ytext);
        mtag = (TextView) findViewById(R.id.mtext);
        dtag = (TextView) findViewById(R.id.dtext);
        daytag = (TextView) findViewById(R.id.daytext);
        gotoc = (Button) findViewById(R.id.button);


            gotoc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateDate();
                }
            });

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MMMM/d/E"); // Set your locale!
        String strDate = sdf.format(cal.getTime());

        String[] values = strDate.split("/", 0);

        ytag.setText(values[0]);
        mtag.setText(values[1]);
        dtag.setText(values[2]);
        daytag.setText(values[3]);


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
                String strDate = sdf.format(dateTime.getTime());
                String[] values = strDate.split("/", 0);
                updateTextLabel(values);
            }
        };


        private void updateTextLabel(String[] values){
            ytag.setText(values[0]);
                mtag.setText(values[1]);
                dtag.setText(values[2]);
                daytag.setText(values[3]);
        }
}


























