package com.example.countryprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button bangladeshbutton,indiabutton,pakistanbutton;
    Intent intent;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bangladeshbutton=(Button) findViewById(R.id.bangladeshid);
        indiabutton=(Button) findViewById(R.id.indiaid);
        pakistanbutton=(Button) findViewById(R.id.pakistanid);
        bangladeshbutton.setOnClickListener(this);
        indiabutton.setOnClickListener(this);
        pakistanbutton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.bangladeshid)
        {
            intent=new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("Key1","bangladesh");
            startActivity(intent);
        }
        if(v.getId()==R.id.indiaid)
        {
            intent=new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("Key1","india");
            startActivity(intent);
        }
        if(v.getId()==R.id.pakistanid)
        {
            intent=new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("Key1","pakistan");
            startActivity(intent);
        }

    }
    public void onBackPressed()
    {
        AlertDialog.Builder alertbuilder=new AlertDialog.Builder(MainActivity.this);
        alertbuilder.setIcon(R.drawable.question);
        alertbuilder.setCancelable(true);
        alertbuilder.setTitle("County Profile");
        alertbuilder.setMessage("Do you want to exit?");
        alertbuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alertbuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               dialog.cancel();
            }
        });
        AlertDialog alert= alertbuilder.create();
        alert.show();

    }
}