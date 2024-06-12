package com.example.intentpassback;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView text2;
    private EditText text;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        text2=(TextView) findViewById(R.id.textId2);
        button=(Button) findViewById(R.id.buttonId2);
        button.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Intent data=new Intent();
        text=(EditText) findViewById(R.id.editId1);
        data.setData(Uri.parse(text.getText().toString()));
        setResult(RESULT_OK,data);
        finish();
    }
}