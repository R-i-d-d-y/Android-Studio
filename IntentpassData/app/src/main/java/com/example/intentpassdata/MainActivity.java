package com.example.intentpassdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private TextView text1,text2;
private Button button;
private EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1=(TextView) findViewById(R.id.textId1);
        text2=(TextView) findViewById(R.id.textId2);
        text=(EditText) findViewById(R.id.editId1);
        button= (Button) findViewById(R.id.button1);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String s=text2.getText().toString();
        String s1=text.getText().toString();
        Intent intent=new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("Key",s);
        intent.putExtra("Key2",s1);
        startActivity(intent);

    }
}