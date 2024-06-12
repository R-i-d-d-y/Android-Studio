package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Lifecycle","OnCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lifecycle","OnStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lifecycle","OnResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lifecycle","OnPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lifecycle","OnStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Lifecycle","OnRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lifecycle","OnDestroy()");
    }
}