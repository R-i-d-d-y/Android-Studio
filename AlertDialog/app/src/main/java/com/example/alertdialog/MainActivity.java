package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private Button button;
private AlertDialog.Builder alertbuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.buttonId);
        button.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
    alertbuilder=new AlertDialog.Builder(MainActivity.this);
    alertbuilder.setCancelable(false);
    alertbuilder.setTitle("Alert title");
    alertbuilder.setMessage(R.string.message);
    alertbuilder.setIcon(R.drawable.what);
    alertbuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Intent i =new Intent(MainActivity.this, SecondActivity.class);
   startActivity(i);
        }
    });

        alertbuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"You clicked No..",Toast.LENGTH_SHORT).show();
            }
        });
        alertbuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"You clicked cancel..",Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alert= alertbuilder.create();
        alert.show();
    }
}