package com.example.lab2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

       getMenuInflater().inflate(R.menu.menuitem,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.menuid1)
        {
            Toast.makeText(this, "Menu 1 Selected", Toast.LENGTH_SHORT).show();
        }
       else if(item.getItemId()==R.id.menuid2)
        {
            Toast.makeText(this, "Menu 2 Selected", Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId()==R.id.menuid3)
        {
            Toast.makeText(this, "Menu 3 Selected", Toast.LENGTH_SHORT).show();
        }
       else if(item.getItemId()==R.id.menuid4)
        {
            Toast.makeText(this, "Menu 4 Selected", Toast.LENGTH_SHORT).show();
        }
       else if(item.getItemId()==R.id.menuid5)
        {
            Toast.makeText(this, "Menu 5 Selected", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}