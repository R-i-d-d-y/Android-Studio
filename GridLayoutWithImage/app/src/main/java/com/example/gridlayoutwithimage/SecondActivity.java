package com.example.gridlayoutwithimage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
 private TextView text;
 private ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        image=(ImageView) findViewById(R.id.image1);
        text=(TextView) findViewById(R.id.text1);

        Bundle b=getIntent().getExtras();
        image.setImageResource(b.getInt("Key2",0));
        text.setText(b.getString("Key1"));

    }
}