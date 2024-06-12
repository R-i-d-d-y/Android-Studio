package com.example.myapplication4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
private Button button;
Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button) findViewById(R.id.buttonid);
        if(getSupportActionBar()!=null);
        getSupportActionBar().hide();
    }
    public void onClick(View v)
    {
        intent=new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }
}