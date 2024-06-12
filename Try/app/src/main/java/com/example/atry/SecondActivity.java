package com.example.atry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView text3,text4;
    private EditText edit3,edit4;
    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        text3=(TextView) findViewById(R.id.textid3);
        text4=(TextView) findViewById(R.id.textid4);
        edit4=(EditText) findViewById(R.id.edittext4);
        button2=(Button) findViewById(R.id.buttonid2);
        button2.setOnClickListener(this);
       // Bundle bundle=getIntent().getExtras();
       // Toast.makeText(this, bundle.getString("Key1"), Toast.LENGTH_SHORT).show();
       // Toast.makeText(this, Integer.toString(bundle.getInt("Key2")), Toast.LENGTH_SHORT).show();


        //using normal putExtra
        Intent got=getIntent();
        Toast.makeText(this, got.getStringExtra("Key1"), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, Integer.toString(got.getIntExtra("Key2",0)), Toast.LENGTH_SHORT).show();


        //using bundle
        Bundle bundle=getIntent().getExtras();
        Toast.makeText(this, bundle.getString("Key5"), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, Integer.toString(bundle.getInt("Key6")), Toast.LENGTH_SHORT).show();

        //age string hisebe pathale etake string e konvert korte hobe na ekhane
        //kintu age Integer.pasreInt mane number akare pathale ekhane eshe abar
        //string e convert korte hobe
        //bundle diye show korale int data te getStrng/getInt use hobe & default value lagbe na
        //but putextra diye pathale normally show korte gele getStringExtra/getIntExtra & default value lagbe
    }
    @Override
    public void onClick(View v) {
        Intent i=new Intent();


        //using bundle pass data to main
        Bundle bundle=new Bundle();
        bundle.putString("Key7","Through bundle");
        bundle.putInt("Key8",Integer.parseInt(edit4.getText().toString()));
        i.putExtras(bundle);

        //passing to main using putExtra
        i.putExtra("Key4",Integer.parseInt(edit4.getText().toString()));


        edit3=(EditText) findViewById(R.id.edittext3);
        //pASSING DATA USING SETdATA
        i.setData(Uri.parse(edit3.getText().toString()));
        setResult(RESULT_OK,i);
        finish();


    }
}