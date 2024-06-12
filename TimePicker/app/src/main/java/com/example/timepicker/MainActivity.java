package com.example.timepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
TimePicker time;
TextView text;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=(TextView) findViewById(R.id.textid);
        button=(Button) findViewById(R.id.buttonid);
        time=(TimePicker) findViewById(R.id.timepickerid);
//time.setIs24HourView(true);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t=time.getCurrentHour()+":"+time.getCurrentMinute();
                text.setText(t);
              // time.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
                 //   @Override
                   // public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                    //    text.setText(hourOfDay+":"+minute);
                   // }
               // });
            }
        });
    }
}