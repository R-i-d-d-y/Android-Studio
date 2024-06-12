package com.example.intentpassdata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private TextView text3,text4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        text3=(TextView) findViewById(R.id.textId3);
        text4=(TextView) findViewById(R.id.textId4);
        String str=getIntent().getStringExtra("Key");
        String str2=getIntent().getStringExtra("Key2");
        Toast.makeText(this,str2,Toast.LENGTH_LONG).show();
        text4.setText(str);
        finish();

    }
}