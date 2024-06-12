package com.example.intenteasypassinbothactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    EditText edit1,edit2;
    TextView text1,text2,text3,text4;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        edit1=(EditText) findViewById(R.id.editid1);
        edit2=(EditText) findViewById(R.id.editid2);
        button1=(Button) findViewById(R.id.buttonid);
        text1=(TextView) findViewById(R.id.textid1);
        text2=(TextView) findViewById(R.id.textid2);
        text3=(TextView) findViewById(R.id.textid3);
        text4=(TextView) findViewById(R.id.textid4);
        Bundle bundle=getIntent().getExtras();
        text3.setText(bundle.getString("Key1"));
        text4.setText(Integer.toString(bundle.getInt("Key2")));

    }
    public void onClick(View v)
    {
        Intent i=new Intent(SecondActivity.this,MainActivity.class);
        String s=edit1.getText().toString();
        //int a=Integer.parseInt(edit2.getText().toString());
        i.putExtra("Key3",s);
        i.putExtra("Key4",Integer.parseInt(edit2.getText().toString()));
        setResult(1,i);
        finish();

    }
}