package com.example.menu;

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
        Toolbar toolbar= findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_item,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.setid)
        {
            Toast.makeText(this,"Menu 1 selected",Toast.LENGTH_SHORT).show();
            return true;
        }
        if(item.getItemId()==R.id.setid1)
        {
            Toast.makeText(this,"Menu 2 selected",Toast.LENGTH_SHORT).show();
            return true;
        }
        if(item.getItemId()==R.id.setid2)
        {
            Toast.makeText(this,"Menu 3 selected",Toast.LENGTH_SHORT).show();
            return true;
        }
        if(item.getItemId()==R.id.setid3)
        {
            Toast.makeText(this,"Menu 4 selected",Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}