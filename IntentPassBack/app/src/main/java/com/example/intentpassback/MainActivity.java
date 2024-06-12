package com.example.intentpassback;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView text1;
    private Button button2;
    int request_code=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1=(TextView) findViewById(R.id.textId1);
        button2=(Button) findViewById(R.id.buttonId1);
        button2.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this, SecondActivity.class);
        startActivityForResult(intent,request_code);
    }
    public void onActivityResult(int requestcode,int resultcode,Intent data) {
        super.onActivityResult(requestcode, resultcode, data);
        if (requestcode == request_code) {
            if (resultcode == RESULT_OK) {
                //Toast.makeText(this,data.getData().toString(),
                // Toast.LENGTH_LONG).show();
                Toast toast = new Toast(MainActivity.this);
                TextView tv=new TextView(MainActivity.this);
                Typeface t=Typeface.create("serif",Typeface.BOLD_ITALIC);
                tv.setText(data.getData().toString());
                tv.setBackgroundColor(Color.BLACK);
                tv.setTextColor(Color.WHITE);
                tv.setTextSize(30);
                tv.setPadding(30,30,30,30);
                toast.setView(tv);
                toast.show();
            }
        }
    }
}