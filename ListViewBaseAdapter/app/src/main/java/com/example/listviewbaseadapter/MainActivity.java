package com.example.listviewbaseadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String[] countryNames;
    int[] flags={R.drawable.afghanistan,R.drawable.bangladesh,R.drawable.canada,R.drawable.denmark,
                 R.drawable.egypt,R.drawable.france,R.drawable.germany,R.drawable.hongkong,R.drawable.italy,
                 R.drawable.japan,R.drawable.korea,R.drawable.libya };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        countryNames=getResources().getStringArray(R.array.Country_names);
        CustomAdapter adapter=new CustomAdapter(this,countryNames,flags);
        listView.setAdapter(adapter);
    }
}