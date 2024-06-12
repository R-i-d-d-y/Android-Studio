package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private CheckBox check1,check2,check3,check4;
private Button button;
private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        check1=(CheckBox) findViewById(R.id.checkId1);
        check2=(CheckBox) findViewById(R.id.checkId2);
        check3=(CheckBox) findViewById(R.id.checkId3);
        check4=(CheckBox) findViewById(R.id.checkId4);
        text=(TextView) findViewById(R.id.text1) ;
        button=(Button) findViewById(R.id.buttonId);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        StringBuilder builder = new StringBuilder();
        if (check1.isChecked()) {
            String s = check1.getText().toString();
            builder.append(s + " is checked\n");
        }
        if (check2.isChecked()) {
            String s = check2.getText().toString();
            builder.append(s + " is checked\n");
        }
        if (check3.isChecked()) {
            String s = check3.getText().toString();
            builder.append(s + " is checked\n");
        }
        if (check4.isChecked()) {
            String s = check4.getText().toString();
            builder.append(s + " is checked\n");
        }
        text.setText(builder);
    }
}