package com.example.tryintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
        edit3=(EditText) findViewById(R.id.edittext3);
        edit4=(EditText) findViewById(R.id.edittext4);
        button2=(Button) findViewById(R.id.buttonid2);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i=new Intent();
      // edit4=(EditText) findViewById(R.id.edittext4);
        i.putExtra("Key4",Integer.parseInt(edit4.getText().toString()));
        i.setData(Uri.parse(edit3.getText().toString()));
        //edit3=(EditText) findViewById(R.id.edittext3);

        setResult(RESULT_OK,i);
        finish();
    }
}




   