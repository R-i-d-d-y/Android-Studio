package com.example.framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity implements View.OnClickListener {
private ImageView img1,img2,img3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1=(ImageView) findViewById(R.id.imageid1);
        img2=(ImageView) findViewById(R.id.imageid2);
        img3=(ImageView) findViewById(R.id.imageid3);
        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.imageid1)
        {
            img1.setVisibility(View.GONE);
            img2.setVisibility(View.VISIBLE);
            img3.setVisibility(View.GONE);
        }
     else   if(v.getId()==R.id.imageid2)
        {
            img1.setVisibility(View.GONE);
            img2.setVisibility(View.GONE);
            img3.setVisibility(View.VISIBLE);
        }
     else   if(v.getId()==R.id.imageid3)
        {
            img1.setVisibility(View.VISIBLE);
            img2.setVisibility(View.GONE);
            img3.setVisibility(View.GONE);
        }
    }
}