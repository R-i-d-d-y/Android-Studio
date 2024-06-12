package com.example.intenteasypassinbothactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edit1,edit2;
    TextView text1,text2,text3,text4;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit1=(EditText) findViewById(R.id.editid1);
        edit2=(EditText) findViewById(R.id.editid2);
        button1=(Button) findViewById(R.id.buttonid);
        text1=(TextView) findViewById(R.id.textid1);
        text2=(TextView) findViewById(R.id.textid2);
        text3=(TextView) findViewById(R.id.textid3);
        text4=(TextView) findViewById(R.id.textid4);

    }
    public void onClick(View v)
    {
        Intent intent=new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("Key1",edit1.getText().toString());
        intent.putExtra("Key2",Integer.parseInt(edit2.getText().toString()));
        startActivityForResult(intent,1);
    }
    public void onActivityResult(int requestCode,int resultCode,Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1)
        {
            String s1=data.getStringExtra("Key3");
            String s2=Integer.toString(data.getIntExtra("Key4",0));

            text3.setText(s1);
            text4.setText(s2);

        }
    }
}