package com.example.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
private RadioGroup grp;
private RadioButton radiobutton;
private Button button;
private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grp=(RadioGroup) findViewById(R.id.groupid);
        button=(Button) findViewById(R.id.button1);
        text=(TextView) findViewById(R.id.textId1);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int selectid=grp.getCheckedRadioButtonId();
        radiobutton=(RadioButton) findViewById(selectid);
        text.setText("You have selected "+radiobutton.getText().toString());
    }
}