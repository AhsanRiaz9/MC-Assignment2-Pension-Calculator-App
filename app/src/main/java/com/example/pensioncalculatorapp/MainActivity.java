package com.example.pensioncalculatorapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener
{

    Button btn1,btn2,btn3;
    Calendar c1,c2,c3;
    TextView totalAge, totalService, ageRate;
    int month,day, year;
    int currentBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        c1 = Calendar.getInstance();
        c2 = Calendar.getInstance();
        c3 = Calendar.getInstance();
        totalAge = findViewById(R.id.totalAge);
        totalService = findViewById(R.id.totalService);
        ageRate = findViewById(R.id.ageRate);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentBtn = 1;
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentBtn = 2;
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentBtn = 3;
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });
    }
    @Override
    public void onDateSet(DatePicker view, int year,int month,int day)
    {
        String currentDateString;
        currentDateString = Integer.toString(day) + "/" + Integer.toString(month) + "/" + Integer.toString(year);
        if(currentBtn == 1)
        {
            c1.set(Calendar.YEAR, year);
            c2.set(Calendar.MONTH, month);
            c2.set(Calendar.DAY_OF_MONTH, day);
            btn1.setText(currentDateString);
        }
        else if(currentBtn == 2)
        {
            c3.set(Calendar.YEAR, year);
            c3.set(Calendar.MONTH, month);
            c3.set(Calendar.DAY_OF_MONTH, day);
            btn2.setText(currentDateString);
        }
        else if(currentBtn == 3)
        {
            c3.set(Calendar.YEAR, year);
            c3.set(Calendar.MONTH, month);
            c3.set(Calendar.DAY_OF_MONTH, day);
            btn3.setText(currentDateString);
        }
    }



}