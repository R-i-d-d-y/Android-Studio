package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.view.MenuItemCompat;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    private BluetoothAdapter bluetoothAdapter;
    private boolean isBluetoothEnabled = false;
    private Button bluetoothToggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Toolbar toolbar=findViewById(R.id.toolbar2);
       setSupportActionBar(toolbar);

    }
    public  boolean onCreateOptionMenu(Menu menu){
        MenuItem menuitem=menu.findItem(R.id.profileid);
        View view= MenuItemCompat.getActionView(menuitem);
        CircleImageView profileimg=view.findViewById(R.id.profileviewid);

        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        if(item.getItemId()==R.id.profileid)
        {

        }
        if(item.getItemId()==R.id.editprofileid)
        {

        }
        return super.onOptionsItemSelected(item);
    }
}