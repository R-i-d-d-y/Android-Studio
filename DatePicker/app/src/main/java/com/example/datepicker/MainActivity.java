package com.example.datepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button button;
TextView text;
DatePickerDialog datePickerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button) findViewById(R.id.buttonid);
        text=(TextView) findViewById(R.id.textid);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          DatePicker datePicker=new DatePicker(MainActivity.this);
           int currentyear=datePicker.getYear();
           int currentmonth=(datePicker.getMonth())+1;
           int currentday=datePicker.getDayOfMonth();
                datePickerDialog=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        text.setText(dayOfMonth+"/"+(month+1)+"/"+year);

                    }
                }, currentyear,currentmonth,currentday);
                datePickerDialog.show();
            }
        });
    }
}