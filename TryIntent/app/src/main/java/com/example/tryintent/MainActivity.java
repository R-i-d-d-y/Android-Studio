package com.example.tryintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button;
    private TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1=(TextView) findViewById(R.id.textid1);
        button=(Button) findViewById(R.id.buttonid1);
        button.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Intent i=new Intent(MainActivity.this, SecondActivity.class);
        startActivityForResult(i,1);
    }
    public void onActivityResult(int requestCode,int resultCode,Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1)
        {
            if(resultCode==RESULT_OK)
            {

                Toast.makeText(MainActivity.this,data.getData().toString(),Toast.LENGTH_LONG).show();
            }
        }
        Toast.makeText(this,Integer.toString(
                data.getIntExtra("Key4", 0)), Toast.LENGTH_SHORT).show();
    }
}